package lab.math.probability.ross.combinatorial_analysis

import lab.math.probability.ross.combinatorial_analysis.Combinatorics._

object lab_4 {

	binCoef(5, 3)                             //> res0: Double = 10.0
	binCoef(5 - 1, 3 - 1)                     //> res1: Double = 6.0
	binCoef(5 - 1, 3)                         //> res2: Double = 4.0
	
	binCoef(5, 3) == ( binCoef(5 - 1, 3 - 1) + binCoef(5 - 1, 3) )
                                                  //> res3: Boolean = true
	
	//.........................//
	
	binCoef(4, 2)                             //> res4: Double = 6.0
	binCoef(4 - 1, 2 - 1)                     //> res5: Double = 3.0
	binCoef(4 - 1, 2)                         //> res6: Double = 3.0
	
	binCoef(4, 2) == ( binCoef(4 - 1, 2 - 1) + binCoef(4 - 1, 2) )
                                                  //> res7: Boolean = true
	
	//.........................//
	
	binCoef(7, 3)                             //> res8: Double = 35.0
	binCoef(7 - 1, 3 - 1)                     //> res9: Double = 15.0
	binCoef(7 - 1, 3)                         //> res10: Double = 20.0
	
	binCoef(7, 3) == ( binCoef(7 - 1, 3 - 1) + binCoef(7 - 1, 3) )
                                                  //> res11: Boolean = true
}