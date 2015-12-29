package books.funproginscala.ch3.lab2

import scala.annotation._

sealed trait List[+A]
// data constructors
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
    
def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B =
  as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

foldRight(Cons(1, Cons(2, Cons(3, Nil))), 0)(_+_)
//1 + foldRight(Cons(2, Cons(3, Nil)), 0)(_+_)
//1 + (2 + foldRight(Cons(3, Nil), 0)(_+_))
//1 + (2 + (3 + foldRight(Nil, 0)(_+_)))
//1 + (2 + (3 + 0))
//6

@tailrec
def foldRightTR[A,B](as: List[A], z: B)(f: (A, B) => B): B = // Utility functions
  as match {
    case Nil => z
    case Cons(x, xs) => foldRightTR(xs, f(x, z))(f)
  }

foldRight(Cons(1, Cons(2, Cons(3, Nil))), 0)(_+_)
//foldRight(Cons(2, Cons(3, Nil)), (1 + 0))(_+_)
//foldRight(Cons(3, Nil), (2 + 1))(_+_)
//foldRight(Nil, (3 + 3))(_+_)
//6

}

