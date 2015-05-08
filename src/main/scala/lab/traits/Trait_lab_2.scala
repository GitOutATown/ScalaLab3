package lab.traits

object Trait_lab_2 extends App {
  
  trait Foo {
    def huh: String // abstract
  }
  
  /* ERROR: def huh is not defined in trait Foo. A trait can be instantiated
   * only if all members are concrete. If there is anything undefined in it
   * it can't be instantiated; but otherwise, if all members are defined, 
   * it can be.
   */
  object Foo {
    // def apply(): Foo = new Foo(){} // ERROR
  }
  
  // --------------------------- //
  
  trait Bar {
    def huh: String = "concrete!" // concrete
  }
  
  object Bar {
    def apply(): Bar = new Bar(){} // This instantiates.
  }
  
  println(Bar().huh) // "concrete!"

}
