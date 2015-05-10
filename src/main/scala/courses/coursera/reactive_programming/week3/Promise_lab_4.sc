package courses.coursera.reactive_programming.week3

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object Promise_lab_4 {

  val f = Future { 1 }                            //> f  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$DefaultPro
                                                  //| mise@3d8c4d8e
  val p = Promise[Int]                            //> p  : scala.concurrent.Promise[Int] = scala.concurrent.impl.Promise$DefaultPr
                                                  //| omise@54448f09
  p completeWith f                                //> res0: courses.coursera.reactive_programming.week3.Promise_lab_4.p.type = sca
                                                  //| la.concurrent.impl.Promise$DefaultPromise@54448f09
  p.future onSuccess {
	  case x => println(x)
	}
	
	'''                                       //> 1
                                                  //| res1: Char('\'') = '
}