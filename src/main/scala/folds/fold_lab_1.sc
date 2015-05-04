package folds

object fold_lab_1 {
	
	List(4, 5, 6).reduce(_ * _)               //> res0: Int = 120
	List(4, 5, 6).fold(0)(_ * _)              //> res1: Int = 0
	List(4, 5, 6).fold(1)(_ * _)              //> res2: Int = 120
	List(4, 5, 6).fold(2)(_ * _)              //> res3: Int = 240
	List(4, 5, 6).foldLeft(2)(_ * _)          //> res4: Int = 240
	List(4, 5, 6).foldRight(2)(_ * _)         //> res5: Int = 240
}