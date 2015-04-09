package courses.coursera.process_mining

import util.math.MathUtil._

object Association_def1 {
	// 16-Association Rule Learning.pdf

	def support(NXUY: Double, N: Double) = {
		NXUY / N
	}                                         //> support: (NXUY: Double, N: Double)Double
	
	def confidence(NXUY: Double, NX: Double) = {
		NXUY / NX
	}                                         //> confidence: (NXUY: Double, NX: Double)Double
	
	def lift(NXUY: Double, N: Double, NX: Double, NY: Double) = {
		(NXUY * N) / (NX * NY)
	}                                         //> lift: (NXUY: Double, N: Double, NX: Double, NY: Double)Double
	
	// ----------------------------------- //
	val rnd = roundAt(2)_                     //> rnd  : Double => Double = <function1>
	
	// {Pampers} => {Dommelsch} = middling assoc
	rnd(support(51, 100))                     //> res0: Double = 0.51
	rnd(confidence(51, 91))                   //> res1: Double = 0.56
	rnd(lift(51, 100, 91, 51))                //> res2: Double = 1.1
	
	// {Pampers} => {Hoegaarden} = weak assoc
	rnd(support(1, 100))                      //> res3: Double = 0.01
	rnd(confidence(1, 91))                    //> res4: Double = 0.01
	rnd(lift(1, 100, 91, 10))                 //> res5: Double = 0.11
	
	// {Dommelsch} => {Pampers} = a bit stronger that the reverse assoc
	rnd(support(51, 100))                     //> res6: Double = 0.51
	rnd(confidence(51, 51))                   //> res7: Double = 1.0
	rnd(lift(51, 100, 51, 91))                //> res8: Double = 1.1
	
	// {Pampers, Dommelsch} => {Hoegaarden} = weak
	rnd(support(1, 100))                      //> res9: Double = 0.01
	rnd(confidence(1, 50))                    //> res10: Double = 0.02
	rnd(lift(1, 100, 50, 10))                 //> res11: Double = 0.2
}
/*





*/