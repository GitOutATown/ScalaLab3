package books.funproginscala.ch2

object Apply2 {

    trait AddInt {
        def apply(x: Int, y: Int) = x + y
    }
    
    object Foo extends AddInt
        
    val foo1 = Foo(3, 2)                          //> foo1  : Int = 5
    val foo2 = Foo(4, 2)                          //> foo2  : Int = 6
}