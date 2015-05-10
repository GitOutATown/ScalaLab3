package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.collection.mutable
import scala.util.{Failure, Success}

object AndThen_lab_1 extends App {
    // http://docs.scala-lang.org/overviews/core/futures.html
    
    val allposts = mutable.Set[String]()
    
    Future {
        getRecentPosts // sequential computation that doesn't explicitly throw an exception or construct a Failure defaults to Success (i.e. try/catch)
    } andThen {
        case Success(posts) => {
            allposts ++= posts
        }
    } andThen {
        case Success(posts) =>
            //clearAll()
            for (post <- allposts) println(post)
    }
    
    def getRecentPosts = {
        List("Post 1", "Post 2", "Post 3")
    }
    
    println("TCB")
    Thread.sleep(1000)
    println("JVM leavin' da haus!")
}