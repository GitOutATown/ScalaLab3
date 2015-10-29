package books.funproginscala.ch10.lab

object MonoidLab1 {

    trait Monoid[A] {
        def zero: A
        def op(a1: A, a2: A): A
    }
    
    val stringMonoid = new Monoid[String] {
        def zero = ""
        def op(a1: String, a2: String): String = a1 + a2
    }
    
    def listMonoid[A] = new Monoid[List[A]] {
        def zero = Nil
        def op(a1: List[A], a2: List[A]): List[A] = a1 ++ a2
    }
    
    val intAddition = new Monoid[Int] {
        def zero = 0
        def op(a1: Int, a2: Int): Int = a1 + a2
    }
    
    val intMultiplication = new Monoid[Int] {
        def zero = 1
        def op(a1: Int, a2: Int) = a1 * a2
    }
    
    val booleanOr = new Monoid[Boolean] {
        def zero = false
        def op(a1: Boolean, a2: Boolean) = a1 || a2
    }
    
    val booleanAnd = new Monoid[Boolean] {
        def zero = true
        def op(a1: Boolean, a2: Boolean) = a1 && a2
    }
}



