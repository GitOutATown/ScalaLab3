package courses.coursera.process_mining

import math._

object Entropy_lab_1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // See ScalaLab2/src/main/scala/lab/math/logarithm_lab.sc
  // https://groups.google.com/forum/#!topic/scala-language/K5tbYSYqQc8
  def log2(x: Double) = scala.math.log(x)/scala.math.log(2)
                                                  //> log2: (x: Double)Double
  /*-------------------------------------------
  "How many 2s need to be multiplied to get x?"
  log2(x) = y
  2^y = x
  log2(2^x) = x
  log2(1/(2^x)) = -x
  -------------------------------------------*/
  
  val y1 = log2(5d)                               //> y1  : Double = 2.321928094887362
  val x = pow(2d, y1)                             //> x  : Double = 4.999999999999999
  pow(2d, 5d)                                     //> res0: Double = 32.0
  pow(2d, x)                                      //> res1: Double = 31.99999999999998
  log2(pow(2d, 5d))                               //> res2: Double = 5.0
  log2(pow(2d, x))                                //> res3: Double = 4.999999999999999
  log2(1/pow(2,5d))                               //> res4: Double = -5.0
  log2(1/pow(2,x))                                //> res5: Double = -4.999999999999999
  
  log2(0.125)                                     //> res6: Double = -3.0
  pow(2d,-3d)                                     //> res7: Double = 0.125
  log2(1)                                         //> res8: Double = 0.0
  log2(2)                                         //> res9: Double = 1.0
  log2(8)                                         //> res10: Double = 3.0
  log2(1024)                                      //> res11: Double = 10.0
  
  pow(2,10)                                       //> res12: Double = 1024.0
  pow(2,20)                                       //> res13: Double = 1048576.0
  pow(2,30)                                       //> res14: Double = 1.073741824E9
  pow(2,100)                                      //> res15: Double = 1.2676506002282294E30
}
/*



*/