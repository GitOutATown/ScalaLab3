package books.funproginscala.ch3.MEM

// abstract class List[+A] // same for all practical purposes
trait List[+A]
// data constructors
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

// companion object
object List {
    
    def sum(ints: List[Int]): Int = ints match {
        case Nil => 0
        case Cons(h, t) => h + sum(t)
    }
    
    // tail recursive
    def sumAlt1(ints: List[Int]): Int = ints match {
        case Nil => 0
        case Cons(h, t) =>
            @annotation.tailrec
            def inner(t: List[Int], acc: Int): Int = t match {
                case Nil => acc
                case Cons(h, t) => inner(t, h + acc)
            }
            inner(ints, 0)
    }
    
    def product(ds: List[Double]): Double = ds match {
        case Nil => 1.0 // TODO: This is not correct for case when initial as is Nil.
        case Cons(0.0, _) => 0.0
        case Cons(h, t) => h * product(t)
    }
    
    // captures initial empty list error
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
        case Nil => sys.error("operation on empty list")
        case Cons(h, t) =>
            @annotation.tailrec
            def inner(l: List[Double], acc: Double): Double = l match {
                case Nil => acc
                case Cons(0.0, _) => 0.0
                case Cons(h, t) => inner(t, h * acc)
            }
            inner(ds, 1.0)
    }
    
    def tail[A](l: List[A]): List[A] = l match {
        case Nil => sys.error("operation on empty list")
        case Cons(h, t) => t
    }
    
    def drop[A](l: List[A], n: Int): List[A] = {
        if(n < 0) sys.error("negative drop count")
        else if(n == 0) l
        else l match {
            case Nil => Nil
            case Cons(h, t) => drop(t, n - 1)
        }
    } 
    
    def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
        case Cons(h, t) => if(f(h)) dropWhile(t, f) else l
        case _ => l
    }
    
    def dropWhileCur[A](l: List[A])(f: A => Boolean): List[A] = l match {
        case Cons(h, t) => if(f(h)) dropWhileCur(t)(f) else l
        case _ => l
    }
    
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
    
    //-----------------------------------------------------------------//
    // Recursion over lists and generalizing to higher-order functions //
    //-----------------------------------------------------------------//
    
    //def sumAlt2
    
    //def sumAlt3
    
    //def sumAlt4
    
    //def sumAlt5
    
    // companion class factory
    def apply[A](as: A*): List[A] = {
        if(as.isEmpty) Nil
        else Cons(as.head, apply(as.tail: _*))
    }
}











