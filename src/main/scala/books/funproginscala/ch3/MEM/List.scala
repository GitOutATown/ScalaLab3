package books.funproginscala.ch3.MEM

// abstract class List[+A] // same, for all intensive purposes
sealed trait List[+A]
// data constructors
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

// companion object
object List {
    
    // companion class factory
    def apply[A](as: A*): List[A] = {
        if(as.isEmpty) Nil
        else Cons(as.head, apply(as.tail: _*))
    }
    
    def sum(ints: List[Int]): Int = ints match {
        case Nil => 0
        case Cons(h, t) => h + sum(t)
    }
    
    // tail recursive
    def sumAlt1(ints: List[Int]): Int = ints match {
        case Nil => 0
        case Cons(h, t) =>
            @annotation.tailrec
            def loop(l: List[Int], acc: Int): Int = l match {
                case Nil => acc
                case Cons(h, t) => loop(t, h + acc)
            }
            loop(ints, 0)
    }
    
    // recursive, not stack safe
    def product(ds: List[Double]): Double = ds match {
        case Nil => 1.0 // TODO: This is not correct for case when initial as is Nil.
        case Cons(0.0, _) => 0.0
        case Cons(h, t) => h * product(t)
    }
    
    // captures initial empty list error, still not TR
    def productAlt0(ds: List[Double]): Double = ds match {
        case Nil => sys.error("operation on empty list")
        case Cons(h, t) => 
            def inner(l: List[Double]): Double = l match {
                case Nil => 1.0
                case Cons(0.0, _) => 0.0
                case Cons(h, t) => h * inner(t)
            }
            inner(ds)
    }
    
    def productTR(ds: List[Double]): Double = ds match {
        case Nil => sys.error("Operation on empty list.")
        case Cons(h, t) =>
            @annotation.tailrec
            def loop(l: List[Double], acc: Double): Double = l match {
                case Nil => acc
                case Cons(0.0, _) => 0.0
                case Cons(h, t) => loop(t, h * acc)
            }
            loop(ds, 1.0)
    }
    
    def tail[A](l: List[A]): List[A] = l match {
        case Nil => sys.error("operation on empty list")
        case Cons(_, t) => t
    }
    
    def drop[A](l: List[A], n: Int): List[A] = 
        if(n < 0) sys.error("negative arg to drop")
        else if(n == 0) l
        else l match {
            // I'm choosing to allow n to overstep list length
            case Nil => Nil
            case Cons(_, t) => drop(t, n - 1)
        }
    
    def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
        case Cons(h, t) => if(f(h)) dropWhile(t, f) else l
        case _ => l
    }
    
    // curried
    def dropWhileCur[A](l: List[A])(f: A => Boolean): List[A] = l match {
        case Cons(h, t) => if(f(h)) dropWhileCur(t)(f) else l
        case _ => l
    }
    
    // Reverses the order of the curried parameters
    def dropWhileCurAlt[A](f: A => Boolean)(l: List[A]): List[A] = l match {
        case Cons(h, t) => if(f(h)) dropWhileCurAlt(f)(t) else l
        case _ => l
    }
    
    // Return everything but the last element.
    def init[A](l: List[A]): List[A] = l match {
        case Nil => sys.error("operation on empty list")
        case Cons(_, _) =>
            import collection.mutable.ListBuffer
            val buf = new ListBuffer[A]
            @annotation.tailrec
            def inner(l: List[A]): List[A] = l match {
                case Cons(_, Nil) => List(buf.toList: _*)
                case Cons(h, t) => buf += h; inner(t)
            }
            inner(l)
    }
    
    // Sets different head
    def setHead[A](h: A, l: List[A]): List[A] = l match {
        case Nil => sys.error("operation on empty list")
        case Cons(_, t) => Cons(h, t)
    }
    
    def append[A](l1: List[A], l2: List[A]): List[A] = l1 match {
        case Nil => l2
        case Cons(h, t) => Cons(h, append(t, l2))
    }
    
    //-----------------------------------------------------------------//
    // Recursion over lists and generalizing to higher-order functions //
    //-----------------------------------------------------------------//
    
    @annotation.tailrec
    def foldRight[A,B](l: List[A], acc: B)(f: (A,B) => B): B = l match {
        case Nil => acc
        case Cons(h, t) => foldRight(t, f(h, acc))(f)
    }
    
    def sumAlt2(l: List[Int]) = foldRight(l, 0)((h, acc) => h + acc) // (_ + _)
    
    def prodAlt1(l: List[Double]) = foldRight(l, 1.0)((h, acc) => h * acc) // (_ * _)
    
    @annotation.tailrec
    def foldLeft[A,B](l: List[A], acc: B)(f: (B,A) => B): B = l match {
        case Nil => acc
        case Cons(h, t) => foldLeft(t, f(acc, h))(f)
    }
    
    def sumAlt3(l: List[Int]) = foldLeft(l, 0)((acc, h) => h + acc)
    
    def prodAlt2(l: List[Double]) = foldLeft(l, 1.0)((acc, h) => h * acc)
    
    def appendViaFR[A](a1: List[A], a2: List[A]): List[A] = {
        // Needs to not be TR
        books.funproginscala.ch3.MEM.List.foldRight(a1, a2)(Cons(_,_))
    }
}































