package books.funreactdomainmodels.ch2

import java.util.Date // replace with something better

// Interface for Account entity and the various types of accounts
// RW: Not yet. This is in fact NOT being used! And no real context
// for such generalization has been presented/discussed.
trait Account {
    import AccountEntities._
    
    def no: String
    def name: String
    def bank: Bank
    def address: Address
    def dateOfOpening: Date
    def dateOfClose: Option[Date]
    def balance: Balance
}

trait IntrestBearingAccount extends Account {
    def rateOfInterest: BigDecimal
}

trait AccountService {
    import AccountType._
    import scala.util.{Try, Success, Failure}
    import AccountEntities._
    type Amount = BigDecimal
    
    //def transfer(fromAccount: Account, toAccount: Account, amount: Amount): Option[Amount]
    
    def verifyCustomer(customer: Customer): Option[Customer] = {
        if (Verifications.verifyRecord(customer)) Some(customer)
        else None
    }
    
    def openCheckingAccount(customer: Customer, effectiveDate: Date): CheckingAccount = {
        // TODO: Account opening logic
        //Account(accountNo, openingDate, customer.name, customer.address)
        CheckingAccount(customer, effectiveDate)
    }
    
    // This won't work because of copy only works with case classes.
    // def debitChecking[A <: Account](account: A, amount: Amount): Try[A] = {
    def debitChecking(account: CheckingAccount, amount: Amount): Try[CheckingAccount] = {
        if(account.balance.amount < amount)
            Failure(new Exception("Insufficient funds in account"))
        else
            Success(account.copy(
                balance = Balance(account.balance.amount - amount)
            ))
    }
    
    def creditChecking(account: CheckingAccount, amount: Amount): Try[CheckingAccount] = {
        Success(account.copy(
            balance = Balance(account.balance.amount + amount)
        ))
    }
    
    def calculateInterest[A <: IntrestBearingAccount](account: A, period: DateRange): Try[BigDecimal] = {
        account.rateOfInterest * account.balance.amount
        Success(0.0) // Stub
    }
    
    //val generateAuditLog: (Account, Amount) => Try[String] = ???
    //val write: String => Unit
}

object AccountService extends AccountService

object AccountType extends Enumeration {
    type AccountType = Value
    val CHECKING, SAVINGS, MONEYMARKET = Value
}

// companion object in Scala that contains the factory
object Account {
    import AccountType._
    import AccountEntities._
    
    // factory method that instantiates accounts
    def apply(
        acctType: AccountType, 
        customer: Customer, 
        effectiveDate: Date, 
        balance: Balance = Balance(0.0)
    ) = {
        // instantiate checking, savings, or money market account depending on parameters
        acctType match {
            case CHECKING => 
                CheckingAccount(
                    "STUB_ID", 
                    customer.name, 
                    Bank(), 
                    customer.address, 
                    effectiveDate, 
                    None,
                    balance
                )
            case SAVINGS => SavingsAccount(
                "STUB_ID", 
                customer.name, 
                Bank(), 
                customer.address, 
                effectiveDate, None,
                0.0,
                balance
            )
            case MONEYMARKET => MoneyMarketAccount(
                "STUB_ID",
                customer.name, 
                Bank(), 
                customer.address, 
                effectiveDate, 
                None,
                0.0,
                balance
            )
        }
    }
} // end object Account

object AccountEntities {
    case class Bank()
    
    case class Address()
    
    //case class Amount(value: BigDecimal)
    
    case class Balance(amount: BigDecimal)
    
    case class DateRange()
    
    case class CheckingAccount (
        no: String,
        name: String,
        bank: Bank,
        address: Address,
        dateOfOpening: Date,
        dateOfClose: Option[Date],
        balance: Balance
    ) extends Account

    case class SavingsAccount(
         no: String,
         name: String,
         bank: Bank,
         address: Address,
         dateOfOpening: Date,
         dateOfClose: Option[Date],
         rateOfInterest: BigDecimal,
         balance: Balance
    ) extends IntrestBearingAccount
    
    case class MoneyMarketAccount(
         no: String,
         name: String,
         bank: Bank,
         address: Address,
         dateOfOpening: Date,
         dateOfClose: Option[Date],
         rateOfInterest: BigDecimal,
         balance: Balance
    ) extends IntrestBearingAccount
    
    object CheckingAccount {
        def apply(
            customer: Customer, 
            effectiveDate: Date, 
            balance: Balance = Balance(0.0)
        ): CheckingAccount = {
            CheckingAccount(
                "STUB_ID", 
                customer.name, 
                Bank(), 
                customer.address, 
                effectiveDate, 
                None,
                balance
            )
        }
    }
    
    object SavingsAccount {
        def apply(
            customer: Customer, 
            effectiveDate: Date, 
            balance: Balance = Balance(0.0)
        ): SavingsAccount = {
            SavingsAccount(
                "STUB_ID", 
                customer.name, 
                Bank(), 
                customer.address, 
                effectiveDate, None,
                0.0,
                balance
            )
        }
    }
    
    object MoneyMarketAccount {
        def apply(
            customer: Customer, 
            effectiveDate: Date, 
            balance: Balance = Balance(0.0)
        ): MoneyMarketAccount = {
            MoneyMarketAccount(
                "STUB_ID",
                customer.name, 
                Bank(), 
                customer.address, 
                effectiveDate, 
                None,
                0.0,
                balance
            )
        }
    }
} // end AccountEntities





