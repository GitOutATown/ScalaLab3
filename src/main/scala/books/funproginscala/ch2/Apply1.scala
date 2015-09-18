package books.funproginscala.ch2

object Apply1 extends App {

    trait AddInt {
        def apply(x: Int, y: Int) = x + y
    }
    
    object Foo extends AddInt
    
    println(Foo(3, 2))
    println(Foo(4, 2))
}
