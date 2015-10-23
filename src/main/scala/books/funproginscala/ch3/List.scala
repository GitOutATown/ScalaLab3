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
        case Cons(h, t) => foldRightTR(t, f(h, acc))(f)
    }
    
    def sumAlt4(xs: List[Int]) = foldRightTR(xs, 0)((x, acc) => x + acc)
    
    def prodAlt3(xs: List[Double]) = foldRightTR(xs, 1.0)((x, acc) => x * acc)
    
    @annotation.tailrec
    def foldLeftTR[A,B](l: List[A], acc: B)(f: (B, A) => B): B = l match {
        case Nil => acc // TODO: This is not correct for case when initial as is Nil.
        case Cons(h, t) => foldLeftTR(t, f(acc, h))(f)
    }
    
    def sumAlt5(l: List[Int]) = foldLeftTR(l, 0)((acc, x) => x + acc)
    
    def prodAlt4(l: List[Double]) = foldLeftTR(l, 1.0)((acc, x) => x * acc)
    
    def lengthFL[A](l: List[A]): Int = foldLeftTR(l, 0)((acc, _) => acc + 1)
    
    def reverse[A](l: List[A]): List[A] = foldLeftTR(l, List[A]())((acc, x) => Cons(x, acc))
    
    def reverseFR[A](l: List[A]): List[A] = foldRightTR(l, List[A]())((x, acc) => Cons(x, acc))
    
    def foldRightViaFL[A,B](l: List[A], acc: B)(f: (A,B) => B): B = 
        foldLeftTR(reverse(l), acc)((b,a) => f(a,b))
    
    // This is evidently theoretic (academic). Don't worry about not grokking it now.
    // https://github.com/fpinscala/fpinscala/blob/master/answerkey/datastructures/13.answer.scala
    def foldLeftViaFR[A,B](l: List[A], acc: B)(f: (B, A) => B): B = 
        foldRightTR(l, (b:B) => b)((a,g) => b => g(f(b,a)))(acc)
    
    // NOPE, NOT WORKING, NOT REVERSING because foldRightTR is TR
    def reverseFLViaFR[A](l: List[A]): List[A] = 
        foldLeftViaFR(l, List[A]())((acc, x) => Cons(x, acc))
        
    def foldLeftViaFR2[A,B](l: List[A], acc: B)(f: (B, A) => B): B = 
        foldRight(l, (b:B) => b)((a,g) => b => g(f(b,a)))(acc)
        // Note foldRight is not TR here.
        
    def reverseFLViaFR2[A](l: List[A]): List[A] = 
        foldLeftViaFR2(l, List[A]())((acc, x) => Cons(x, acc))
    
    /*
     * `append` simply replaces the `Nil` constructor of the first list with 
     * the second list, which is exactly the operation performed by `foldRight`.
     * foldRight's f just becomes Cons.
     * Note no TR here. TR (elsewhere) causes incorrect result.
     */
    def appendViaFR[A](a1: List[A], a2: List[A]): List[A] = {
        foldRight(a1, a2)(Cons(_, _))
    }
    
    // This is not correct because of TR!
    def appendViaFRTR[A](a1: List[A], a2: List[A]): List[A] =
        foldRightTR(a1, a2)(Cons(_, _))
    
    def concatLists[A](l: List[List[A]]): List[A] =
        foldRight(l, Nil:List[A])(appendViaFR)
        
    def concatListsAlt[A](l: List[List[A]]): List[A] =
        foldRight(l, Nil:List[A])(append)
        
    def add1(l: List[Int]): List[Int] =
        foldRight(l, Nil: List[Int])((h, t) => Cons(h + 1, t))
        
    def doubleToString(l: List[Double]): List[String] =
        foldRight(l, Nil: List[String])((h, t) => Cons(h.toString, t))
    
    // 18
    /* 
        map
        
        A natural solution is using `foldRight`, but our implementation of 
        `foldRight` is not stack-safe. We can use `foldRightViaFoldLeft` 
        to avoid the stack overflow (variation 1), but more commonly, with 
        our current implementation of `List`, `map` will just be implemented 
        using local mutation (variation 2). Again, note that the mutation 
        isn't observable outside the function, since we're only mutating a 
        buffer that we've allocated. 
    */
    def map[A,B](l: List[A])(f: A => B): List[B] =
        foldRight(l, Nil: List[B])((h, t) => Cons(f(h), t))
        
    def mapAlt1[A,B](l: List[A])(f: A => B): List[B] = 
        foldRightViaFL(l, Nil: List[B])((h,t) => Cons(f(h), t))
        
    def mapAlt2[A,B](l: List[A])(f: A => B): List[B] = {
        val buf = new collection.mutable.ListBuffer[B]
        def inner(l: List[A]): Unit = l match {
            case Nil => ()
            case Cons(h, t) => 
                buf += f(h)
                inner(t)
        }
        inner(l)
        List(buf.toList: _*) // converting from the standard Scala list to the list we've defined here
    }
    
    // 19
    /* 
        The discussion about `map` also applies here.
    */
    def filter[A](l: List[A])(f: A => Boolean): List[A] =
        foldRight(l, Nil: List[A])((h, t) => if(f(h)) Cons(h, t) else t)
        
    def filter_1[A](l: List[A])(f: A => Boolean): List[A] = 
        foldRightViaFL(l, Nil:List[A])((h,t) => if (f(h)) Cons(h,t) else t)

    def filter_2[A](l: List[A])(f: A => Boolean): List[A] = {
        val buf = new collection.mutable.ListBuffer[A]
        def inner(l: List[A]): Unit = l match {
            case Nil => ()
            case Cons(h,t) => if (f(h)) buf += h; inner(t)
        }
        inner(l)
        List(buf.toList: _*) // converting from the standard Scala list to the list we've defined here
    }
}





