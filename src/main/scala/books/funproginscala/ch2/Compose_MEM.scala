package books.funproginscala.ch2

object Compose_MEM {

    def composeMEM[A,B,C](f: B => C, g: A => B): A => C = {
        a => f(g(a))
    }
}