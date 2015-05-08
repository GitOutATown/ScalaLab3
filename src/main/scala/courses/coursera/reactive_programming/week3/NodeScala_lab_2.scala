package courses.coursera.reactive_programming.week3

import scala.io.StdIn
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}

object NodeScala_lab_2 {

  implicit class FutureCompanionOps(val f: Future.type) extends AnyVal {
    def userInput(message: String): Future[String] = Future {
      StdIn.readLine(message)
    }
  }
  
  implicit class FutureOps[T](f: Future[T]) {
    
    def ensuring[S](that: Future[S]): Future[T] = {
      val p = Promise[T]()
      f onComplete {
        case tryValue =>
          that onComplete {
            case Success(_) =>
              p.complete(tryValue)
            case Failure(exception) =>
              p.failure(exception)
          }
      }
      p.future
    }
    
  }
}