package courses.coursera.process_mining

import util.math.MathUtil._

object scratchpad1 {

	log2(0.5)                                 //> res0: Double = -1.0
	log2(3d/6)                                //> res1: Double = -1.0
	
	-((0.5 * log2(0.5)) + (0.5 * log2(0.5)))  //> res2: Double = 1.0
	
	E(List(100, 50))                          //> res3: Double = 0.9182958340544896
	E(List(50, 100))                          //> res4: Double = 0.9182958340544896
	weightedAvg(List(List(100, 50)))          //> res5: Double = 0.9182958340544896
	val less22 = List(80d, 15)                //> less22  : List[Double] = List(80.0, 15.0)
	val gtrEql22 = List(20d, 35)              //> gtrEql22  : List[Double] = List(20.0, 35.0)
	weightedAvg(List(less22, gtrEql22))       //> res6: Double = 0.7452666201290565
}