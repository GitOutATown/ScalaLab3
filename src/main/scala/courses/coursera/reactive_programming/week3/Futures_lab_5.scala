package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global

object Futures_lab_5 extends App {
  
  // http://docs.scala-lang.org/overviews/core/futures.html
  
  @volatile var totalA = 0
  
  val text = Future[String] {
    "na" * 16 + "BATMAN!!!"
  }
  
  text onSuccess {
    case txt => {
      totalA += txt.count(_ == 'a')
      println("totalA: " + totalA)
    }
  }
  
  text onSuccess {
    case txt => {
      totalA += txt.count(_ == 'A')
      println("totalA: " + totalA)
    }
  }
  
  println("Taking care of other business...")
  
  Thread.sleep(1000)
  println("JVM leaving the house!")

}