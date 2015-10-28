package lab.traits

object Trait_lab_4 {

    trait AddInt {
        def apply(x: Int) = x + y
        val y: Int
    }
    
    val addInt = new AddInt { val y = 2 }         //> addInt  : lab.traits.Trait_lab_4.AddInt = lab.traits.Trait_lab_4$$anonfun$ma
                                                  //| in$1$$anon$1@4fc7a9fc
    addInt(3)                                     //> res0: Int = 5

}