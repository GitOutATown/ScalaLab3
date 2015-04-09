package courses.coursera.process_mining
 
import util.math.MathUtil._

object Exercise_144_balls {

	val mixedBox = List(2d, 2, 2, 2, 2, 2, 2, 2)
                                                  //> mixedBox  : List[Double] = List(2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0)
	val uniformBox = List(16d)                //> uniformBox  : List[Double] = List(16.0)
	
	val uniformBox2 = List(18d)               //> uniformBox2  : List[Double] = List(18.0)
	
	val mixedBox2 = List(18d, 18, 18, 18, 18, 18, 18, 18)
                                                  //> mixedBox2  : List[Double] = List(18.0, 18.0, 18.0, 18.0, 18.0, 18.0, 18.0, 1
                                                  //| 8.0)
	
	weightedAvg( List(
		mixedBox,
		uniformBox,
		uniformBox,
		uniformBox,
		uniformBox,
		uniformBox,
		uniformBox,
		uniformBox,
		uniformBox
	))                                        //> res0: Double = 0.3333333333333333
	
	weightedAvg( List(
		uniformBox2,
		uniformBox2,
		uniformBox2,
		uniformBox2,
		uniformBox2,
		uniformBox2,
		uniformBox2,
		uniformBox2
	))                                        //> res1: Double = 0.0
	
	weightedAvg(List(mixedBox2))              //> res2: Double = 3.0
	
	/*
	Consider the following distribution of 144 balls over 9 cells.
	One cell has 16 balls in eight different colors (two of each).
	The other eight cells each have 16 balls of the same color.
	What is the entropy of the different cells?
	*/
	val mixedCell = List(2d, 2, 2, 2, 2, 2, 2, 2)
                                                  //> mixedCell  : List[Double] = List(2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0)
  val uniformCell = List(16d)                     //> uniformCell  : List[Double] = List(16.0)
  E(mixedCell)                                    //> res3: Double = 3.0
  E(uniformCell)                                  //> res4: Double = -0.0
}
/*








*/