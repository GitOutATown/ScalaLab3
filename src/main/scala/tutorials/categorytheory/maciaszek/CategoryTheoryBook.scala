package tutorials.categorytheory.maciaszek

// https://www.gitbook.com/book/speedcom/category-theory-in-real-world/details

trait Semigroup[T] {
    def op(a1: T, a2: T): T
}

trait Monoid[T] extends Semigroup[T] {
    def zero: T
}

trait Functor[F[_]] {
    def map[A,B](f: A => B): F[A] => F[B]
}

trait Applicative[F[_]] extends Functor[F] {
    def pure[A](a: => A): F[A]
    def <*>[A,B](fab: F[A => B]): F[A] => F[B]
}

trait Monad[F[_]] extends Applicative[F] {
    def flatMap[A,B](fa: F[A])(f: A => F[B]): F[B]
}

object CatTut {

    // Semigroup
    
    val intAddition = new Semigroup[Int] {
        def op(a1: Int, a2: Int): Int = a1 + a2
    }
    
    val strConcat = new Semigroup[String] {
        def op(a1: String, a2: String): String = a1 + a2
    }
    
    def listConcat[A] = new Semigroup[List[A]] {
        def op(a1: List[A], a2: List[A]): List[A] = a1 ++ a2
    }
    
    // Monoid
    // Many more examples in
    // ScalaLab3/src/main/scala/books/funproginscala/ch10/lab/MonoidLab1.scala
    
    val stringMonoid = new Monoid[String] {
        def zero = ""
        def op(x: String, y: String) = x + y
    }
    
    def listMonoid[A] = new Monoid[List[A]] {
        def zero = Nil
        def op(x: List[A], y: List[A]) = x ++ y
    }
    
    val intAdditionMonoid = new Monoid[Int] {
        def zero = 0
        def op(x: Int, y: Int): Int = x + y
    }
    
    val intMultiplication = new Monoid[Int] {
        def zero = 1
        def op(x: Int, y: Int) = x * y
    }
    
    val booleanOr = new Monoid[Boolean] {
        def zero = false
        def op(x: Boolean, y: Boolean) = x || y
    }
    
    val booleanAnd = new Monoid[Boolean] {
        def zero = true
        def op(x: Boolean, y: Boolean) = x && y
    }
    
    def optionMonoid[A] = new Monoid[Option[A]] {
        def zero = None
        def op(x: Option[A], y: Option[A]) = x orElse y
    }
    
    /*
     * `op` combines things in the opposite order.
     * Equality between dual and m depends 
     * on whether m is commutative.
     */
    def dual[A](m: Monoid[A]): Monoid[A] = new Monoid[A] {
        val zero: A = m.zero
        def op(x: A, y: A): A = m.op(y, x)
    }
    
    // Able to choose which side of the binary op takes precidence.
    def firstOptionMonoid[A]: Monoid[Option[A]] = optionMonoid[A]
    def lastOptionMonoid[A]: Monoid[Option[A]] = dual(firstOptionMonoid)
    def lastOptionMonoidAlt[A]: Monoid[Option[A]] = dual(optionMonoid[A])
    
    def endoMonoid[A]: Monoid[A => A] = new Monoid[A => A] {
        def zero = (a: A) => a
        def op(f: A => A, g: A => A) = f compose g
    }
    
    // Functor
    // They don't provide any examples.
    
    // Applicatives
    // They don't provide any examples.
    
    // Monad
    // They don't provide any examples.
}