package courses.coursera.process_mining

import util.math.MathUtil._

object Student_smokers_2 {

	// List(pass, fail)

	val allRoot = List(100d, 60)              //> allRoot  : List[Double] = List(100.0, 60.0)
	val allRoot_E = E(allRoot)                //> allRoot_E  : Double = 0.9544340029249649
	
	// Split on smoking
	
	val smokers = List(25d, 15)               //> smokers  : List[Double] = List(25.0, 15.0)
	val nonSmokers = List(75d, 45)            //> nonSmokers  : List[Double] = List(75.0, 45.0)
	
	val splitSmoking_E = weightedAvg(List(smokers, nonSmokers))
                                                  //> splitSmoking_E  : Double = 0.9544340029249649
  val informationGain = allRoot_E - splitSmoking_E//> informationGain  : Double = 0.0
}