package courses.coursera.reactive_programming

import org.scalacheck.Prop.forAll
 
object sketchpad_1 {

	                                                 //> I'm evaluated everytime I'm called, but non when I'm declared.
                                                  //| res3: Int = 2
  
  lazy val ex3: Int = {
  		println("I'm only evaluated once, when I'm first called, but not when I'm first initiated")
  		3
  }                                               //> ex3: => Int
  
  ex3                                             //> I'm only evaluated once, when I'm first called, but not when I'm first initi
                                                  //| ated
                                                  //| res4: Int = 3
  ex3                                             //> res5: Int = 3
}
/*



*/