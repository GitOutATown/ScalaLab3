package books.funproginscala.ch2

object Curry1 {

    def curry1[A,B,C](f: (A, B) => C): A => (B => C) = {
        (a:A) => (b:B) => f(a,b)
    }
    
    def curry2[A,B,C](f: (A, B) => C): A => (B => C) = {
        (a) => (b) => f(a,b)
    }
    
    def curry3[A,B,C](f: (A, B) => C): A => (B => C) = {
        a => b => f(a,b)
    }
    
    // -------------- //
    
    // https://github.com/fpinscala/fpinscala/blob/master/answers/src/main/scala/fpinscala/gettingstarted/GettingStarted.scala
    
    def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
        (a,b) => f(a)(b)
    }
}



