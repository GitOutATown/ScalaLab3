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
    def transfer(fromAccount: Account, toAccount: Account, amount: Amount): Option[Amount]
}

// companion object in Scala that contains the factory
object Account {
    // factory method that instantiates accounts
    def apply() { //.. parameters
        // instantiate checking, savings, or money market account
        // depending on parameters
    }
}

case class Bank()

case class Address()

case class Amount()





