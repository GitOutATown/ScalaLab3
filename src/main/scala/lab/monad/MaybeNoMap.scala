package lab.monad

/* http://scabl.blogspot.com/2013/02/monads-in-scala-1.html
 */
  
sealed trait Maybe[+A] {
	def flatMap[B](f: A => Maybe[B]): Maybe[B]
}

case class Just[+A](a: A) extends Maybe[A] {
	override def flatMap[B](f: A => Maybe[B]) = f(a)
}
 
case object MaybeNot extends Maybe[Nothing] {
	override def flatMap[B](f: Nothing => Maybe[B]) = MaybeNot
}