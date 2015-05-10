package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global

/* http://docs.scala-lang.org/overviews/core/futures.html
 */
object FutureChain_lab_2 extends App {
    
    import courses.coursera.reactive_programming.week3.TradingServices._
    
    /* http://docs.scala-lang.org/overviews/core/futures.html
     * >>>
     * You can reason about mapping futures in the same way you reason about 
     * mapping collections.
     * 
     * def map[S](f: Double => S)(implicit executor: ExecutionContext): Future[S]
     * Creates a new future by applying a function to the successful result of 
     * this future. If this future is completed with an exception then the new 
     * future will also contain this exception.
     * Example:
     * 
     * val f = Future { 5 }
     * val g = Future { 3 }
     * val h = for {
     *     x: Int <- f // returns Future(5) // flatMap
     *     y: Int <- g // returns Future(3) // map
     * } yield x + y
     * 
     * is translated to:
     * f flatMap { (x: Int) => g map { (y: Int) => x + y } }
     * <<<
     */
    
    /* rateQuote is Future[Double]
     * purchase is Future[Int]
     * map aleviates need for explicit declarations of onSuccess/onComplete and
     * Future for purchase .
     * map and other higher order combinators allow one Future to propagate 
     * and capture any/all Success/Failure responses (i.e. values, futures,
     * exceptions).
     * >>>This exception propagating semantics is present in the rest of the 
     * combinators, as well.<<<
     */
    
    val rateQuote = Future[Double] { getCurrentValue }
    
    /*  >>>
     *  [T]he combinators on futures are purely functional. Every combinator 
     *  returns a new future which is related to the future it was derived from.
     *  One of the basic combinators is map, which, given a future 
     *  (eg. rateQuote) and a mapping function for the value of the 
     *  [new] future (eg. purchase), produces [that] new future which 
     *  is completed with the mapped value (eg. buy/purchase amount[Int]) 
     *  once the original future (eg. rateQuote) is successfully completed.
     *  By using map on rateQuote we have eliminated one onSuccess callback 
     *  and, more importantly, the nesting.<<< (i.e. Now purchase can be accessed 
     *  independently from other callers (but the variable name might need to 
     *  be finessed)
     */
    val purchase = rateQuote map { quote => // mapping function
        if (isProfitable(quote)) buy(amount, quote) // Should buy be a future to prevent potential blocking?
        else throw new Exception("not profitable")
    }

    purchase onSuccess {
        case _ => println("~~Purchased " + amount + " USD")
    }
    
    purchase onFailure {
        case e => println("~~Exception: " + e)
    }
    
    // ------------------------ //
    
    val amount = 50
    
    println("TCB")
    Thread.sleep(3000) // keep jvm running long enough for futures to complete
    println("JVM leaving the house.")
}