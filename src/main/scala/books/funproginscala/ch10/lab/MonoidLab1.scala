package books.funproginscala.ch10.lab

object MonoidLab1 {

    trait Monoid[A] {
        def zero: A
        def op(a1: A, a2: A): A
    }
    
    val stringMonoid = new Monoid[String] {
        def zero = ""
        def op(x: String, y: String) = x + y
    }
    
    def listMonoid[A] = new Monoid[List[A]] {
        def zero = Nil
        def op(x: List[A], y: List[A]) = x ++ y
    }
    
    val intAddition = new Monoid[Int] {
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
}



