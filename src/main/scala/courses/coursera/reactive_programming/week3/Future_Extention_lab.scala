//import scala.language.postfixOps
import scala.io.StdIn
//import scala.util._
//import scala.util.control.NonFatal
import scala.concurrent._
//import scala.concurrent.duration._
import ExecutionContext.Implicits.global
//import scala.async.Async.{async, await}

object WhatEver {

  implicit class FutureCompanionOps(val f: Future.type) extends AnyVal {

    def userInput(message: String): Future[String] = Future {
      blocking {
        StdIn.readLine(message)
      }
    }
  } // end FutureCompanionOps
  
} // WhatEver

