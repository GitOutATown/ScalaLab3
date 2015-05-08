package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global

object Futures_lab_2 extends App {
    val sayHello = Future {
      Thread.sleep(1000)
      "hello"
    }

    sayHello onSuccess {
      case message => println(s"He said '$message'")
    }

    println("Waiting..")

    Thread.sleep(2000)
}