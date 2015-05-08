package courses.coursera.reactive_programming.week3

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import scala.util.Random

/**
 * A Scala 'Future' example from the Scala Cookbook.
 * @see <a href="http://shop.oreilly.com/product/0636920026914.do" title="http://shop.oreilly.com/product/0636920026914.do">http://shop.oreilly.com/product/0636920026914.do</a>
 */
object FuturesExample3 extends App {
   
  /*
   * The most general form of registering a callback is by using the onComplete method, 
   * which takes a callback function of type Try[T] => U. The callback is applied to 
   * the value of type Success[T] if the future completes successfully, or to a value 
   * of type Failure[T] otherwise.
   */
  
  // not too exciting, the result will always be 42. but more importantly, when?
  println("1 - starting calculation ...")
  val f = Future[Int] {
    sleep(Random.nextInt(5000))
    42
  }
 
  println("2- before onComplete")
  f.onComplete {
    case Success(value) => println(s"Got the callback, meaning = $value")
    case Failure(e) => e.printStackTrace
  }
 
  // do the rest of your work
  for(i <- 1 to 50) {
    println(i + "..."); sleep(100)
  }
   
  // keep the jvm alive (may be needed depending on how you run the example)
  //sleep(2000)
  def sleep(duration: Long) { Thread.sleep(duration) }
 
}