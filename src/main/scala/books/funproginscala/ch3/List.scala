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
    
    // tail recursive
    def sumAlt1(ints: List[Int]): Int = ints match {
        case Nil => 0
        case Cons(h, t) =>
            @annotation.tailrec
            def loop(acc: Int, ints: List[Int]): Int = ints match {
                case Nil => acc
                case Cons(h, t) => loop(h + acc, t)
            }
            loop(0, ints)
    }
    
    def product(doubles: List[Double]): Double = doubles match {
        case Nil => 1.0 // TODO: This is not correct for case when initial as is Nil.
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
    
    def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
        case Cons(x, xs) =>
            if(f(x)) dropWhile(xs, f)
            else l
        case _ => l
    }
    
    // curried
    def dropWhileAlt[A](l: List[A])(f: A => Boolean): List[A] = l match {
        case Cons(x, xs) =>
            if(f(x)) dropWhileAlt(xs)(f)
            else l
        case _ => l
    }
    
    // Return everything but the last element.
    def init[A](l: List[A]): List[A] = l match {
        case Nil => sys.error("init of empty list")
        case _ => 
            // Not tail recursive, vulnerable to stack overflow.
            def loop[A](l: List[A]): List[A] = l match { 
                case Cons(_, Nil) => Nil // recursive convergence condition
                case Cons(x, xs) => Cons(x, loop(xs))
            }
            loop(l)
    }
    
    // tail recursive
    def initAlt[A](l: List[A]): List[A] = l match {
        case Nil => sys.error("init of empty list")
        case _ =>
            import collection.mutable.ListBuffer
            val buf = new ListBuffer[A]
            @annotation.tailrec
            def loop(l: List[A]): List[A] = l match {
                case Cons(_, Nil) => List(buf.toList: _*)
                case Cons(h, t) => 
                    buf += h
                    loop(t)
            }
            loop(l)
    }
    
    def setHead[A](h: A, l: List[A]): List[A] = l match {
        case Nil => sys.error("set head on empty list")
        case Cons(_, xs) => Cons(h, xs)
    }
    
    def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
        case Nil => a2
        case Cons(x, xs) => Cons(x, append(xs, a2))
    }
    
    def apply[A](as: A*): List[A] = {
        if(as.isEmpty) Nil
        else Cons(as.head, apply(as.tail: _*))
    }
    
    //-----------------------------------------------------------------//
    // Recursion over lists and generalizing to higher-order functions //
    //-----------------------------------------------------------------//
    
    def foldRight[A,B](l: List[A], acc: B)(f: (A, B) => B): B = l match {
        case Nil => acc // TODO: This is not correct for case when initial as is Nil.
        case Cons(h, t) => f(h, foldRight(t, acc)(f))
    }
    
    def sumAlt2(xs: List[Int]) = foldRight(xs, 0)(_ + _)
    
    def sumAlt3(xs: List[Int]) = foldRight(xs, 0)((x, acc) => x + acc)
    
    def prodAlt1(xs: List[Double]) = foldRight(xs, 1.0)(_ * _)
    
    // The right hand side of the fat arrow comes back as acc. x is the next value in the list.
    def prodAlt2(xs: List[Double]) = foldRight(xs, 1.0)((x, acc) => x * acc)
    
    def length[A](xs: List[A]): Int = foldRight(xs, 0)((_, acc) => acc + 1)
    
    @annotation.tailrec
    def foldRightTR[A,B](l: List[A], acc: B)(f: (A, B) => B): B = l match {
        case Nil => acc // TODO: This is not correct for case when initial as is Nil.
        case Cons(x, xs) => foldRightTR(xs, f(x, acc))(f)
    }
    
    def sumAlt4(xs: List[Int]) = foldRightTR(xs, 0)((x, acc) => x + acc)
    
    def prodAlt3(xs: List[Double]) = foldRightTR(xs, 1.0)((x, acc) => x * acc)
    
    @annotation.tailrec
    def foldLeft[A,B](l: List[A], acc: B)(f: (B, A) => B): B = l match {
        case Nil => acc // TODO: This is not correct for case when initial as is Nil.
        case Cons(x, xs) => foldLeft(xs, f(acc, x))(f)
    }
    
    def sumAlt5(l: List[Int]) = foldLeft(l, 0)((acc, x) => x + acc)
    
    def prodAlt4(l: List[Double]) = foldLeft(l, 1.0)((acc, x) => x * acc)
    
    def lengthFL[A](l: List[A]): Int = foldLeft(l, 0)((acc, _) => acc + 1)
    
    def reverse[A](l: List[A]): List[A] = foldLeft(l, List[A]())((acc, x) => Cons(x, acc))
    
    def reverseFR[A](l: List[A]): List[A] = foldRightTR(l, List[A]())((x, acc) => Cons(x, acc))
    
    // This is evidently theoretic (academic). Don't worry about not grokking it now.
    // https://github.com/fpinscala/fpinscala/blob/master/answerkey/datastructures/13.answer.scala
    def foldLeftViaFR[A,B](l: List[A], acc: B)(f: (B, A) => B): B = 
        foldRightTR(l, (b:B) => b)((a,g) => b => g(f(b,a)))(acc)
    
    // NOPE, NOT WORKING, NOT REVERSING
    def reverseFLViaFR[A](l: List[A]): List[A] = 
        foldLeftViaFR(l, List[A]())((acc, x) => Cons(x, acc))
        
    def foldLeftViaFR2[A,B](l: List[A], acc: B)(f: (B, A) => B): B = 
        foldRight(l, (b:B) => b)((a,g) => b => g(f(b,a)))(acc)
        // Note foldRight is not TR here.
        
    def reverseFLViaFR2[A](l: List[A]): List[A] = 
        foldLeftViaFR2(l, List[A]())((acc, x) => Cons(x, acc))
}





