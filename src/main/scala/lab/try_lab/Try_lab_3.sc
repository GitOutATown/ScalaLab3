package lab.try_lab

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Try, Success, Failure}

import scala.concurrent._

object Try_lab_3 {

  val p = Promise[String]  // defines a promise   //> p  : scala.concurrent.Promise[String] = scala.concurrent.impl.Promise$Defaul
                                                  //| tPromise@246b5488
	val pFut = p.future            // returns a future that will complete when p.complete() is called
                                                  //> pFut  : scala.concurrent.Future[String] = scala.concurrent.impl.Promise$Defa
                                                  //| ultPromise@246b5488
	p.complete(Try("done"))  // completes the future
                                                  //> res0: lab.try_lab.Try_lab_3.p.type = scala.concurrent.impl.Promise$DefaultPr
                                                  //| omise@246b5488
	//p.success("done")
	
  pFut onComplete {
    case Success(x) => println("ok")
  }
  
  Thread.sleep(250)                               //> ok
}