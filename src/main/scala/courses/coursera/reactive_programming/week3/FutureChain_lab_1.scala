package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global

/* http://docs.scala-lang.org/overviews/core/futures.html
 * >>>This example works, but is inconvenient for two reasons. First, we have 
 * to use onSuccess, and we have to nest the second purchase future within it. 
 * Imagine that after the purchase is completed we want to sell some other 
 * currency. We would have to repeat this pattern within the onSuccess callback, 
 * making the code overly indented, bulky and hard to reason about.
 * Second, the purchase future is not in the scope with the rest of the code; 
 * it can only be acted upon from within the onSuccess callback. This means 
 * that other parts of the application do not see the purchase future and 
 * cannot register another onSuccess callback to it, for example, to sell some 
 * other currency.<<<
 */
object FutureChain_lab_1 extends App {
    
    import courses.coursera.reactive_programming.week3.TradingServices._

    val rateQuote = Future[Double] { getCurrentValue }
    
    rateQuote onSuccess { case quote =>
        // Nesting indicates dependency. So although calls are asynchronous, there is none the less a sequential ordering of dependent behavior.
        val purchase = Future[Int] {
            if (isProfitable(quote)) {
                buy(amount, quote)
            }
            else throw new Exception("not profitable")
        }
    
        purchase onSuccess {
            case amountPurchased => println("Purchased " + amountPurchased)
        }
        
        purchase onFailure {
            case e => println("Exception: " + e)
        }
    } // rateQuote onSuccess
    
    // ------------------------ //
    
    val amount = 50
    
    println("TCB")
    Thread.sleep(3000) // keep jvm running long enough for futures to complete
    println("JVM leaving the house.")
}




