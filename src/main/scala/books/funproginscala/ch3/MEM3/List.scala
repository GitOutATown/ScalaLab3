package books.funproginscala.ch3.MEM3

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[A](t: A, h: List[A]) extends List[A]

object List extends App {
    
    def apply[A](as: A*): List[A] =
        if(as.isEmpty) Nil
        else Cons(as.head, apply(as.tail: _*)) 
        
    def foldRight[A,B](l: List[A], acc: B)(f: (A,B) => B): B = l match {
        case Nil => acc
        case Cons(h, t) => f(h, foldRight(t, acc)(f))
    }
    
    def foldRightTR[A,B](l: List[A], acc: B)(f: (A,B) => B): B = l match {
        case Nil => acc
        case Cons(h, t) => foldRightTR(t, f(h, acc))(f)
    }
}