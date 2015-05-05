package lab.monad

/* http://scabl.blogspot.com/2013/02/monads-in-scala-1.html
 */
  
sealed trait Maybe[+A] {
	// Abstract
	def flatMap[B](f: A => Maybe[B]): Maybe[B]
	
	/* Concrete, i.e. complete implementation
	 * 
	 * This is another great example of the power of function composition:
	 * f being passed to the higher order function of map. 
	 *  */
	def map[B](f: A => B): Maybe[B] = flatMap {
		a => Just(f(a))
	}
}

case class Just[+A](a: A) extends Maybe[A] {
	override def flatMap[B](f: A => Maybe[B]) = f(a)
}
 
case object MaybeNot extends Maybe[Nothing] {
	override def flatMap[B](f: Nothing => Maybe[B]) = MaybeNot
}