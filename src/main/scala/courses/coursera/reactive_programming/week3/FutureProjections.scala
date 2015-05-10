package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._

object FutureProjections extends App {

    val f1 = Future {
        Thread.sleep(1000)
        2 / 0
    }
    val f2 = Future {
        Thread.sleep(500)
        4 / 2
    }

    for (exc <- f1.failed) println("f1 Failure: " + exc)
    for (exc <- f2.failed) println("f2 Failure: " + exc)
    f2.onSuccess{case res => println("f2: " + res)}
    
    println("TCB")
    //Thread.sleep(2000)
    //println("JVM leavin' da haus!")
    Await.ready(f1, Duration(800, MILLISECONDS))
    Await.ready(f2, Duration(500, MILLISECONDS))
}