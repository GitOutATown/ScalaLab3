package lab.try_lab

object try_lab_1 {

	import scala.util.{Try, Success, Failure}

	def divide_v1(dividend: Int, divisor: Int): Try[Int] = {
	  val dvend = Try(dividend)
	  val dvsor = Try(divisor)
	  val problem = dvend.flatMap(x => dvsor.map(y => x/y)) // problem: Try[Int] // inference
	  // When exceptions are thrown in a Try, they are caught and converted to Failure(e)
	  problem match {
	    case Success(v) =>
	      println("Result of " + dvend.get + "/"+ dvsor.get +" is: " + v)
	      Success(v)
	    case Failure(e) =>
	      println("You must've divided by zero or entered something that's not an Int. Try again!")
	      println("Info from the exception: " + e.getMessage)
	      Failure(e)
	  }
	}                                         //> divide_v1: (dividend: Int, divisor: Int)scala.util.Try[Int]
	
	divide_v1(3, 4)                           //> Result of 3/4 is: 0
                                                  //| res0: scala.util.Try[Int] = Success(0)
	divide_v1(3, 0)                           //> You must've divided by zero or entered something that's not an Int. Try agai
                                                  //| n!
                                                  //| Info from the exception: / by zero
                                                  //| res1: scala.util.Try[Int] = Failure(java.lang.ArithmeticException: / by zero
                                                  //| )
	
	// ----- Using for comprehension ----- //
	
	def divide_v2(dividend: Int, divisor: Int): Try[Int] = {
	  val dvend = Try(dividend)
	  val dvsor = Try(divisor)

	  val problem = for{ // problem is a Try
	  		x <- dvend // flatMap
	  		y <- dvsor // Map
	  } yield (x/y) // Try
	  
	  problem match { // Try
	    case Success(v) =>
	      println("Result of " + dvend.get + "/"+ dvsor.get +" is: " + v)
	      Success(v)
	    case Failure(e) =>
	      println("You must've divided by zero or entered something that's not an Int. Try again!")
	      println("Info from the exception: " + e.getMessage)
	      Failure(e)
	  }
	}                                         //> divide_v2: (dividend: Int, divisor: Int)scala.util.Try[Int]
  divide_v2(3, 4)                                 //> Result of 3/4 is: 0
                                                  //| res2: scala.util.Try[Int] = Success(0)
	divide_v2(3, 0)                           //> You must've divided by zero or entered something that's not an Int. Try aga
                                                  //| in!
                                                  //| Info from the exception: / by zero
                                                  //| res3: scala.util.Try[Int] = Failure(java.lang.ArithmeticException: / by zer
                                                  //| o)
	'''                                       //> res4: Char('\'') = '
}