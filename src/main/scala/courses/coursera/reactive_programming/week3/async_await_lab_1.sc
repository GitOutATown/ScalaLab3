package courses.coursera.reactive_programming.week3


import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.async.Async.{async, await}

object async_await_lab_1 {

  // https://github.com/scala/async
  /* build.sbt:
     "org.scala-lang.modules" %% "scala-async" % "0.9.2"
   */
  
  /* async marks a block of asynchronous code. Such a block usually
     contains one or more await calls, which marks a point at which
     the computation will be suspended until the awaited Future is complete.
     await [are] transformed into non-blocking code.
   */
  val future = async {
	  val f1 = async { Thread.sleep(2000); true }
	  val f2 = async { Thread.sleep(1000); 42 }
	  if (await(f1)) await(f2) else 0
	}                                         //> future  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$Defau
                                                  //| ltPromise@7773bb48
	future onComplete { case x => println("~~x: " + x) }
  // You can feel the macro compiler!
  println("TCB")                                  //> TCB
  Thread.sleep(4000)                              //> ~~x: Success(42)/
}
/*


*/