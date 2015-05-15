package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global

object Futures_lab_1 {
	// In a worksheet, references must all be backwards looking,
	// so this has to come first
	def sleep(duration: Long) { blocking{ Thread.sleep(duration) } }
                                                  //> sleep: (duration: Long)Unit

	val s = "Hello"                           //> s  : String = Hello
	
	def computation = {
    println("computation (i.e. Future apply() body) gets invoked immediately upon parsing definition.")
    sleep(4000)
    println("computation is done!")
    s + " future!"
	}                                         //> computation: => String
	
	val f: Future[String] = Future {
    /* The body gets invoked immediately upon parsing definition */
	  computation
	}                                         //> computation (i.e. Future apply() body) gets invoked immediately upon parsing
                                                  //|  definition.
                                                  //| f  : scala.concurrent.Future[String] = scala.concurrent.impl.Promise$Default
                                                  //| Promise@21c6f48c
	
	//f // really a DefaultPromise
	f onSuccess { // internal Success extends Try[T]
	  case msg => println("onSuccess: " + msg)
	}
	
	println("TCB")                            //> TCB
	
	sleep(10000)                              //> computation is done!
                                                  //| onSuccess: Hello future!|
}