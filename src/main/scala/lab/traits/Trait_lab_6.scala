package lab.traits

object Trait_lab_6 extends App {

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
    
    case class Baz(x: Int) extends AddInt { val y = 2 }
    val baz1 = Baz(3) // no effect
    println("baz1: " + baz1)
    val baz2 = baz1(4) // activates apply
    println("baz2: " + baz2)
    
    case class Bix() extends AddInt { val y = 2 }
    // val bix = Bix(3) ERROR

}