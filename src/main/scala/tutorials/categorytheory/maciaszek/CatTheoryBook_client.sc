package tutorials.categorytheory.maciaszek

import CatTut._

object CatTheoryBook_client {

  // Semigroup

  intAddition.op(3, 2)                            //> res0: Int = 5
  
  strConcat.op("3", "2")                          //> res1: String = 32
  
  listConcat.op(List(1,2), List(3,4))             //> res2: List[Int] = List(1, 2, 3, 4)
  
  // Monoid
  
  stringMonoid.op("how", "dy!")                   //> res3: String = howdy!
  stringMonoid.op("how", stringMonoid.zero)       //> res4: String = how
  
  listMonoid.op(List("how", "dy"), List(" ", "pard", "ner!"))
                                                  //> res5: List[String] = List(how, dy, " ", pard, ner!)
  intAddition.op(3, 2)                            //> res6: Int = 5
  intAddition.op(3, intAdditionMonoid.zero)       //> res7: Int = 3
  
  intMultiplication.op(3, 2)                      //> res8: Int = 6
  intMultiplication.op(3, intMultiplication.zero) //> res9: Int = 3
  
  booleanOr.op(false, false)                      //> res10: Boolean = false
  booleanOr.op(true, booleanOr.zero)              //> res11: Boolean = true
  booleanOr.op(booleanOr.zero, true)              //> res12: Boolean = true
  
  booleanAnd.op(false, false)                     //> res13: Boolean = false
  booleanAnd.op(booleanAnd.zero, true)            //> res14: Boolean = true
  
  optionMonoid.op(Some(1), Some(2))               //> res15: Option[Int] = Some(1)
  optionMonoid.op(None, Some(2))                  //> res16: Option[Int] = Some(2)
  optionMonoid.op(None, optionMonoid.zero)        //> res17: Option[Nothing] = None
  
  firstOptionMonoid.op(Some(1), Some(2))          //> res18: Option[Int] = Some(1)
  firstOptionMonoid.op(None, Some("second"))      //> res19: Option[String] = Some(second)
  lastOptionMonoid.op(Some(1), Some(2))           //> res20: Option[Int] = Some(2)
  lastOptionMonoid.op(Some("first"), lastOptionMonoid.zero)
                                                  //> res21: Option[String] = Some(first)
  lastOptionMonoidAlt.op(Some("first"), lastOptionMonoid.zero)
                                                  //> res22: Option[String] = Some(first)
  
  '''                                             //> res23: Char('\'') = '
}