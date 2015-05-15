package courses.coursera.reactive_programming.week3

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Try, Success, Failure}
import scala.util.Random

object FutureSequence_lab_2 {

  // Takes a List of Futures and turns it into a Future of Lists
  // Recursive
  def all[T](fts: List[Future[T]]): Future[List[T]] = {
    fts match {
      case Nil => Future(Nil)
      case ft :: fts => {
        ft.flatMap(t => all(fts).flatMap(ts => Future(t :: ts)))
      }
    }
  }                                               //> all: [T](fts: List[scala.concurrent.Future[T]])scala.concurrent.Future[List[
                                                  //| T]]
  
  // ---------------------- //
  
  val one = Future {
    Thread.sleep(new Random().nextInt(1750))
    1
  }                                               //> one  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$DefaultP
                                                  //| romise@562e5771
  
  val two = Future {
    Thread.sleep(new Random().nextInt(250))
    2
  }                                               //> two  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$DefaultP
                                                  //| romise@52ed76ff
  
  val three = Future {
    Thread.sleep(new Random().nextInt(500))
    3
  }                                               //> three  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$Defaul
                                                  //| tPromise@462f4ae2
  
  val four = Future {
    Thread.sleep(new Random().nextInt(250))
    4
  }                                               //> four  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$Default
                                                  //| Promise@40fc801f
  
  val ex = Future {
    Thread.sleep(new Random().nextInt(250))
    throw new Exception
  }                                               //> ex  : scala.concurrent.Future[Nothing] = scala.concurrent.impl.Promise$Defau
                                                  //| ltPromise@23610f1f
  //val listOfFuts = List(four, three, ex, two, one)
  val listOfFuts = List(four, three, two, one)    //> listOfFuts  : List[scala.concurrent.Future[Int]] = List(scala.concurrent.im
                                                  //| pl.Promise$DefaultPromise@40fc801f, scala.concurrent.impl.Promise$DefaultPr
                                                  //| omise@462f4ae2, scala.concurrent.impl.Promise$DefaultPromise@52ed76ff, scal
                                                  //| a.concurrent.impl.Promise$DefaultPromise@562e5771)
  val futOfLists = all(listOfFuts)                //> futOfLists  : scala.concurrent.Future[List[Int]] = scala.concurrent.impl.Pr
                                                  //| omise$DefaultPromise@76959acc
  futOfLists onComplete {
    case Success(x) => println("~~x: " + x)
    case Failure(e) => println("~~e: " + e)
  }
  
  Thread.sleep(2000)                              //> ~~x: List(4, 3, 2, 1)
  '''                                             //> res0: Char('\'') = '
}
/*



*/