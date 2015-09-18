package books.funproginscala.ch3

// abstract class List[+A] // same, for all intensive purposes
sealed trait List[+A]
// data constructors
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

// companion object
object List {
    def sum(ints: List[Int]): Int = ints match {
        case Nil => 0
        case Cons(x, xs) => x + sum(xs)
    }
    
    def product(doubles: List[Double]): Double = doubles match {
        case Nil => 1.0
        case Cons(0.0, _) => 0.0
        case Cons(x, xs) => x * product(xs)
    }
    
    def tail[A](l: List[A]): List[A] = l match {
        case Nil => sys.error("tail of empty list")
        case Cons(_, xs) => xs
    }
    
    def drop[A](l: List[A], n: Int): List[A] = 
        if(n < 0) sys.error("negative arg to drop")
        else if(n == 0) l
        else l match {
            // I'm choosing to allow n to overstep list length
            case Nil => Nil
            case Cons(_, xs) => drop(xs, n - 1)
        }
    
    def setHead[A](h: A, l: List[A]): List[A] = l match {
        case Nil => sys.error("set head on empty list")
        case Cons(_, xs) => Cons(h, xs)
    }
    
    def apply[A](as: A*): List[A] = {
        if(as.isEmpty) Nil
        else Cons(as.head, apply(as.tail: _*))
    }
}


