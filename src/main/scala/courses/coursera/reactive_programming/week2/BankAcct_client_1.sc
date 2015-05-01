package courses.coursera.reactive_programming.week2
 
object BankAcct_client_1 {
	
	val acct1 = new BankAccount               //> acct1  : courses.coursera.reactive_programming.week2.BankAccount = courses.c
                                                  //| oursera.reactive_programming.week2.BankAccount@1c1b77f8
	acct1 deposit 50
	acct1 withdraw 20                         //> res0: Int = 30
	acct1 withdraw 10                         //> res1: Int = 20
	// acct1 withdraw 25 // Insificient funds
	
	// ---------------------------- //
	
	def consolidated(accts: List[BankAccount2]): Signal[Int] =
		Signal(accts.map(_.balance()).sum)//> consolidated: (accts: List[courses.coursera.reactive_programming.week2.BankA
                                                  //| ccount2])courses.coursera.reactive_programming.week2.Signal[Int]
	
	val acct2 = new BankAccount2              //> acct2  : courses.coursera.reactive_programming.week2.BankAccount2 = courses.
                                                  //| coursera.reactive_programming.week2.BankAccount2@5175f214
	val acct3 = new BankAccount2              //> acct3  : courses.coursera.reactive_programming.week2.BankAccount2 = courses.
                                                  //| coursera.reactive_programming.week2.BankAccount2@166828d4
  val acctsTotal = consolidated(List(acct2, acct3))
                                                  //> acctsTotal  : courses.coursera.reactive_programming.week2.Signal[Int] = cour
                                                  //| ses.coursera.reactive_programming.week2.Signal@78d377df
  acctsTotal()                                    //> res2: Int = 0
	
	acct2 deposit 50
  acctsTotal()                                    //> res3: Int = 50
	acct2 withdraw 20                         //> res4: Int = 30
  acct3 deposit 100
  acctsTotal()                                    //> res5: Int = 130
  val xchange = Signal(246.00)                    //> xchange  : courses.coursera.reactive_programming.week2.Signal[Double] = cour
                                                  //| ses.coursera.reactive_programming.week2.Signal@5a34d004
  val inDollars = Signal(acctsTotal() * xchange())//> inDollars  : courses.coursera.reactive_programming.week2.Signal[Double] = co
                                                  //| urses.coursera.reactive_programming.week2.Signal@6a9dd62a
  inDollars()                                     //> res6: Double = 31980.0
  acct3 withdraw 40                               //> res7: Int = 60
  
  inDollars()                                     //> res8: Double = 22140.0
	
}
/*








*/