package books.funreactdomainmodels.ch2.lab

object Listing_2_4 {

    val calculateInterest: SavingsAccount => BigDecimal = { a =>
        a.balance.amount * a.rateOfInterest
    }
    
    // Another way of crafting the same function as above.
    def calculateInterestALT(a: SavingsAccount): BigDecimal = {
        a.balance.amount * a.rateOfInterest
    }
    
    val deductTax: BigDecimal => BigDecimal = { interest =>
        // RW: This is a strange stub for deductTax!
        if (interest < 1000) interest else (interest - 0.1 * interest)
    }
    
    trait Account {
        def no: String
        def name: String
        def balance: Balance
        def rateOfInterest: BigDecimal
    }
    
    case class SavingsAccount(
        no: String, 
        name: String,
        balance: Balance, 
        rateOfInterest: BigDecimal
    ) extends Account
    
    case class Balance(amount: BigDecimal)
    
    // ----- client ---------------- //
    
    val a1 = SavingsAccount("a-0001", "ibm", Balance(100000), 0.12)
    val a2 = SavingsAccount("a-0002", "google", Balance(2000000), 0.13)
    val a3 = SavingsAccount("a-0003", "chase", Balance(125000), 0.15)
    val accounts = List(a1, a2, a3)
    
    accounts.map(calculateInterest).map(deductTax)
    accounts.map(calculateInterest andThen deductTax)

}


