package books.funproginscala.ch11

trait Functor[F[_]] {
  def map[A,B](fa: F[A])(f: A => B): F[B]

  def distribute[A,B](fab: F[(A, B)]): (F[A], F[B]) =
    (map(fab)(_._1), map(fab)(_._2))

  def codistribute[A,B](e: Either[F[A], F[B]]): F[Either[A, B]] = e match {
    case Left(fa) => map(fa)(Left(_))
    case Right(fb) => map(fb)(Right(_))
  }
}

object Functor {
  val listFunctor = new Functor[List] {
    def map[A,B](as: List[A])(f: A => B): List[B] = as map f
  }
}

// RW: Note many methods and other encapsulations are missing that appear in the "answers" version.
trait Monad[F[_]] extends Functor[F] {
    
    def unit[A](a: => A): F[A]
    
    def join[A](mma: F[F[A]]): F[A] = flatMap(mma)(ma => ma)

    def flatMap[A,B](ma: F[A])(f: A => F[B]): F[B] =
        join(map(ma)(f))
    
    def map[A,B](ma: F[A])(f: A => B): F[B] =
    flatMap(ma)(a => unit(f(a)))
    
    // Kleisli
    def compose[A,B,C](
        f: A => F[B], 
        g: B => F[C]
    ): A => F[C] = a => flatMap(f(a))(g)
}