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
  
  
  
}
/*


*/