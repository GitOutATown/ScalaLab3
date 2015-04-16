package lab.tuples

object Tuple_lab {
	
	val pair = ("answer", 42)                 //> pair  : (String, Int) = (answer,42)
	val (label, value) = pair                 //> label  : String = answer
                                                  //| value  : Int = 42
	pair._1                                   //> res0: String = answer
	pair._2                                   //> res1: Int = 42
	
	'''                                       //> res2: Char('\'') = '
}