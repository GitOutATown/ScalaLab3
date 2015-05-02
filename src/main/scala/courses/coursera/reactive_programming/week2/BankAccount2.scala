package courses.coursera.reactive_programming.week2

class BankAccount2 {
  
  println("In BankAccount2 constructor")
  
  protected val balance = Var(0)
  
  def getBalance: Int = balance()
  
  def deposit(amount: Int): Unit =
    if (amount > 0) {
      val b = balance() // snapshot point in time value of balance
      println("Calling balance() = b + " + amount)
      /*
       * "balance() = ..." calls update, which calls computeValue and 
       * computeValue on all observers.
       * Odersky: If the Signal changes, all observers will be re-evaluated.
       */ 
      balance() = b + amount // calling update new balance with snapshot balance + amt
    }

  def withdraw(amount: Int): Int =
    if (0 < amount && amount <= balance()) {
      val b = balance() // current value of balance
      balance() = b - amount
      balance() // Signal.apply
    } 
    else throw new Error("insufficient funds");
}
