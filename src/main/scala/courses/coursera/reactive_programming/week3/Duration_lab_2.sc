package courses.coursera.reactive_programming.week3

import scala.concurrent.duration._
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Try, Success, Failure}

object Duration_lab_2 {

  /** Returns a future with a unit value that is completed after time `t`.*/
  def delay(t: Duration): Future[String] = {
      println("Duration length: " + t.length)
      println("Duration unit: " + t.unit)
      //val futUnit = Future(())
      val futUnit = Future {"Foo!"}
      Await.result(futUnit, t)
      futUnit
  }                                               //> delay: (t: scala.concurrent.duration.Duration)scala.concurrent.Future[String
                                                  //| ]
  
  val dur3 = Duration(5, SECONDS)                 //> dur3  : scala.concurrent.duration.FiniteDuration = 5 seconds
  val res = delay(dur3)                           //> Duration length: 5
                                                  //| Duration unit: SECONDS
                                                  //| res  : scala.concurrent.Future[String] = scala.concurrent.impl.Promise$Defau
                                                  //| ltPromise@1db87736
  
  res onComplete {
    case Success(x) => println("~~x: " + x)
    case Failure(e) => println("~~e: " + e)
  }

  Thread.sleep(5000)                              //> ~~x: Foo!|
}