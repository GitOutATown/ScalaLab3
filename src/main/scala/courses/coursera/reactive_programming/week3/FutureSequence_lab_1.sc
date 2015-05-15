package courses.coursera.reactive_programming.week3

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Try, Success, Failure}

object FutureSequence_lab_1 {

  // Takes a List of Futures and turns it into a Future of Lists
  // Recursive
  def sequence[T](fts: List[Future[T]]): Future[List[T]] = {
    fts match {
      case Nil => Future(Nil)
      case ft :: fts => {
        ft.flatMap(t => sequence(fts).flatMap(ts => Future(t :: ts)))
      }
    }
  }
  
  // ---------------------- //
  
  val listOfFuts = List(Future{1}, Future{2}, Future{3})
  val futOfLists = sequence(listOfFuts)
  futOfLists onComplete {
    case Success(x) => println("~~x: " + x)
    case Failure(e) => println("~~e: " + e)
  }
  
  Thread.sleep(500)
  '''
  ~
}