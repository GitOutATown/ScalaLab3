package courses.coursera.reactive_programming.week2

object BankAcct_client_2 extends App {
	println("-->Creating consolidated Signal")  
  	def consolidated(accts: List[BankAccount2]): Signal[Int] =
		Signal(accts.map(_.balance()).sum)
	
	println("-->Creating new acct2")
	val acct2 = new BankAccount2
	println("-->acct2 bal: " + acct2.balance()) // balance() calls Signal.apply
	//acct2.balance() = 50 // This is bad: Direct access to balance!
	//println("acct2 bal: " + acct2.balance())
	
	println("-->Creating new acct3")
	val acct3 = new BankAccount2
	println("-->acct3 bal: " + acct3.balance()) // balance() calls Signal.apply
	
	println("-->Creating new acct4")
	val acct4 = new BankAccount2
	println("-->acct4 bal: " + acct4.balance()) // balance() calls Signal.apply
	
	println("-->Calling consolitated for list of accts")
	val acctsTotal = consolidated(List(acct2, acct3, acct4))
	println("-->acctsTotal: " + acctsTotal())
	
	println("-->Depositing 50 in acct2")
	acct2 deposit 50
	println("-->acct2 bal: " + acct2.balance())
	println("-->acctsTotal: " + acctsTotal())
	
	println("-->Withdraw 20 from acct2")
	acct2 withdraw 20
	println("-->Deposit 100 to acct3")
	acct3 deposit 100
	println("-->acctsTotal: " + acctsTotal())
	
	println("-->Creating xchange Signal(246.00)")
  	val xchange = Signal(246.00)
  	
  	println("-->Creating inDollars Signal(acctsTotal() * xchange()")
  	val inDollars = Signal(acctsTotal() * xchange())
  	
  	println("-->inDollars: " + inDollars())
  	
  	println("-->Withdraw 40 from acct3")
  	acct3 withdraw 40
  
  	println("-->inDollars: " + inDollars())
}



