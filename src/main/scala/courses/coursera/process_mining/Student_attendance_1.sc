package courses.coursera.process_mining

import util.math.MathUtil._

object Student_attendance_1 {

	// List(pass, fail)

	val allRoot = List(100d, 60)              //> allRoot  : List[Double] = List(100.0, 60.0)
	val allRoot_E = E(allRoot)                //> ===> ci: 100.0  Pi(ci): 0.625  log2(Pi(ci)): -0.6780719051126377
                                                  //| ===> ci: 60.0  Pi(ci): 0.375  log2(Pi(ci)): -1.4150374992788437
                                                  //| ---> E distTimesLogDist: List(-0.4237949406953986, -0.5306390622295664)
                                                  //| allRoot_E  : Double = 0.9544340029249649
	
	// Split on attendance
	
	val attendedAll = List(80d)               //> attendedAll  : List[Double] = List(80.0)
	val notAttAll = List(20d, 60)             //> notAttAll  : List[Double] = List(20.0, 60.0)
	
	val splitAttendance_E = weightedAvg(List(attendedAll, notAttAll))
                                                  //> ===> ci: 80.0  Pi(ci): 1.0  log2(Pi(ci)): 0.0
                                                  //| ---> E distTimesLogDist: List(0.0)
                                                  //| ===> ci: 20.0  Pi(ci): 0.25  log2(Pi(ci)): -2.0
                                                  //| ===> ci: 60.0  Pi(ci): 0.75  log2(Pi(ci)): -0.4150374992788438
                                                  //| ---> E distTimesLogDist: List(-0.5, -0.31127812445913283)
                                                  //| splitAttendance_E  : Double = 0.4056390622295664
  val informationGain = allRoot_E - splitAttendance_E
                                                  //> informationGain  : Double = 0.5487949406953985
}
/*



*/