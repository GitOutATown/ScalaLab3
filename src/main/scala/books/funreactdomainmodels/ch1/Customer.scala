package books.funreactdomainmodels.ch1

object Customer {
    
    def getStubCustomer() = Customer(1, "Joe Stub", Address()) // TODO: STUB
}

case class Customer(id: Int, name: String, address: Address)

object Verifications {
    def verifyRecord(customer: Customer): Boolean = {
        true // TODO: STUB
    }
}