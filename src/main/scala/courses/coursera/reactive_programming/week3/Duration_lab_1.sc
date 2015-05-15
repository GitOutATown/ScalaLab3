package courses.coursera.reactive_programming.week3

import scala.concurrent.duration._
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object Duration_lab_1 {

  val duration = Duration(100, MILLISECONDS)      //> duration  : scala.concurrent.duration.FiniteDuration = 100 milliseconds
  val duration2 = Duration(100, "millis")         //> duration2  : scala.concurrent.duration.FiniteDuration = 100 milliseconds
  val duration3 = Duration(5, SECONDS)            //> duration3  : scala.concurrent.duration.FiniteDuration = 5 seconds
  duration3.toMillis                              //> res0: Long = 5000
  
  duration.length                                 //> res1: Long = 100
  duration.unit                                   //> res2: scala.concurrent.duration.TimeUnit = MILLISECONDS
  
  duration3.unit                                  //> res3: scala.concurrent.duration.TimeUnit = SECONDS
  
  val f3 = Future{3}                              //> f3  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$DefaultPr
                                                  //| omise@7c1ca8e
  Await.result(f3, duration3)                     //> res4: Int = 3
  Await.ready(f3, duration3)                      //> res5: courses.coursera.reactive_programming.week3.Duration_lab_1.f3.type = s
                                                  //| cala.concurrent.impl.Promise$DefaultPromise@7c1ca8e
  
  val p = Promise[Int]()                          //> p  : scala.concurrent.Promise[Int] = scala.concurrent.impl.Promise$DefaultPr
                                                  //| omise@72215748
  Await.ready(f3, duration3)                      //> res6: courses.coursera.reactive_programming.week3.Duration_lab_1.f3.type = s
                                                  //| cala.concurrent.impl.Promise$DefaultPromise@7c1ca8e
  
  
  /*
  println("Before...")
  Thread.sleep(2000)
  println("After!")
  */
}