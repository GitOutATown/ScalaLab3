package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global

object Promise_lab_1 extends App {
    
    def huh[T] {
        val p = Promise[T]
        val f = p.future
    }
    
    type S = Int
    val p2 = Promise[S]
    val f2 = p2.future
    
    val foo = Promise()
    val bar = foo.future

}