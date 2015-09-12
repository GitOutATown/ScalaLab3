package lab.feature_scaling

import math.{pow, sqrt}

object FeatureScaling_lab_1 {

  // https://en.wikipedia.org/wiki/Feature_scaling

  val r = scala.util.Random                       //> r  : util.Random.type = scala.util.Random$@530b61a
  
  r.nextFloat                                     //> res0: Float = 0.4138611
  r.nextFloat * 10                                //> res1: Float = 0.008054376
  r.nextFloat * 100                               //> res2: Float = 67.01492
  
  val x1 = Seq.fill(10)(r.nextFloat)              //> x1  : Seq[Float] = List(0.32124084, 0.29015297, 0.3826388, 0.83364815, 0.370
                                                  //| 93222, 0.49557918, 0.07767004, 0.27224422, 0.32366848, 0.73070544)
  Seq.fill(10)(r.nextFloat * 10)                  //> res3: Seq[Float] = List(6.322213, 5.2590423, 9.912418, 4.516471, 9.586183, 4
                                                  //| .9660163, 8.133337, 1.7614108, 5.6425757, 6.9950266)
  Seq.fill(10)(r.nextFloat * 100)                 //> res4: Seq[Float] = List(27.496767, 57.22667, 93.84362, 86.44572, 47.591747, 
                                                  //| 45.367653, 36.600296, 48.39126, 40.05057, 83.38325)
  
  val x1z = x1.zipWithIndex                       //> x1z  : Seq[(Float, Int)] = List((0.32124084,0), (0.29015297,1), (0.3826388,2
                                                  //| ), (0.83364815,3), (0.37093222,4), (0.49557918,5), (0.07767004,6), (0.272244
                                                  //| 22,7), (0.32366848,8), (0.73070544,9))
  
  val lrgFeats = List(3,5)                        //> lrgFeats  : List[Int] = List(3, 5)
  x1z.map{
    case (v, ind) => if(lrgFeats.contains(ind) ) v * 100 else v
  }                                               //> res5: Seq[Float] = List(0.32124084, 0.29015297, 0.3826388, 83.364815, 0.3709
                                                  //| 3222, 49.55792, 0.07767004, 0.27224422, 0.32366848, 0.73070544)
  
  def alter(x: Seq[Float]) = {
    val zipped = x.zipWithIndex
    zipped.map{
	    case (v, ind) => if(lrgFeats.contains(ind) ) v * 100 else v
	  }
  }                                               //> alter: (x: Seq[Float])Seq[Float]
  
  val x1a = alter(x1)                             //> x1a  : Seq[Float] = List(0.32124084, 0.29015297, 0.3826388, 83.364815, 0.370
                                                  //| 93222, 49.55792, 0.07767004, 0.27224422, 0.32366848, 0.73070544)
  def mean(x: Seq[Float]) = {
    x.sum / x.length.toFloat
  }                                               //> mean: (x: Seq[Float])Float
  
  // The average of the squared differences from the mean
  def variance(x: Seq[Float]) = {
    val m = mean(x)
    
    println("x: " + x)
    println("m: " + m)
    
    val sqrDiffs = x.map(xi => pow(xi - m, 2))
    
    sqrDiffs.sum / x.length.toFloat
  }                                               //> variance: (x: Seq[Float])Double
  
  def stdDev(x: Seq[Float]) = {
    sqrt(variance(x))
  }                                               //> stdDev: (x: Seq[Float])Double
  
  x1a.min                                         //> res6: Float = 0.07767004
  x1a.max                                         //> res7: Float = 83.364815
  x1a.sum                                         //> res8: Float = 135.692
  val var1 = variance(x1a)                        //> x: List(0.32124084, 0.29015297, 0.3826388, 83.364815, 0.37093222, 49.55792,
                                                  //|  0.07767004, 0.27224422, 0.32366848, 0.73070544)
                                                  //| m: 13.5692005
                                                  //| var1  : Double = 756.5638479368283
  val stdev1 = stdDev(x1a)                        //> x: List(0.32124084, 0.29015297, 0.3826388, 83.364815, 0.37093222, 49.55792,
                                                  //|  0.07767004, 0.27224422, 0.32366848, 0.73070544)
                                                  //| m: 13.5692005
                                                  //| stdev1  : Double = 27.505705734207737
  
  // ---- Rescaling ---------------- //
  
  def rescale(x: Seq[Float]) = {
    x.map{ xi =>
      (xi - x.min) / (x.max - x.min)
    }
  }                                               //> rescale: (x: Seq[Float])Seq[Float]
  
  val rescale1 = rescale(x1a)                     //> rescale1  : Seq[Float] = List(0.0029244705, 0.0025512092, 0.0036616547, 1.0
                                                  //| , 0.0035210976, 0.59409225, 0.0, 0.002336185, 0.0029536183, 0.00784077)
  val test1 = for {
    i <- 1 to 3
  } yield rescale(alter(Seq.fill(10)(r.nextFloat)))
                                                  //> test1  : scala.collection.immutable.IndexedSeq[Seq[Float]] = Vector(List(5.
                                                  //| 354326E-4, 0.0, 0.004479754, 1.0, 1.6647846E-4, 0.28038698, 3.8050735E-4, 0
                                                  //| .0046105646, 0.003371833, 8.184583E-5), List(0.0033920344, 0.003854756, 0.0
                                                  //| 051134373, 1.0, 0.0, 0.21848553, 4.9040857E-4, 0.0019668874, 0.0038530722, 
                                                  //| 0.0021198979), List(0.003609931, 0.0, 0.008262255, 0.3194154, 0.009619948, 
                                                  //| 1.0, 0.008390868, 0.0013776076, 0.005458129, 0.0072895507))
  // ------ Standardization ---------- //
  
  def standardize(x: Seq[Float]) = {
    val m = mean(x)
    val sd = stdDev(x)
    val result = x.map(xi => (xi - m) / sd)
    result
  }                                               //> standardize: (x: Seq[Float])Seq[Double]
  
  val stdz1 = standardize(x1a)                    //> x: List(0.32124084, 0.29015297, 0.3826388, 83.364815, 0.37093222, 49.55792,
                                                  //|  0.07767004, 0.27224422, 0.32366848, 0.73070544)
                                                  //| m: 13.5692005
                                                  //| stdz1  : Seq[Double] = List(-0.4816440711848834, -0.4827743048777258, -0.47
                                                  //| 94118613751132, 2.5374959226405287, -0.47983745860744775, 1.308409116030444
                                                  //| 7, -0.4904993367109692, -0.48342537329554885, -0.4815557965980383, -0.46675
                                                  //| 752945869275)
  // ------ Scaling to unit length ------- //
  
  // square root of the sum of the squared elements. Pathagorean theorem.
  def eucNorm(x: Seq[Float]) = {
    val sqrs = x.map(xi => pow(xi, 2))
    sqrt(sqrs.sum)
  }                                               //> eucNorm: (x: Seq[Float])Double
  
  def unitScale(x: Seq[Float]) = {
    val en = eucNorm(x)
    x.map(xi => xi / en)
  }                                               //> unitScale: (x: Seq[Float])Seq[Double]
  
  val unit1 = unitScale(x1a)                      //> unit1  : Seq[Double] = List(0.003312136206266184, 0.002991606360728748, 0.0
                                                  //| 03945176628608277, 0.8595283814981379, 0.003824476463370121, 0.510964219664
                                                  //| 8622, 8.008126933244389E-4, 0.0028069591491277058, 0.0033371662312655977, 0
                                                  //| .007533898636423386)
  '''                                             //> res9: Char('\'') = '
}
/*



*/