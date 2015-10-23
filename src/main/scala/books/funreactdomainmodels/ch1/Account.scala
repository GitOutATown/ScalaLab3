package books.funreactdomainmodels.ch1

import java.util.Date // replace with something better
import scala.util.{Try, Success, Failure}

// Interface for Account entity and the various types of accounts
trait Account {
    def no: String
    def name: String
    def bank: Bank
    def address: Address
    def dateOfOpening: Date
    def dateOfClose: Option[Date]
    def balance: Balance
}

case class CheckingAccount(
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
) extends Account

case class MoneyMarketAccount(
     no: String,
     name: String,
     bank: Bank,
     address: Address,
     dateOfOpening: Date,
     dateOfClose: Option[Date],
     balance: Balance
) extends Account

trait AccountService{
    import AccountType._
    type Amount = BigDecimal
    
    //def transfer(fromAccount: Account, toAccount: Account, amount: Amount): Option[Amount]
    
    def verifyCustomer(customer: Customer): Option[Customer] = {
        if (Verifications.verifyRecord(customer)) Some(customer)
        else None
    }
    
    def openCheckingAccount(customer: Customer, effectiveDate: Date): Account = {
        // TODO: Account opening logic
        //Account(accountNo, openingDate, customer.name, customer.address)
        Account(CHECKING, customer, effectiveDate)
    }
    
    def debitChecking(account: CheckingAccount, amount: Amount): Try[Account] = {
        if(account.balance.amount.value < amount)
            Failure(new Exception("Insufficient funds in account"))
        else
            Success(account.copy(
                balance = Balance(Amount(
                    account.balance.amount.value - amount // TODO: This is whacked ugly!
                ))
            ))
    }
    
    def creditChecking(account: CheckingAccount, amount: Amount): Try[Account] = {
        Success(account.copy(
            balance = Balance(Amount(
                account.balance.amount.value + amount // TODO: This is whacked ugly!
            ))
        ))
    }
}

object AccountService extends AccountService

object AccountType extends Enumeration {
    type AccountType = Value
    val CHECKING, SAVINGS, MONEYMARKET = Value
}

// companion object in Scala that contains the factory
object Account {
    import AccountType._
    
    // factory method that instantiates accounts
    def apply(
        acctType: AccountType, 
        customer: Customer, 
        effectiveDate: Date, 
        balance: Balance = Balance(Amount(0.0))
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
                balance
            )
        }
    }
} // end object Account

case class Bank()

case class Address()

case class Amount(value: BigDecimal)

case class Balance(amount: Amount)





