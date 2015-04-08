package courses.coursera.process_mining

import util.math.MathUtil._

object Student_attendance_1 {

	// List(pass, fail)

	val allRoot = List(100d, 60)              //> allRoot  : List[Double] = List(100.0, 60.0)
	val allRoot_E = E(allRoot)                //> allRoot_E  : Double = 0.9544340029249649
	
	// Split on attendance
	
	val attendedAll = List(80d, 0.0)          //> attendedAll  : List[Double] = List(80.0, 0.0)
	val notAttAll = List(20d, 60)             //> notAttAll  : List[Double] = List(20.0, 60.0)
	
	val splitAttendance_E = weightedAvg(List(attendedAll, notAttAll))
                                                  //> splitAttendance_E  : Double = 0.4056390622295664
  val informationGain = allRoot_E - splitAttendance_E
                                                  //> informationGain  : Double = 0.5487949406953985
}
/*
 

*/