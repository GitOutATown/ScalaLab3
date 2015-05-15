package courses.coursera.reactive_programming.week3

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random
import scala.util.{Try, Success, Failure}
  
object TryComplete_lab_3 {
  
	/*  Future.any(List(Future { 1 }, Future { 2 }, Future { throw new Exception }))
	 *  may return a `Future` succeeded with `1`, `2` or failed with an `Exception`.
	 */
  def any[T](fs: List[Future[T]]): Future[T] = {
    // hint - use a Promise
    // Use tryComplete on all futs in fs.
    
    val p = Promise[T]()
    
    fs map {
      _ onComplete { case x => p.tryComplete(x) }
    }
    
    p.future
  }                                               //> any: [T](fs: List[scala.concurrent.Future[T]])scala.concurrent.Future[T]
  
  // --------------------- //
  
  val one = Future {
    Thread.sleep(new Random().nextInt(250))
    1
  }                                               //> one  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$DefaultP
                                                  //| romise@38a30a0b
  
  val two = Future {
    Thread.sleep(new Random().nextInt(250))
    2
  }                                               //> two  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$DefaultP
                                                  //| romise@59b746f
  
  val ex = Future {
    Thread.sleep(new Random().nextInt(250))
    throw new Exception
  }                                               //> ex  : scala.concurrent.Future[Nothing] = scala.concurrent.impl.Promise$Defau
                                                  //| ltPromise@3003ad53
  
  val res = any(List(one, two, ex))               //> res  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$DefaultP
                                                  //| romise@185fac52
  
  res onComplete {
    case Success(x) => println("~~x: " + x)
    case Failure(e) => println("~~e: " + e)
  }
  
  Thread.sleep(1000)                              //> ~~e: java.lang.Exception
  '''                                             //> res0: Char('\'') = '
}
/*









*/