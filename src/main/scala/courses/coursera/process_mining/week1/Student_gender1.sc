package courses.coursera.process_mining

import util.math.MathUtil._

object Student_gender1 {

	// List(pass, fail)

	val allRoot = List(100d, 60)              //> allRoot  : List[Double] = List(100.0, 60.0)
	val allRoot_E = E(allRoot)                //> allRoot_E  : Double = 0.9544340029249649
	
	// Split on gender
	
	val male = List(30d, 50)                  //> male  : List[Double] = List(30.0, 50.0)
	val female = List(70d, 10)                //> female  : List[Double] = List(70.0, 10.0)
	
	val splitGender_E = weightedAvg(List(male, female))
                                                  //> splitGender_E  : Double = 0.7489992230622806
  val informationGain = allRoot_E - splitGender_E //> informationGain  : Double = 0.20543477986268432
}