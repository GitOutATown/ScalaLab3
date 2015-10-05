package books.funproginscala.ch2

object Curry1_MEM {
    
    def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
        a => b => f(a, b)
    }

    def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
        (a,b) => f(a)(b)
    }
}