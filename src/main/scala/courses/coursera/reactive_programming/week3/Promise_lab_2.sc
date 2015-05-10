package courses.coursera.reactive_programming.week3

import scala.concurrent._
import ExecutionContext.Implicits.global

object Promise_lab_2 {
  // http://danielwestheide.com/blog/2013/01/16/the-neophytes-guide-to-scala-part-9-promises-and-futures-in-practice.html

  // f is a default Promise
  val f: Future[String] = Future { "Hello world!" }
                                                  //> f  : scala.concurrent.Future[String] = scala.concurrent.impl.Promise$Default
                                                  //| Promise@54448f09
  
  // ----------------------- //
  
  case class TaxCut(reduction: Int)
  
  // either give the type as a type parameter to the factory method:
  val taxcut = Promise[TaxCut]()                  //> taxcut  : scala.concurrent.Promise[courses.coursera.reactive_programming.wee
                                                  //| k3.Promise_lab_2.TaxCut] = scala.concurrent.impl.Promise$DefaultPromise@7531
                                                  //| f745
  // or give the compiler a hint by specifying the type of your val:
  val taxcut2: Promise[TaxCut] = Promise()        //> taxcut2  : scala.concurrent.Promise[courses.coursera.reactive_programming.we
                                                  //| ek3.Promise_lab_2.TaxCut] = scala.concurrent.impl.Promise$DefaultPromise@236
                                                  //| 10f1f
  val taxcutFut: Future[TaxCut] = taxcut.future   //> taxcutFut  : scala.concurrent.Future[courses.coursera.reactive_programming.w
                                                  //| eek3.Promise_lab_2.TaxCut] = scala.concurrent.impl.Promise$DefaultPromise@75
                                                  //| 31f745
  println("~~taxcutF.value: " + taxcutFut.value)  //> ~~taxcutF.value: None
  
  taxcut.success(TaxCut(20))                      //> res0: courses.coursera.reactive_programming.week3.Promise_lab_2.taxcut.type 
                                                  //| = scala.concurrent.impl.Promise$DefaultPromise@7531f745
  
  println("~~taxcutF.value: " + taxcutFut.value)  //> ~~taxcutF.value: Some(Success(TaxCut(20)))

  // ---------------------------- //
  
  case class LameExcuse(msg: String) extends Exception(msg)
  
  object Government {
	  def redeemCampaignPledge(): Future[TaxCut] = {
	    val p = Promise[TaxCut]()
	    Future {
	      println("Starting the new legislative period.")
	      Thread.sleep(2000)
	      if(math.random < .50) {
	         println("We didn't fulfill our promises, but surely they'll understand.")
	         p.failure(LameExcuse("global economy crisis"))
	      }
	      else {
           println("We reduced the taxes! You must reelect us!!!!1111")
	         p.success(TaxCut(20))
	      }
	    }
	    p.future
	  } // end redeem
	} // end Government
	
	import scala.util.{Success, Failure}
	
  val taxCutF: Future[TaxCut] = Government.redeemCampaignPledge()
                                                  //> Starting the new legislative period.
                                                  //| taxCutF  : scala.concurrent.Future[courses.coursera.reactive_programming.we
                                                  //| ek3.Promise_lab_2.TaxCut] = scala.concurrent.impl.Promise$DefaultPromise@3e
                                                  //| 4ee7c0
  
  println("Now that they're elected, let's see if they remember their promises...")
                                                  //> Now that they're elected, let's see if they remember their promises...
  
  taxCutF.onComplete {
    case Success(TaxCut(reduction)) =>
      println(s"A miracle! They really cut our taxes by $reduction percentage points!")
    case Failure(ex) =>
      println(s"They broke their promises! Again! Because of a ${ex.getMessage}")
  }
  
  // ------------------------- //

  println("TCB")                                  //> TCB
  Thread.sleep(3000) // keep jvm running long enough for futures to complete
                                                  //> We didn't fulfill our promises, but surely they'll understand.
                                                  //| They broke their promises! Again! Because of a global economy crisis
  println("JVM leaving the house.")               //> JVM leaving the house.
}
/*




*/