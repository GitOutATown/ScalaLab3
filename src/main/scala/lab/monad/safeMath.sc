package lab.monad

object safeMath {
	// http://scabl.blogspot.com/2013/03/monads-in-scala-2.html

	// boolean conditional assignment
	def safeSqrt(d: Double): Maybe[Double] =
  		if (d >= 0) Just(scala.math.sqrt(d)) else MaybeNot
                                                  //> safeSqrt: (d: Double)lab.monad.Maybe[Double]
 	// boolean conditional assignment
	def safeLog(d: Double): Maybe[Double] =
  		if (d > 0) Just(scala.math.log(d)) else MaybeNot
                                                  //> safeLog: (d: Double)lab.monad.Maybe[Double]
  	
  	// Note that flatMap is not invoked	anywhere here
  	def logOfSafeSqrt(d: Double): Maybe[Double] =
  		safeSqrt(d) match {
  			case Just(d) => safeLog(d)
  			case MaybeNot => MaybeNot
  		}                                 //> logOfSafeSqrt: (d: Double)lab.monad.Maybe[Double]
  		
  	/* >>> Of course, we want to use flatMap instead of manually testing if
   * safeSqrt produced a Just or a MaybeNot. <<<
   */
  def logOfSafeSqrt_v2(d: Double): Maybe[Double] =
		safeSqrt(d) flatMap safeLog       //> logOfSafeSqrt_v2: (d: Double)lab.monad.Maybe[Double]
		// same as
		// safeSqrt(d).flatMap(safeLog(_))
		/* Again we see the pattern where the polymorphic instantiation of
		 * trait Maybe's extending case classes decides the behavior (i.e.
		 * return type) of flatMap (i.e Just or MaybeNot). That conditional
		 * instantiation is determined in this case by safeSqrt's usage of
		 * plain old if/else!
		 * So far, I'm seeing that the root of flatMap's magic does have to
		 * be based (bootstrapped upon first condition) on the tried and true
		 * patterns of if/else conditions, case class matching, or try/catch
		 * blocks. This can be seen very well in the Person.relation example
		 * where the the fundamental logical condition of existance of parent
		 * must be mapped from Some or None to Just or MaybeNot. Once that
		 * fundamental conditional mechanism has been established (mapped) then
		 * flatMap can become available as part of these new expanded case class
		 * definitions to provide the higher order functionality of continuation
		 * chaining (or termination) as seen in def GrandFathers.bothGrandfathersForComp.
		 */
		 
	// for comprehension version
	// Note that 'd' gets locally defined in each new function scope.
	def logOfSafeSqrt_v3(d: Double): Maybe[Double] =
		for {
			d <- safeSqrt(d) // Maybe.flatMap
			printStub = {println("d <- safeSqrt(d), d: " + d)} // Q: Why is 'd' a Double and not Just(Double), which is what flatMap should produce ?
			d <- safeLog(d) // Maybe.map
		} yield (d)                       //> logOfSafeSqrt_v3: (d: Double)lab.monad.Maybe[Double]
	  		
  // ----- tests --------------------- //
  
  safeSqrt(7)                                     //> res0: lab.monad.Maybe[Double] = Just(2.6457513110645907)
  safeSqrt(-7)                                    //> res1: lab.monad.Maybe[Double] = MaybeNot
  
  safeLog(7)                                      //> res2: lab.monad.Maybe[Double] = Just(1.9459101490553132)
  safeLog(-7)                                     //> res3: lab.monad.Maybe[Double] = MaybeNot
  
  logOfSafeSqrt(7)                                //> res4: lab.monad.Maybe[Double] = Just(0.9729550745276567)
  logOfSafeSqrt(-7)                               //> res5: lab.monad.Maybe[Double] = MaybeNot
  
  logOfSafeSqrt_v2(7)                             //> res6: lab.monad.Maybe[Double] = Just(0.9729550745276567)
  println(".................")                    //> .................
  logOfSafeSqrt_v2(-7)                            //> res7: lab.monad.Maybe[Double] = MaybeNot
  
  logOfSafeSqrt_v3(7)                             //> d <- safeSqrt(d), d: 2.6457513110645907
                                                  //| res8: lab.monad.Maybe[Double] = Just(0.9729550745276567)
  println(".................")                    //> .................
  logOfSafeSqrt_v3(-7)                            //> res9: lab.monad.Maybe[Double] = MaybeNot
  
  // ----- unsafe --------------------- //
  
  // >>> compose creates a new function that behaves by calling sqrt first, and then calling log on the result of that.<<<
  val unsafeLogSqrt: (Double) => Double =
  		scala.math.log _ compose scala.math.sqrt _
                                                  //> unsafeLogSqrt  : Double => Double = <function1>
  unsafeLogSqrt(7)                                //> res10: Double = 0.9729550745276567
  unsafeLogSqrt(-7)                               //> res11: Double = NaN
  
  // another unsafe formulation
  val unsafeLogSqrt_v2 = (x: Double) =>
  		scala.math.log(scala.math.sqrt(x))//> unsafeLogSqrt_v2  : Double => Double = <function1>
  
  unsafeLogSqrt_v2(7)                             //> res12: Double = 0.9729550745276567
  unsafeLogSqrt_v2(-7)                            //> res13: Double = NaN
  
  // ----- Kleisly composition ----- //
  
  def kleisliCompose[A, B, C](
  		f: (B) => Maybe[C],
  		g: (A) => Maybe[B]
  	): (A) => Maybe[C] = {
  		a: A => for {
  			b <- g(a)
  			c <- f(b)
  		} yield c
	}                                         //> kleisliCompose: [A, B, C](f: B => lab.monad.Maybe[C], g: A => lab.monad.May
                                                  //| be[B])A => lab.monad.Maybe[C]
  // TODO: I don't have a clear understanding of this syntax yet...
  def logOfSafeSqrt_v4(d: Double): Maybe[Double] =
		kleisliCompose(safeLog _, safeSqrt _)(d)
                                                  //> logOfSafeSqrt_v4: (d: Double)lab.monad.Maybe[Double]
	logOfSafeSqrt_v4(7)                       //> res14: lab.monad.Maybe[Double] = Just(0.9729550745276567)
	logOfSafeSqrt_v4(-7)                      //> res15: lab.monad.Maybe[Double] = MaybeNot
	
	/* >>>
	 The kleisliCompose method itself is the same, except that type parameters B and C, and parameter f, have been lifted out of the method and into the enclosing class. The MaybeFunction constructor takes a single Function1 as argument - in particular, a Function1 that returns a Maybe.
	 <<< */
	implicit class MaybeFunction[B, C](f: (B) => Maybe[C]) {
	  def kleisliCompose_v2[A](g: (A) => Maybe[B]): (A) => Maybe[C] = {
	    a: A =>
	    for {
	    		b <- g(a)
	    		c <- f(b)
    		} yield c
	  }
	}
	
	def logOfSafeSqrt_v5(d: Double): Maybe[Double] =
  		(safeLog _ kleisliCompose_v2 safeSqrt _)(d)
                                                  //> logOfSafeSqrt_v5: (d: Double)lab.monad.Maybe[Double]
	logOfSafeSqrt_v5(7)                       //> res16: lab.monad.Maybe[Double] = Just(0.9729550745276567)
	logOfSafeSqrt_v5(-7)                      //> res17: lab.monad.Maybe[Double] = MaybeNot
	
  '''                                             //> res18: Char('\'') = '
}
/*





*/