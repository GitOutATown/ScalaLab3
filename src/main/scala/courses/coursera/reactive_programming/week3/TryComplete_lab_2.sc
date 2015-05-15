package courses.coursera.reactive_programming.week3

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random

// http://docs.scala-lang.org/overviews/core/futures.html
// http://www.srirangan.net/2013-01-controlling-flow-with-scala-futures
object TryComplete_lab_2 {

  def first[T](f: Future[T], g: Future[T]): Future[T] = {
  
	  val p = Promise[T]()
	  
	  f onSuccess {
	    case x => p.trySuccess(x)
	  }
	  
	  g onSuccess {
	    case x => p.trySuccess(x)
	  }
	  
	  p.future
	  
	} // end first                            //> first: [T](f: scala.concurrent.Future[T], g: scala.concurrent.Future[T])scal
                                                  //| a.concurrent.Future[T]
	
	val coke = Future {
    Thread.sleep(new Random().nextInt(500))
    "Coke"
  }                                               //> coke  : scala.concurrent.Future[String] = scala.concurrent.impl.Promise$Defa
                                                  //| ultPromise@374f1544
  
  val pepsi = Future {
    Thread.sleep(new Random().nextInt(500))
    "Pepsi"
  }                                               //> pepsi  : scala.concurrent.Future[String] = scala.concurrent.impl.Promise$Def
                                                  //| aultPromise@526abde0
  
  first(coke, pepsi) onSuccess { case x => println(x + " wins!") }
  
  println("Who won the race?")                    //> Who won the race?

  Thread.sleep(1500)                              //> Coke wins!

  '''                                             //> res0: Char('\'') = '
}