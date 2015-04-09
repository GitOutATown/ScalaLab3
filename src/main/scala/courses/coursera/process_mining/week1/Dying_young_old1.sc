package courses.coursera.process_mining

import util.math.MathUtil._

object Dying_young_old1 {
	
	val diedOld = 546                         //> diedOld  : Int = 546
	val diedYoung = 314                       //> diedYoung  : Int = 314
	val all = diedYoung + diedOld             //> all  : Int = 860
	// Entropy
	val allMixed_E = E(List(diedYoung, diedOld))
                                                  //> allMixed_E  : Double = 0.9468482983171227
	
	///// Split on smoking //////
	
	val diedYoungSmokers = 184                //> diedYoungSmokers  : Int = 184
	val diedOldSmokers = 11                   //> diedOldSmokers  : Int = 11
	val allSmokers = diedYoungSmokers + diedOldSmokers
                                                  //> allSmokers  : Int = 195
  // Entropy
	val smokers_E = E(List(diedYoungSmokers, diedOldSmokers))
                                                  //> smokers_E  : Double = 0.31302699211114593
  val diedYoungNonSmokers = 362                   //> diedYoungNonSmokers  : Int = 362
  val diedOldNonSmokers = 303                     //> diedOldNonSmokers  : Int = 303
  val allNonSmokers = diedYoungNonSmokers + diedOldNonSmokers
                                                  //> allNonSmokers  : Int = 665
  // Entropy
  val nonSmokers_E = E(List(diedYoungNonSmokers, diedOldNonSmokers))
                                                  //> nonSmokers_E  : Double = 0.9943143978826505
  ///// Weighted Avg /////
  // Entropy
  val splitSmoking_E = weightedAvg(List(
  		List(diedYoungSmokers, diedOldSmokers),
  		List(diedYoungNonSmokers, diedOldNonSmokers)
  	))                                        //> splitSmoking_E  : Double = 0.8398364395972512
  	
  	val informationGain = allMixed_E - splitSmoking_E
                                                  //> informationGain  : Double = 0.10701185871987151
}
/*





*/