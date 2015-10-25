package books.funreactdomainmodels.ch2.lab

import Listing_2_4._

object Listing_2_4_client_1 {

  val a1 = SavingsAccount("a-0001", "ibm", Balance(100000), 0.12)
                                                  //> a1  : books.funreactdomainmodels.ch2.lab.Listing_2_4.SavingsAccount = Saving
                                                  //| sAccount(a-0001,ibm,Balance(100000),0.12)
  val a2 = SavingsAccount("a-0002", "google", Balance(2000000), 0.13)
                                                  //> a2  : books.funreactdomainmodels.ch2.lab.Listing_2_4.SavingsAccount = Saving
                                                  //| sAccount(a-0002,google,Balance(2000000),0.13)
  val a3 = SavingsAccount("a-0003", "chase", Balance(125000), 0.15)
                                                  //> a3  : books.funreactdomainmodels.ch2.lab.Listing_2_4.SavingsAccount = Saving
                                                  //| sAccount(a-0003,chase,Balance(125000),0.15)
  val accounts = List(a1, a2, a3)                 //> accounts  : List[books.funreactdomainmodels.ch2.lab.Listing_2_4.SavingsAccou
                                                  //| nt] = List(SavingsAccount(a-0001,ibm,Balance(100000),0.12), SavingsAccount(a
                                                  //| -0002,google,Balance(2000000),0.13), SavingsAccount(a-0003,chase,Balance(125
                                                  //| 000),0.15))
    
  accounts.map(calculateInterest).map(deductTax)  //> res0: List[BigDecimal] = List(10800.000, 234000.000, 16875.000)
  accounts.map(calculateInterest andThen deductTax)
                                                  //> res1: List[BigDecimal] = List(10800.000, 234000.000, 16875.000)
  accounts.map(deductTax compose calculateInterest)
                                                  //> res2: List[BigDecimal] = List(10800.000, 234000.000, 16875.000)
}