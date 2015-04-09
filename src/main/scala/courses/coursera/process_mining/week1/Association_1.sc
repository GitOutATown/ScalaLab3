package courses.coursera.process_mining
   
import courses.coursera.process_mining.util.math.MathUtil._

object Association_1 {
	// 16-Association Rule Learning.pdf
	
	// {X:Pampers} => {Y:Dommelsch}

	val N = 100d                              //> N  : Double = 100.0
	val numUnionBoth = 51d                    //> numUnionBoth  : Double = 51.0
	val NX = 91d                              //> NX  : Double = 91.0
	val NY = 51d                              //> NY  : Double = 51.0
	// ---------------------- //
	val round = roundAt(2)_                   //> round  : Double => Double = <function1>
	val support = round(numUnionBoth / N)     //> support  : Double = 0.51
	val confidence = round(numUnionBoth / NX) //> confidence  : Double = 0.56
	val lift = round((numUnionBoth * N) / (NX * NY))
                                                  //> lift  : Double = 1.1
}