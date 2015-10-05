package books.funproginscala.ch2

object Partial1_MEM {
    
    def partial[A,B,C](a: A, f: (A,B) => C): B => C = {
        b => f(a, b)
    }
}