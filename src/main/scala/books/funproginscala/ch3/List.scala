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
        case Cons(h, t) => {
            def loop(acc: Int, ints: List[Int]): Int = ints match {
                case Nil => acc
                case Cons(h, t) => loop(h + acc, t)
            }
            loop(0, ints)
        }
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
            if(f(x)) dropWhile(xs, f)
            else l
        case _ => l
    }
    
    // My interpretation is that the sole member of a single value list is both head and init (i.e. first and last) as with scala collections package List.
    def init[A](l: List[A]): List[A] = l match {
        case Nil => sys.error("init of empty list")
        case Cons(_, Nil) => l
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
        case Cons(_, Nil) => l
        case _ =>
            import collection.mutable.ListBuffer
            val buf = new ListBuffer[A]
            @annotation.tailrec
            def loop(l: List[A]): List[A] = l match {
                case Cons(_, Nil) => List(buf.toList: _*)
                case Cons(x, xs) => 
                    buf += x
                    loop(xs)
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
    
    // Recursion over lists and generalizing to higher-order functions
    
    def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = as match {
        case Nil => z // TODO: This is not correct for case when initial as is Nil.
        case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }
    
    def sumAlt2(ns: List[Int]) = foldRight(ns, 0)(_ + _)
    
    def sumAlt3(ns: List[Int]) = foldRight(ns, 0)((x, acc) => x + acc)
    
    def prodAlt1(ns: List[Double]) = foldRight(ns, 1.0)(_ * _)
    
    // The right hand side of the fat arrow comes back as acc. x is the next value in the list.
    def prodAlt2(ns: List[Double]) = foldRight(ns, 1.0)((x, acc) => x * acc)
    
    def length[A](ns: List[A]): Int = foldRight(ns, 0)((_, acc) => acc + 1)
    
    @annotation.tailrec
    def foldRightTR[A,B](as: List[A], z: B)(f: (A, B) => B): B = as match {
        case Nil => z // TODO: This is not correct for case when initial as is Nil.
        case Cons(x, xs) => foldRightTR(xs, f(x, z))(f)
    }
    
    def sumAlt4(ns: List[Int]) = foldRightTR(ns, 0)((x, acc) => x + acc)
    
    def prodAlt3(ns: List[Double]) = foldRightTR(ns, 1.0)((x, acc) => x * acc)
    
    @annotation.tailrec
    def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
        case Nil => z // TODO: This is not correct for case when initial as is Nil.
        case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
    }
    
    def sumAlt5(ns: List[Int]) = foldLeft(ns, 0)((acc, x) => x + acc)
    
    def prodAlt4(ns: List[Double]) = foldLeft(ns, 1.0)((acc, x) => x * acc)
}





