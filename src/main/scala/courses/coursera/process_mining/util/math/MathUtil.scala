package courses.coursera.process_mining.util.math

object MathUtil {
  
	def log2(x: Double) = scala.math.log(x)/scala.math.log(2)
	
	// Entropy
	def E(valueCounts: List[Double]) = {
		val n = valueCounts.sum
  		// Probability distribution of count values
		def Pi(ci: Double) = ci / n
  		// Weighting
  		val distTimesLogDist = valueCounts
			.filter(ci => ci != 0)
			.map(ci => Pi(ci) * log2(Pi(ci)))
  		-(distTimesLogDist.sum)
	}
	
	// Weighted Average
	def weightedAvg(leaves: List[List[Double]]) = {
		val n = leaves.flatten.sum
		val weightedEnts = leaves.map(leaf => {
			E(leaf) * (leaf.sum / n)
		})
		weightedEnts.sum
	}
	
	def roundAt(prec: Int)(n: Double): Double = {
	  	val scale = math pow(10, prec)
	  	//println("scale: " + scale)
	  	(math round n * scale) / scale
	}
}