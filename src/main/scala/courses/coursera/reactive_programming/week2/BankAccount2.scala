package courses.coursera.reactive_programming.week2

class BankAccount2 {
  
  println("In BankAccount2 constructor")
  
  val balance = Var(0)
  
  def deposit(amount: Int): Unit =
    if (amount > 0) {
      val b = balance() // snapshot point in time value of balance
      balance() = b + amount // new balance plus snapshot balance + amt
    }

  def withdraw(amount: Int): Int =
    if (0 < amount && amount <= balance()) {
      val b = balance() // current value of balance
      balance() = b - amount
      balance() // Signal.apply
    } 
    else throw new Error("insufficient funds");
}
