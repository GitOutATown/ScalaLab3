package books.funproginscala.ch3.MEM2

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[A](h: A, t: List[A]) extends List[A] 

object List {
    
    def apply[A](as: A*): List[A] = {
        if(as.isEmpty) Nil
        else Cons(as.head: A, apply(as.tail: _*))
    }
    
    def foldRight[A,B](l: List[A], acc: B)(f: (A,B) => B): B = l match {
        case Nil => acc
        case Cons(h,t) => f(h, foldRight(t,acc)(f))
    }
    
    @annotation.tailrec
    def foldRightTR[A,B](l: List[A], acc: B)(f: (A,B) => B): B = l match {
        case Nil => acc
        case Cons(h,t) => foldRightTR(t, f(h,acc))(f)
    }
    
    @annotation.tailrec
    def foldLeftTR[A,B](l: List[A], acc: B)(f: (B,A) => B): B = l match {
        case Nil => acc
        case Cons(h,t) => foldLeftTR(t, f(acc, h))(f)
    }
    
    def sumFR(l: List[Int]) = foldRight(l, 0)(_+_)
    def prodFR(l: List[Double]) = foldRight(l, 1.0)(_*_)
    
    def sumFRTR(l: List[Int]) = foldRightTR(l, 0)(_+_)
    def prodFRTR(l: List[Double]) = foldRightTR(l, 1.0)(_*_) 
    
    def sumFLTR(l: List[Int]) = foldLeftTR(l, 0)(_+_)
    def prodFLTR(l: List[Double]) = foldLeftTR(l, 1.0)(_*_)
}






