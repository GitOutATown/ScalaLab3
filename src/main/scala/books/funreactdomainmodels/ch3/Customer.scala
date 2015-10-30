package books.funreactdomainmodels.ch3

import AccountEntities._

object Customer {
    
    def getSuccessCustomer() = Customer("c1", "Sally Success", Address())
    def getFailCustomer() = Customer("c2", "Frank Failure", Address())
}

case class Customer(id: String, name: String, address: Address)

object Verifications {
    def verifyRecord(customer: Customer): Boolean = {
        // For demo simulation
        if(customer.name.startsWith("F")) false
        else true
    }
}