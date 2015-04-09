package lab.math

object HarmonicMean {

	3d / ((1/1d) + (1/2d) + (1/4d))           //> res0: Double = 1.7142857142857142
	12/7d                                     //> res1: Double(1.7142857142857142) = 1.7142857142857142
	
	def harmMean_v1(xs: List[Double]) = {
		val n = xs.length
		val recips = xs map (1/_)
		n / recips.sum
	}                                         //> harmMean_v1: (xs: List[Double])Double
	
	def harmMean_v3(xs: List[Double]) = {
		val n = xs.length
		val numer_part = xs.reduce(_ * _)
		val denom_part = xs.map(numer_part / _)
		(numer_part * n) / (denom_part.sum)
	}                                         //> harmMean_v3: (xs: List[Double])Double
	
	harmMean_v1(List(1d, 2, 4))               //> res2: Double = 1.7142857142857142
  harmMean_v3(List(1d, 2, 4))                     //> res3: Double = 1.7142857142857142
  
  println("---------------------------")          //> ---------------------------

	harmMean_v1(List(9d, 2, 4))               //> res4: Double = 3.4838709677419355
	harmMean_v3(List(9d, 2, 4))               //> res5: Double = 3.4838709677419355
	
	println("---------------------------")    //> ---------------------------
	
	harmMean_v1(List(9d, 2.02, 4, 27.9))      //> res6: Double = 4.484290303651174
	harmMean_v3(List(9d, 2.02, 4, 27.9))      //> res7: Double = 4.484290303651174
}
/*


*/