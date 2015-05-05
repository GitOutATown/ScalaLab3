package lab.monad 

/* http://scabl.blogspot.com/2013/02/monads-in-scala-1.html
 */
  
sealed trait Maybe[+A] {
	// Abstract
	def flatMap[B](f: A => Maybe[B]): Maybe[B]
	
	/* This is another great example of the power of function composition:
	 * f being passed to the higher order function of map. 
	 */
	def map[B](f: A => B): Maybe[B] = flatMap {
		a => Just(f(a))
	}
	
	def flatten[B](
	    implicit asMaybeMaybe: Maybe[A] <:< Maybe[Maybe[B]]
	): Maybe[B] = asMaybeMaybe(this) flatMap identity
}

case class Just[+A](a: A) extends Maybe[A] {
	override def flatMap[B](f: A => Maybe[B]) = {
	  //println("In Just def flatMap, a: " + a + " f(a): " + f(a))
	  f(a)
	}
}
 
case object MaybeNot extends Maybe[Nothing] {
	override def flatMap[B](f: Nothing => Maybe[B]) = {
	  //println("In MaybeNot def flatMap, f: " + f)
	  MaybeNot
	}
}







