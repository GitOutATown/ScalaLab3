package courses.coursera.reactive_programming.week2

object BankAcct_client_2 extends App {
    
  	def consolidated(accts: List[BankAccount2]): Signal[Int] = {
  	  println("==>Inside def consolidated, creating Signal for accts total.")
	  Signal(accts.map(_.getBalance).sum) // Int
	}
	
	println("-->Creating new acct2")
	val acct2 = new BankAccount2
	println("-->acct2 bal: " + acct2.getBalance) // balance() calls Signal.apply
	
	//acct2.balance() = 50 // This is bad: Direct access to balance! I fixed it by protecting balance() behind getBalance
	//println("acct2 bal: " + acct2.balance())
	
	println("-->Creating new acct3")
	val acct3 = new BankAccount2
	println("-->acct3 bal: " + acct3.getBalance) // balance() calls Signal.apply
	
	println("-->Creating new acct4")
	val acct4 = new BankAccount2
	println("-->acct4 bal: " + acct4.getBalance) // balance() calls Signal.apply
	
	println("==>Calling create consolitated for list of accts")
	val acctsTotal = consolidated(List(acct2, acct3, acct4))
	println("-->acctsTotal: " + acctsTotal())
	
	println("-->Depositing 50 in acct2")
	acct2 deposit 50
	println("-->acct2 bal: " + acct2.getBalance)
	println("==>acctsTotal: " + acctsTotal())
	
	println("-->Withdraw 20 from acct2")
	acct2 withdraw 20
	println("-->Deposit 100 to acct3")
	acct3 deposit 100
	println("-->acctsTotal: " + acctsTotal())
	
	// A Var is a Signal that can be updated by the client program.
	println("-->Creating xchange Var(246.00)")
  	val xchange = Var(246.00)
  	
  	println("-->Creating inDollars Signal(acctsTotal() * xchange()")
  	val inDollars = Signal(acctsTotal() * xchange())
  	println("-->inDollars: " + inDollars())
  
  	println("-->Changing xchange to 260.00")
  	xchange() = 260.00
  	println("-->inDollars has been automatically updated: " + inDollars())
  	
  	println("-->Withdraw 40 from acct3")
  	acct3 withdraw 40
}



