package books.funproginscala.ch10.lab

import MonoidLab1._

object MonoidLab1_client {

  stringMonoid.op("how", "dy!")                   //> res0: String = howdy!
  stringMonoid.op("how", stringMonoid.zero)       //> res1: String = how
  
  listMonoid.op(List("how", "dy"), List(" ", "pard", "ner!"))
                                                  //> res2: List[String] = List(how, dy, " ", pard, ner!)
  intAddition.op(3, 2)                            //> res3: Int = 5
  intAddition.op(3, intAddition.zero)             //> res4: Int = 3
  
  intMultiplication.op(3, 2)                      //> res5: Int = 6
  intMultiplication.op(3, intMultiplication.zero) //> res6: Int = 3
  
  booleanOr.op(false, false)                      //> res7: Boolean = false
  booleanOr.op(true, booleanOr.zero)              //> res8: Boolean = true
  booleanOr.op(booleanOr.zero, true)              //> res9: Boolean = true
  
  booleanAnd.op(false, false)                     //> res10: Boolean = false
  booleanAnd.op(booleanAnd.zero, true)            //> res11: Boolean = true
  
  optionMonoid.op(Some(1), Some(2))               //> res12: Option[Int] = Some(1)
  optionMonoid.op(None, Some(2))                  //> res13: Option[Int] = Some(2)
  optionMonoid.op(None, optionMonoid.zero)        //> res14: Option[Nothing] = None
  
  firstOptionMonoid.op(Some(1), Some(2))          //> res15: Option[Int] = Some(1)
  firstOptionMonoid.op(None, Some("second"))      //> res16: Option[String] = Some(second)
  lastOptionMonoid.op(Some(1), Some(2))           //> res17: Option[Int] = Some(2)
  lastOptionMonoid.op(Some("first"), lastOptionMonoid.zero)
                                                  //> res18: Option[String] = Some(first)
  lastOptionMonoidAlt.op(Some("first"), lastOptionMonoid.zero)
                                                  //> res19: Option[String] = Some(first)
}
/*


*/