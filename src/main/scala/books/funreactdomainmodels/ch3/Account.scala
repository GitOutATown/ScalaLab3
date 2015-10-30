package books.funreactdomainmodels.ch3

import java.util.{Date, Calendar}
import scala.util.{Try, Success, Failure}
import AccountEntities._
import scala.util.Failure
import scala.util.Failure

// Base contract/Interface for Account entity and the various types of accounts.
trait Account {    
    def acctId: String
    def custId: String
    def dateOfOpening: Date
    def dateOfClose: Option[Date]
    def balance: Balance
}

trait IntrestBearingAccount extends Account {
    def rateOfInterest: BigDecimal
}

// Parameterized for modularity
trait AccountService
    [Customer, Balance, Amount, CheckingAccount, 
    SavingsAccount, MoneyMarketAccount] {
    
    import scala.util.{Try, Success, Failure}
    
    /*
    def transfer(fromAccount: Account, toAccount: Account, amount: Amount)
        : Try[(Account, Account)]
    */
    
    def verifyCustomer(customer: Customer): Try[Customer]
    
    def checkingAccount(
        customer: Customer, effectiveDate: Date, balance: Balance
    ): Try[CheckingAccount]
    
    def debitChecking(account: CheckingAccount, amount: Amount)
        : Try[CheckingAccount]
    
    def creditChecking(account: CheckingAccount, amount: Amount)
        : Try[CheckingAccount]
    
    def calculateInterest[A <: IntrestBearingAccount]
        (account: A, period: DateRange): Try[BigDecimal]
    
    //val generateAuditLog: (Account, Amount) => Try[String] = ???
    //val write: String => Unit
} // end trait AccountService

// companion object in Scala that contains the factories
object Account extends AccountService
    [Customer, Balance, Amount, CheckingAccount, 
    SavingsAccount, MoneyMarketAccount] {
        
    def today = Calendar.getInstance.getTime
    
    // Factory
    def checkingAccount(
        customer: Customer, 
        effectiveDate: Date, 
        balance: Balance = Balance(0.0)
    ): Try[CheckingAccount] = {
        verifyCustomer(customer).map { c =>
            CheckingAccount(
                "STUB_ID", 
                c.id, 
                effectiveDate, 
                None,
                balance
            )
        }
    }
    
    // Factory
    def savingsAccount(
        customer: Customer, 
        effectiveDate: Date, 
        balance: Balance = Balance(0.0)
    ): Try[SavingsAccount] = {
        verifyCustomer(customer).map{ c =>
            SavingsAccount(
                "STUB_ID", 
                customer.id,
                effectiveDate, 
                None,
                0.0,
                balance
            )
        }
    }
    
    // Factory
    def moneyMarketAccount(
        customer: Customer, 
        effectiveDate: Date, 
        balance: Balance = Balance(0.0)
    ): Try[MoneyMarketAccount] = {
        verifyCustomer(customer).map{ c =>
            MoneyMarketAccount(
                "STUB_ID",
                customer.id, 
                effectiveDate, 
                None,
                0.0,
                balance
            )
        }
    }
    
    // This won't work because of copy only works with case classes.
    // def debitChecking[A <: Account](account: A, amount: Amount): Try[A] = {
    
    def debitChecking(account: CheckingAccount, amount: Amount)
        : Try[CheckingAccount] = {
        if(account.balance.amount < amount)
            Failure(new Exception("Insufficient funds in account"))
        else
            Success(account.copy(
                balance = Balance(account.balance.amount - amount)
            ))
    }
    
    def creditChecking(account: CheckingAccount, amount: Amount)
        : Try[CheckingAccount] = {
        Success(account.copy(
            balance = Balance(account.balance.amount + amount)
        ))
    }
    
    def debit(account: Account, amount: Amount): Try[Account] = {
        if(account.balance.amount < amount)
            Failure(new Exception("Insufficient funds in account"))
        else account match {
            case ch: CheckingAccount => Success(ch.copy(
                balance = Balance(account.balance.amount - amount
            )))
            case sa: SavingsAccount => Success(sa.copy(
                balance = Balance(account.balance.amount - amount
            )))
            case mm: MoneyMarketAccount => Success(mm.copy(
                balance = Balance(account.balance.amount - amount
            )))
        }
    }
    
    def credit(account: Account, amount: Amount): Try[Account] = {
        account match {
            case ch: CheckingAccount => Success(ch.copy(
                balance = Balance(account.balance.amount + amount
            )))
            case sa: SavingsAccount => Success(sa.copy(
                balance = Balance(account.balance.amount + amount
            )))
            case mm: MoneyMarketAccount => Success(mm.copy(
                balance = Balance(account.balance.amount + amount
            )))
        }
    }
    
    def transfer(fromAccount: Account, toAccount: Account, amount: Amount)
        : Try[(Account, Account)] = {
        (debit(fromAccount, amount), credit(toAccount, amount)) match {
            case (Success(from), Success(to)) => Success(from, to)
            case _ => Failure(new Exception("Transfer failed"))
        }
    }
    
    def calculateInterest[A <: IntrestBearingAccount]
        (account: A, period: DateRange): Try[BigDecimal] = {
        Success(account.rateOfInterest * account.balance.amount)
    }
    
    // ---- Verification --------- //
    
    private def closeDateCheck(
        openDate: Option[Date], closeDate: Option[Date]
    ): Try[(Date, Option[Date])] = {
        val od = openDate.getOrElse(today)
        closeDate.map { cd =>
            if (cd before od) Failure(new Exception(
                s"Close date [$cd] cannot be earlier than open date [$od]"
            ))
            else Success((od, Some(cd)))
        }.getOrElse {
            Success((od, closeDate))
        }
    }
    
    def verifyCustomer(customer: Customer): Try[Customer] = {
        if (Verifications.verifyRecord(customer)) Success(customer)
        else Failure(new Exception("Customer failed verification"))
    }
} // end object Account

object AccountEntities {
    final case class Bank private[ch3]() 
    
    final case class Address private[ch3]()
    
    //case class Amount(value: BigDecimal)
    type Amount = BigDecimal
    
    final case class Balance private[ch3](amount: BigDecimal)
    
    case class DateRange()
    
    final case class CheckingAccount private[ch3] (
        acctId: String,
        custId: String,
        dateOfOpening: Date,
        dateOfClose: Option[Date],
        balance: Balance
    ) extends Account

    final case class SavingsAccount private[ch3](
         acctId: String,
         custId: String,
         dateOfOpening: Date,
         dateOfClose: Option[Date],
         rateOfInterest: BigDecimal,
         balance: Balance
    ) extends IntrestBearingAccount
    
    final case class MoneyMarketAccount private[ch3](
         acctId: String,
         custId: String,
         dateOfOpening: Date,
         dateOfClose: Option[Date],
         rateOfInterest: BigDecimal,
         balance: Balance
    ) extends IntrestBearingAccount

} // end AccountEntities





