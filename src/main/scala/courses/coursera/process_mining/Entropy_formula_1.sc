package courses.coursera.process_mining

import courses.coursera.process_mining.util.math.MathUtil.log2

object Entropy_formula_1 {
  
  val valueCounts = List(3d, 5, 2, 7, 9, 4, 3, 2) //> valueCounts  : List[Double] = List(3.0, 5.0, 2.0, 7.0, 9.0, 4.0, 3.0, 2.0)
  valueCounts.length                              //> res0: Int = 8
  val n = valueCounts.sum                         //> n  : Double = 35.0
  
  // Probability distribution of count values
  def Pi(ci: Double) = {
  		ci / n
  }                                               //> Pi: (ci: Double)Double
  
  val Pdist = valueCounts map Pi                  //> Pdist  : List[Double] = List(0.08571428571428572, 0.14285714285714285, 0.057
                                                  //| 14285714285714, 0.2, 0.2571428571428571, 0.11428571428571428, 0.085714285714
                                                  //| 28572, 0.05714285714285714)
  Pdist.sum                                       //> res1: Double = 1.0
  
  // Entropy
  def E(valueCounts: List[Double]) = {
  		val distTimesLogDist = valueCounts.map(ci => Pi(ci) * log2(Pi(ci)))
  		-(distTimesLogDist.sum)
  }                                               //> E: (valueCounts: List[Double])Double
  
  E(valueCounts)                                  //> res2: Double = 2.80641944705503
  
  E(List(1d))                                     //> res3: Double = 0.14655094334128474
  E(List(100d))                                   //> res4: Double = -4.327351922370738
  E(List(5d,5,5))                                 //> res5: Double = 1.2031521094532591
  E(List(5d,5,5,5,5,5,5))                         //> res6: Double = 2.8073549220576046
  
  
}
/*


*/