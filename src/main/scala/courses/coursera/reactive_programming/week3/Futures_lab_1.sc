package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global

object Futures_lab_1 {
	// In a worksheet, references must all be backwards looking,
	// so this has to come first
	def sleep(duration: Long) { Thread.sleep(duration) }
                                                  //> sleep: (duration: Long)Unit

	val s = "Hello"                           //> s  : String = Hello
	val f: Future[String] = Future {
		sleep(4000)
	  s + " future!"
	}                                         //> f  : scala.concurrent.Future[String] = scala.concurrent.impl.Promise$Default
                                                  //| Promise@3eae389d
	f onSuccess {
	  case msg => println(msg)
	}
	
	sleep(5000)                               //> Hello future!|
	
}