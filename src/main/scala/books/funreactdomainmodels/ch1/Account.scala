package books.funreactdomainmodels.ch1

// Interface for Account entity and the various types of accounts
trait Account {
    // ...
}
case class CheckingAccount() extends Account //.. parameters
case class SavingsAccount() extends Account //.. parameters
case class MoneyMarketAccount() extends Account //.. parameters

// companion object in Scala that contains the factory
object Account {
    // factory method that instantiates accounts
    def apply() { //.. parameters
        // instantiate checking, savings, or money market account
        // depending on parameters
    }
}