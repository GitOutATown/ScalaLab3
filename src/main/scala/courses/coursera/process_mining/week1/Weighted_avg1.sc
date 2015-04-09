package courses.coursera.process_mining

import util.math.MathUtil._

object Weighted_avg1 {
	// 14-Learning Decision Trees.pdf
  
  // Initial entropy for all (died young, died old)
  val all = E(List(3d, 3))                        //> all  : Double = 1.0
	// Split on smoking
	val smokers_leaf = E(List(2d))            //> smokers_leaf  : Double = -0.0
	val nonSmokers = E(List(1d, 3))           //> nonSmokers  : Double = 0.8112781244591328
	
	// Split on drinking
	val drinkers_leaf = E(List(1d, 1))        //> drinkers_leaf  : Double = 1.0
	val nonDrinkers_leaf = E(List(2d))        //> nonDrinkers_leaf  : Double = -0.0
  
  // Final, reduced entropy on 3 obtained leaves (from 1 to 0.33)
  // smokers_leaf, drinkers_leaf, nonDrinkers_leaf
  weightedAvg(List(List(2d), List(1d, 1), List(2d)))
                                                  //> res0: Double = 0.3333333333333333
}