package books.funreactdomainmodels.ch3

import java.util.{Date, Calendar} // replace with something better
import scala.util.{Try, Success, Failure}

// Interface for Account entity and the various types of accounts
trait Account {
    import AccountEntities._
    
    def acctId: String
    def custId: String
    def dateOfOpening: Date
    def dateOfClose: Option[Date]
    def balance: Balance
}

trait IntrestBearingAccount extends Account {
    def rateOfInterest: BigDecimal
}

trait AccountService {
    import scala.util.{Try, Success, Failure}
    import AccountEntities._ // TODO: parameterize
    type Amount = BigDecimal
    
    //def transfer(fromAccount: Account, toAccount: Account, amount: Amount): Option[Amount]
    
    def verifyCustomer(customer: Customer): Try[Customer]
    
    def openCheckingAccount(
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
object Account extends AccountService {
    import AccountEntities._
    
    def today = Calendar.getInstance.getTime
    
    // Factory
    def checkingAccount(
        customer: Customer, 
        effectiveDate: Date, 
        balance: Balance = Balance(0.0)
    ): Try[CheckingAccount] = {
        Success(CheckingAccount(
            "STUB_ID", 
            customer.id, 
            effectiveDate, 
            None,
            balance
        ))
    }
    
    def savingsAccount(
        customer: Customer, 
        effectiveDate: Date, 
        balance: Balance = Balance(0.0)
    ): Try[SavingsAccount] = {
        Success(SavingsAccount(
            "STUB_ID", 
            customer.id,
            effectiveDate, 
            None,
            0.0,
            balance
        ))
    }
    
    def openCheckingAccount(
        customer: Customer, effectiveDate: Date, balance: Balance
    ): Try[CheckingAccount] = {
        // TODO: Account opening logic
        //Account(accountNo, openingDate, customer.name, customer.address)
        checkingAccount(customer, effectiveDate, balance)
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





