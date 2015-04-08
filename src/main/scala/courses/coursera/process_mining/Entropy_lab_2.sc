package courses.coursera.process_mining

import util.math.MathUtil._

object Entropy_lab_2 {
	
	E(List(3d, 3))                            //> res0: Double = 1.0
	E(List(2d))                               //> res1: Double = -0.0
	E(List(1d, 3))                            //> res2: Double = 0.8112781244591328
	E(List(1d, 1))                            //> res3: Double = 1.0
	E(List(2d))                               //> res4: Double = -0.0
}