package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global

object FutureChain_lab_3 extends App {
    
    // http://docs.scala-lang.org/overviews/core/futures.html
    /* >>>
     * One of the design goals for futures was to enable their use in 
     * for-comprehensions. For this reason, futures also have the flatMap, 
     * filter and foreach combinators. The flatMap method takes a function 
     * that maps the value to a new future g, and then returns a 
     * future which is completed once g is completed.
     * <<< */
    
    import courses.coursera.reactive_programming.week3.TradingServices._

    // This is pretty hacky and ugly. I don't like it, but good to experiment.
    val purchase: Future[Int] = for {
        rateQuote <- Future[Double] { getCurrentValue } // flatMap
        profitable <- Future[Boolean] { // map
            if(isProfitable(rateQuote)) true
            else throw new Exception("not profitable")
        } recover { 
            case e: ConnectionException => {
                println("In recover ConnectionException")
                if(isProfitable(rateQuote)) true
                else throw new Exception("not profitable")
            } 
        }
    } yield (buy(amount, rateQuote)) // yield is part of the map future propagation
    
    purchase onSuccess {
        case _ => println("~~Purchased " + amount + " USD")
    }
    
    purchase onFailure {
        case e => println("~~Exception: " + e)
    }
    
    // ------------------------ //
    
    val amount = 50
    
    println("TCB")
    Thread.sleep(4000) // keep jvm running long enough for futures to complete
    println("JVM leaving the house.")
}