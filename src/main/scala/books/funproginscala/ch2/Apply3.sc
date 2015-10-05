package books.funproginscala.ch2

object Apply3 {

    trait AddInt {
        def apply(x: Int, y: Int) = {
            println("---apply---")
            x + y
        }
    }
    
    object Foo extends AddInt
    
    val foo1 = Foo(3, 2)                          //> ---apply---
                                                  //| foo1  : Int = 5
    val foo2 = Foo(4, 2)                          //> ---apply---
                                                  //| foo2  : Int = 6
        
    case class Bar(val i: Int, val j: Int) extends AddInt
    // apply does nothing in this case. apply() on acts as a constructor
    // when it's in a companion object.
    
    val bar1 = Bar(5, 6)                          //> bar1  : books.funproginscala.ch2.Apply3.Bar = Bar(5,6)
    bar1.i                                        //> res0: Int = 5
}
/*


*/