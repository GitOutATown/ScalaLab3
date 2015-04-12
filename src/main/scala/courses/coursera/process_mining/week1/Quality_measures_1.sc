package courses.coursera.process_mining.week1
import courses.coursera.process_mining.util.math.MathUtil.roundAt

object Quality_measures_1 {
	// tp = true positive
	// fp = false positive
	// tn = true negative
	// fn = false negative

	// 1 is best
	def precision(tp: Double, fp: Double) = tp / (tp + fp)
                                                  //> precision: (tp: Double, fp: Double)Double
	// 1 is best
	def recall(tp: Double, fn: Double) = tp / (tp + fn)
                                                  //> recall: (tp: Double, fn: Double)Double
  // pr = precision, rc = recall
  def F1(pr: Double, rc: Double) = (2 * pr * rc) / (pr + rc)
                                                  //> F1: (pr: Double, rc: Double)Double
  val rnd = roundAt(3)_                           //> rnd  : Double => Double = <function1>
  // ----------------------- //
  
  val tp = 546                                    //> tp  : Int = 546
  val fp = 314                                    //> fp  : Int = 314
  val fn = 0                                      //> fn  : Int = 0
  val tn = 0                                      //> tn  : Int = 0
  
  // .............. //
  
  val pr = rnd(precision(tp, fp))                 //> pr  : Double = 0.635
  val rc = rnd(recall(tp, fn))                    //> rc  : Double = 1.0
  val f1 = rnd(F1(pr, rc))                        //> f1  : Double = 0.777
  
  // .............. //
  
  val pr2 = rnd(precision(544, 251))              //> pr2  : Double = 0.684
  val rc2 = rnd(recall(544, 2))                   //> rc2  : Double = 0.996
  rnd(F1(pr2, rc2))                               //> res0: Double = 0.811
  
  // .............. //
  
  rnd(recall(250, 25))                            //> res1: Double = 0.909
  
  /*
  rnd(precision(,))
  rnd(recall(,))
  rnd(F1(,))
  */
  
}
/*



*/