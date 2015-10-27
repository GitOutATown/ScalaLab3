package books.funreactdomainmodels.ch3

import AccountEntities._

object Customer {
    
    def getStubCustomer() = Customer("c1", "Joe Stub", Address()) // TODO: STUB
}

case class Customer(id: String, name: String, address: Address)

object Verifications {
    def verifyRecord(customer: Customer): Boolean = {
        true // TODO: STUB
    }
}