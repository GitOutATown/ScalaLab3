package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object Futures_lab_4 extends App {

  val firstOccurrence: Future[Int] = Future {
    println("In firstOccurrence, asking for index...")
    val source = scala.io.Source.fromFile("myText.txt")
    source.toSeq.indexOfSlice("Hieronymus")
  }
  
  firstOccurrence.onComplete { 
    case Success(value) => println(s"Success! Index = $value")
    case Failure(e) => {
      println("~~~~~~~~~Failure~~~~~~~~")
      e.printStackTrace
    }
  }
  
  println("Taking care of other business...")
  
  Thread.sleep(1000)
  println("JVM leaving the house!")
}