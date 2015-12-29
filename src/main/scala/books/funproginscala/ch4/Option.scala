package books.funproginscala.ch4

sealed trait Option[+A]
case object None extends Option[Nothing]
case class Some[+A](get: A) extends Option[A]
