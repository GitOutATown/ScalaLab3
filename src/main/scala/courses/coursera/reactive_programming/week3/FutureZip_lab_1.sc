package courses.coursera.reactive_programming.week3

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Try, Success, Failure}

object FutureZip_lab_1 {

  val fut1 = Future { "foo" }                     //> fut1  : scala.concurrent.Future[String] = scala.concurrent.impl.Promise$Defa
                                                  //| ultPromise@7bb2f811
  val fut2 = Future { "bar" }                     //> fut2  : scala.concurrent.Future[String] = scala.concurrent.impl.Promise$Defa
                                                  //| ultPromise@3aa7ff2e
  
  val huh = fut1.zip(fut2)                        //> huh  : scala.concurrent.Future[(String, String)] = scala.concurrent.impl.Pro
                                                  //| mise$DefaultPromise@2f74a57e
  
  huh.onComplete {
    case Success(x) => println("~~x: " + x)
  }
  
  Thread.sleep(1000)                              //> ~~x: (foo,bar)
  '''                                             //> res0: Char('\'') = '
}