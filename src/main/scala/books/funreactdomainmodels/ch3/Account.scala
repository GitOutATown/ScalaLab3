package books.funreactdomainmodels.ch3

import java.util.{Date, Calendar} // replace with something better
import scala.util.{Try, Success, Failure}
import AccountEntities._

// Interface for Account entity and the various types of accounts.
// Base contract for all account types.
trait Account {
    //import AccountEntities._
    
    def acctId: String
    def custId: String
    def dateOfOpening: Date
    def dateOfClose: Option[Date]
    def balance: Balance
}

trait IntrestBearingAccount extends Account {
    def rateOfInterest: BigDecimal
}

trait AccountService
    [Customer, Balance, CheckingAccount, 
    SavingsAccount, MoneyMarketAccount] {
    
    import scala.util.{Try, Success, Failure}
    //import AccountEntities._ // TODO: parameterize
    type Amount = BigDecimal
    
    //def transfer(fromAccount: Account, toAccount: Account, amount: Amount): Option[Amount]
    
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
    [Customer, Balance, CheckingAccount, 
    SavingsAccount, MoneyMarketAccount] {
    
    import AccountEntities._
    
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
    
    def calculateInterest[A <: IntrestBearingAccount]
        (account: A, period: DateRange): Try[BigDecimal] = {
        Success(account.rateOfInterest * account.balance.amount)
    }
    
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
    case class Bank()
    
    case class Address()
    
    //case class Amount(value: BigDecimal)
    
    case class Balance(amount: BigDecimal)
    
    case class DateRange()
    
    case class CheckingAccount (
        acctId: String,
        custId: String,
        dateOfOpening: Date,
        dateOfClose: Option[Date],
        balance: Balance
    ) extends Account

    case class SavingsAccount(
         acctId: String,
         custId: String,
         dateOfOpening: Date,
         dateOfClose: Option[Date],
         rateOfInterest: BigDecimal,
         balance: Balance
    ) extends IntrestBearingAccount
    
    case class MoneyMarketAccount(
         acctId: String,
         custId: String,
         dateOfOpening: Date,
         dateOfClose: Option[Date],
         rateOfInterest: BigDecimal,
         balance: Balance
    ) extends IntrestBearingAccount

} // end AccountEntities





