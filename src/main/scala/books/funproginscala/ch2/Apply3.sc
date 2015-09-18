package books.funproginscala.ch2

object Apply3 {

    trait AddInt {
        def apply(x: Int, y: Int) = x + y
    }
    
    object Foo extends AddInt
    
    val foo1 = Foo(3, 2)                          //> foo1  : Int = 5
    val foo2 = Foo(4, 2)                          //> foo2  : Int = 6
    
    // ----- Dumb experiment below------------------------- //
    
    class Bar(val i: Int, val j: Int) extends AddInt // apply does nothing in this case
    
    val bar1 = new Bar(5, 6)                      //> bar1  : books.funproginscala.ch2.Apply3.Bar = books.funproginscala.ch2.Apply
                                                  //| 3$$anonfun$main$1$Bar$1@3937f594
    bar1.i                                        //> res0: Int = 5
}