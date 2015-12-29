package books.funproginscala.ch11.lab

trait Functor[F[_]] {
    // abstract
    def map[A,B](fa: F[A])(f: A => B): F[B]
}

trait Monad[F[_]] extends Functor[F] {
    
    // abstract
    def unit[A](a: => A): F[A]
    
    // abstract
    def flatMap[A,B](ma: F[A])(f: A => F[B]): F[B]
    
    def map[A,B](ma: F[A])(f: A => B): F[B] = flatMap(ma)(a => unit(f(a)))
    
    def map2[A,B,C](ma: F[A], mb: F[B])(f: (A, B) => C): F[C] = 
        flatMap(ma)(a => map(mb)(b => f(a, b)))
}

/*
object Monad {
    val genMonad = new Monad[Gen] {
        def unit[A](a: => A): Gen[A] = Gen.unit(a)
        def flatMap[A,B](ma: Gen[A])(f: A => Gen[B]): Gen[B] = ma flatMap f
    }
}
*/