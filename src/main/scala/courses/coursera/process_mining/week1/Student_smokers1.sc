package courses.coursera.process_mining

import util.math.MathUtil._

object Student_smokers1 {

	// List(pass, fail)

	val allRoot = List(160d, 60)              //> allRoot  : List[Double] = List(160.0, 60.0)
	val allRoot_E = E(allRoot)                //> allRoot_E  : Double = 0.8453509366224365
	
	// Split on smoking
	
	val smokers = List(40d, 15)               //> smokers  : List[Double] = List(40.0, 15.0)
	val nonSmokers = List(120d, 45)           //> nonSmokers  : List[Double] = List(120.0, 45.0)
	
	val splitSmoking_E = weightedAvg(List(smokers, nonSmokers))
                                                  //> splitSmoking_E  : Double = 0.8453509366224365
  val informationGain = allRoot_E - splitSmoking_E//> informationGain  : Double = 0.0
}