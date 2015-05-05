package lab.monad

object safeMath {
	// http://scabl.blogspot.com/2013/03/monads-in-scala-2.html

	def safeSqrt(d: Double): Maybe[Double] =
  		if (d >= 0) Just(scala.math.sqrt(d)) else MaybeNot
                                                  //> safeSqrt: (d: Double)lab.monad.Maybe[Double]
 
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
	def logOfSafeSqrt_v3(d: Double): Maybe[Double] =
		for {
			sqrt <- safeSqrt(d)
			log <- safeLog(sqrt)
		} yield (log)                     //> logOfSafeSqrt_v3: (d: Double)lab.monad.Maybe[Double]
  		
  // -------------------------- //
  
  safeSqrt(7)                                     //> res0: lab.monad.Maybe[Double] = Just(2.6457513110645907)
  safeSqrt(-7)                                    //> res1: lab.monad.Maybe[Double] = MaybeNot
  
  safeLog(7)                                      //> res2: lab.monad.Maybe[Double] = Just(1.9459101490553132)
  safeLog(-7)                                     //> res3: lab.monad.Maybe[Double] = MaybeNot
  
  logOfSafeSqrt(7)                                //> res4: lab.monad.Maybe[Double] = Just(0.9729550745276567)
  logOfSafeSqrt(-7)                               //> res5: lab.monad.Maybe[Double] = MaybeNot
  
  logOfSafeSqrt_v2(7)                             //> res6: lab.monad.Maybe[Double] = Just(0.9729550745276567)
  println(".................")                    //> .................
  logOfSafeSqrt_v2(-7)                            //> res7: lab.monad.Maybe[Double] = MaybeNot
  
  logOfSafeSqrt_v3(7)                             //> res8: lab.monad.Maybe[Double] = Just(0.9729550745276567)
  println(".................")                    //> .................
  logOfSafeSqrt_v3(-7)                            //> res9: lab.monad.Maybe[Double] = MaybeNot
  
  '''                                             //> res10: Char('\'') = '
}
/*




*/