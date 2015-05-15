package courses.coursera.reactive_programming.week3

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random

object TryComplete_lab_1 {

  // http://www.srirangan.net/2013-01-controlling-flow-with-scala-futures
  /* >>> promise.future can fulfilled only once. But you can have multiple
   * asynchronous blocks that each tryComplete a promise.
   * The first one that calls tryComplete is taken forward and the rest aren't.
   * <<< */
    // Two asynchronous blocks `tryComplete` a promise
    
    val whoWonTheRace = Promise[String]           //> whoWonTheRace  : scala.concurrent.Promise[String] = scala.concurrent.impl.Pr
                                                  //| omise$DefaultPromise@48abc2cf

    whoWonTheRace.future onSuccess {
      case name => println(name + " wins")
    }

    Future {
      Thread.sleep(new Random().nextInt(500))
      whoWonTheRace trySuccess "x"
    }                                             //> res0: scala.concurrent.Future[Boolean] = scala.concurrent.impl.Promise$Defau
                                                  //| ltPromise@45409388

    Future {
      Thread.sleep(new Random().nextInt(500))
      whoWonTheRace trySuccess "y"
    }                                             //> res1: scala.concurrent.Future[Boolean] = scala.concurrent.impl.Promise$Defau
                                                  //| ltPromise@21ebfd82

    println("Who won the race?")                  //> Who won the race?

    Thread.sleep(1000)                            //> x wins
}
/*




*/