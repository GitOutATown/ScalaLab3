package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._

object FallBackTo_lab_1 {

  val f = Future { sys.error("failed") }          //> f  : scala.concurrent.Future[Nothing] = scala.concurrent.impl.Promise$Defaul
                                                  //| tPromise@13f948e
	val g = Future { 5 }                      //> g  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$DefaultPro
                                                  //| mise@3e4ee7c0
	val h = f fallbackTo g                    //> h  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$DefaultPro
                                                  //| mise@18f048dc
	Await.result(h, Duration.Zero) // evaluates to 5
                                                  //> res0: Int = 5
  // ----------------------- //
  
  val b = g fallbackTo f                          //> b  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$DefaultPro
                                                  //| mise@303f7944
  Await.result(b, Duration.Zero) // evaluates to 5//> res1: Int = 5
  
  // ----------------------- //
  
  val j = Future { sys.error("also failed") }     //> j  : scala.concurrent.Future[Nothing] = scala.concurrent.impl.Promise$Defaul
                                                  //| tPromise@5f58517d
  
  val c = f fallbackTo j                          //> c  : scala.concurrent.Future[Nothing] = scala.concurrent.impl.Promise$Defaul
                                                  //| tPromise@1f4e1672
  
  // Await.result(c, Duration.Zero) // java.lang.RuntimeException: failed
  
  '''                                             //> res2: Char('\'') = '
}