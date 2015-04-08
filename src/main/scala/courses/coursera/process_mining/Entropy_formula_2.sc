package courses.coursera.process_mining

import courses.coursera.process_mining.util.math.MathUtil.log2

object Entropy_formula_2 {
  
  // Entropy
  def E(valueCounts: List[Double]) = {
  		val n = valueCounts.sum
  		
  		// Probability distribution of count values
	  def Pi(ci: Double) = {
	  		ci / n
	  }
  		
  		val distTimesLogDist = valueCounts.map(ci => Pi(ci) * log2(Pi(ci)))
  		-(distTimesLogDist.sum)
  }                                               //> E: (valueCounts: List[Double])Double
  
  val valueCounts = List(3d, 3)                   //> valueCounts  : List[Double] = List(3.0, 3.0)
  E(valueCounts)                                  //> res0: Double = 1.0
  
  E(List(1d))                                     //> res1: Double = -0.0
  E(List(100d))                                   //> res2: Double = -0.0
  E(List(5d,5,5))                                 //> res3: Double = 1.584962500721156
  E(List(5d,5,5,5,5,5,5))                         //> res4: Double = 2.8073549220576046
  E(List(3d,3))                                   //> res5: Double = 1.0
  E(List(5d, 5))                                  //> res6: Double = 1.0
  E(List(100d, 100))                              //> res7: Double = 1.0
  E(List(100d, 100, 100))                         //> res8: Double = 1.584962500721156
  E(List(100d, 1))                                //> res9: Double = 0.08013604733127526
  E(List(100d, 1, 1))                             //> res10: Double = 0.15884084219235378
  E(List(100d, 100, 1))                           //> res11: Double = 1.0402495122986057
  E(List(2d))                                     //> res12: Double = -0.0
  0 * -1                                          //> res13: Int(0) = 0
  -(0) * -1                                       //> res14: Int = 0
  (-(0)) * 1                                      //> res15: Int = 0
  
  0 < 0                                           //> res16: Boolean(false) = false
  (-0.0) < 0.0                                    //> res17: Boolean(false) = false
}
/*


*/