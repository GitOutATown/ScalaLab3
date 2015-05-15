package courses.coursera.reactive_programming.week3

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureFilter_lab_1 {

  val fut1 = Future {
    4
  }                                               //> fut1  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$Default
                                                  //| Promise@4f0cb13c
  
  fut1.withFilter { x => x % 2 == 0 }             //> res0: scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$DefaultPr
                                                  //| omise@21c6f48c
  fut1.value.get.get                              //> res1: Int = 4


  '''                                             //> res2: Char('\'') = '
}