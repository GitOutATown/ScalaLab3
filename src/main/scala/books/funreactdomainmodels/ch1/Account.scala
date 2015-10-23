package books.funreactdomainmodels.ch1

import java.util.Date // replace with something better

// Interface for Account entity and the various types of accounts
trait Account {
    def no: String
    def name: String
    def bank: Bank
    def address: Address
    def dateOfOpening: Date
    def dateOfClose: Option[Date]
}

case class CheckingAccount(
     no: String,
     name: String,
     bank: Bank,
     address: Address,
     dateOfOpening: Date,
     dateOfClose: Option[Date]
) extends Account

case class SavingsAccount(
     no: String,
     name: String,
     bank: Bank,
     address: Address,
     dateOfOpening: Date,
     dateOfClose: Option[Date],
     rateOfInterest: BigDecimal
) extends Account

case class MoneyMarketAccount(
     no: String,
     name: String,
     bank: Bank,
     address: Address,
     dateOfOpening: Date,
     dateOfClose: Option[Date]        
) extends Account

trait AccountService{
    import AccountType._
    
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
    
    //object AccountService extends AccountService // TODO: This makes no sense!
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
    def apply(acctType: AccountType, customer: Customer, effectiveDate: Date) = { //.. parameters
        // instantiate checking, savings, or money market account
        // depending on parameters
        acctType match {
            case CHECKING => 
                CheckingAccount(
                    "STUB_ID", 
                    customer.name, 
                    Bank(), 
                    customer.address, 
                    effectiveDate, None
                )
            case SAVINGS => SavingsAccount(
                "STUB_ID", 
                customer.name, 
                Bank(), 
                customer.address, 
                effectiveDate, None,
                0.0
            )
            case MONEYMARKET => MoneyMarketAccount(
                "STUB_ID",
                customer.name, 
                Bank(), 
                customer.address, 
                effectiveDate, None
            )
        }
    }
}

case class Bank()

case class Address()

case class Amount()





