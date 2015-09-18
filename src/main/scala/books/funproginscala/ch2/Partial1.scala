package books.funproginscala.ch2

object Partial1 {

    def partial1[A,B,C](a: A, f: (A,B) => C): B => C = {
        (b:B) => f(a,b)
    }
    
    def partial2[A,B,C](a: A, f: (A,B) => C): B => C = {
        (b) => f(a,b)
    }
    
    def partial3[A,B,C](a: A, f: (A,B) => C): B => C = {
        b => f(a,b)
    }
    
}