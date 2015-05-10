package courses.coursera.reactive_programming.week3

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object Promise_lab_3 extends App {
    
    println("Startin up!")
    
    type T = Double
    val p = Promise[T]
    val f = p.future

    val producer = Future {
        val r = produceSomething
        p success r
        continueDoingSomethingUnrelated
    }
    
    val consumer = Future {
        Future{startDoingSomething}
        f onSuccess {
            case r => doSomethingWithResult(r)
        }
    }
    
    // ---------------------- //
    
    def produceSomething = {
        Thread.sleep(3000)
        math.random
    }
    
    def continueDoingSomethingUnrelated {
        Thread.sleep(250)
        for(i <- 1 to 50) println("~"+i)
    }
    
    def startDoingSomething {
        for(c <- "abcdefghijklmnopqrstuvwxyz") {
            Thread.sleep(500)
            println("~"+c)
        }
    }
    
    def doSomethingWithResult(x: Double) {
        println("=====>" + x)
    }
    
    println("TCB")
    Thread.sleep(8000)
    println("JVM leavin' da haus!")
}