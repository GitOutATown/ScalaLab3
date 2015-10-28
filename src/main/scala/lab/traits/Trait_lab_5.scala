package lab.traits

object Trait_lab_5 extends App {

    trait AddInt {
        def apply(x: Int) = x + y
        val y: Int
    }
    
    val addInt = new AddInt { val y = 2 }         //> addInt  : lab.traits.Trait_lab_4.AddInt = lab.traits.Trait_lab_4$$anonfun$ma
    println("addInt(3): " + addInt(3))
    
    class Foo extends AddInt { val y = 2 }
    val foo = new Foo
    println("foo(3): " + foo(3))
    
    object Bar extends AddInt { val y = 2 }
    val bar = Bar(3)
    println("bar: " + bar)
    
    val bar2 = Bar
    println("bar2(3): " + bar2(3))
}