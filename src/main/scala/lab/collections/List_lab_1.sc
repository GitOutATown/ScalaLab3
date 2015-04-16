package lab.collections

object List_lab_1 {
	
	val xs = List(2,3,4)                      //> xs  : List[Int] = List(2, 3, 4)
	val x = 1                                 //> x  : Int = 1
	
	x :: xs                                   //> res0: List[Int] = List(1, 2, 3, 4)
	
	x +: xs  // creates a new collection with leading element x
                                                  //> res1: List[Int] = List(1, 2, 3, 4)
	xs :+ x  // creates a new collection with trailing element x
                                                  //> res2: List[Int] = List(2, 3, 4, 1)
	'''                                       //> res3: Char('\'') = '
}