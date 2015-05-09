package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global

object FutureChain_lab_1 extends App {
  
    // http://docs.scala-lang.org/overviews/core/futures.html

    val rateQuote = Future[Double] {
        //connection.getCurrentValue(USD)
        Thread.sleep(1000)
        getCurrentValue
    }
    
    rateQuote onSuccess { case quote =>
        val purchase = Future[Int] {
            Thread.sleep(1000)
            if (isProfitable(quote)) {
                //connection.buy(amount, quote)
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
    val available = math.random
    
    def getCurrentValue: Double = {
        val rand = math.random
        rand
    }
    
    def isProfitable(quote: Double): Boolean = {
        val threshold = 0.50
        val result = quote > threshold
        result
    }
    
    def buy(amount: Int, quote: Double): Int = {
        if(amount >= available) amount
        else throw new Exception("Purchase amount not available")
    }
    
    println("TCB")
    Thread.sleep(3000)
    println("JVM leaving the house.")
}