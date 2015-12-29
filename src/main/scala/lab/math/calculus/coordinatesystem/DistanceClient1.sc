package lab.math.calculus.coordinatesystem

import Distance._
import scala.math.sqrt

object DistanceClient1 {
  
  hypotDist(3, 5)(7, 10)                          //> res0: Double = 6.4031242374328485
  
  hypotDist(3d, 5d)(7d, 10d)                      //> res1: Double = 6.4031242374328485
  
  hypotDist(3, 0)(7, 0)                           //> res2: Double = 4.0
  
  hypotDist(0, 3)(0, 7)                           //> res3: Double = 4.0
  
  hypotDist(3, 0)(0, 7)                           //> res4: Double = 7.615773105863909
  
  hypotDist(3, 8)(7, 11)                          //> res5: Double = 5.0
  
  hypotDist(4, -3)(2, 7)                          //> res6: Double = 10.198039027185569
  
  2 * sqrt(26)                                    //> res7: Double = 10.198039027185569
  
  hypotDist(0, 0)(4, 0)                           //> res8: Double = 4.0
  
  // ---- Mid Point -------- //
  
  hypotMidPt(1, 7)(3, 5)                          //> res9: (Double, Double) = (2.0,6.0)
  
  hypotMidPt(-2, 5)(3, 3)                         //> res10: (Double, Double) = (0.5,4.0)
  
  // ---- Isoceles ------ //
  
  isIsoceles(lengthSides(-1, 2)(4, 7)(-3, 6))     //> res11: Boolean = true
  isIsoceles(lengthSides(1, 2)(4, 7)(-3, 6))      //> res12: Boolean = false
  
  // ----- Right ------- //
  
  isRight(lengthSides(-5, -3)(-7, 3)(2, 6))       //> res13: Boolean = true
  
  isRightWhich(-5, -3)(-7, 3)(2, 6)               //> res14: scala.util.Either[Boolean,(Boolean, (Double, Double))] = Right((true,
                                                  //| (-7.0,3.0)))
  val t1 = Triangle(-5, -3)(-7, 3)(2, 6)          //> t1  : lab.math.calculus.coordinatesystem.Triangle = lab.math.calculus.coordi
                                                  //| natesystem.Triangle@15eae6fb
  val t2 = Triangle(-1, 2)(4, 7)(-3, 6)           //> t2  : lab.math.calculus.coordinatesystem.Triangle = lab.math.calculus.coordi
                                                  //| natesystem.Triangle@70e273fa
  
  isRightWhich(t1)                                //> res15: scala.util.Either[Boolean,(Boolean, (Double, Double))] = Right((true,
                                                  //| (-7.0,3.0)))
  isRightWhich(t2)                                //> res16: scala.util.Either[Boolean,(Boolean, (Double, Double))] = Left(false)
  '''                                             //> res17: Char('\'') = '
}