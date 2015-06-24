package lab.math.probability.ross.combinatorial_analysis

object scratchpad_3 {

	val l1 = List(1,2,3,4,5)                  //> l1  : List[Int] = List(1, 2, 3, 4, 5)
	val l2 = List(2,4,5,6,8,9,11)             //> l2  : List[Int] = List(2, 4, 5, 6, 8, 9, 11)
	val l3 = List(4,5,6,7)                    //> l3  : List[Int] = List(4, 5, 6, 7)
	val multi1 = List(l2, l3)                 //> multi1  : List[List[Int]] = List(List(2, 4, 5, 6, 8, 9, 11), List(4, 5, 6, 7
                                                  //| ))
	val multi2 = List(l1, l2, l3)             //> multi2  : List[List[Int]] = List(List(1, 2, 3, 4, 5), List(2, 4, 5, 6, 8, 9,
                                                  //|  11), List(4, 5, 6, 7))
	
	val res1 = l1.filter(x => l2.contains(x)) //> res1  : List[Int] = List(2, 4, 5)
	res1.filter(x => l3.contains(x))          //> res0: List[Int] = List(4, 5)
	
	def andFilter(a: List[Int], b: List[Int]): List[Int] = {
		a.filter(term => b.contains(term))
	}                                         //> andFilter: (a: List[Int], b: List[Int])List[Int]
		
	def recursiveAnd(x0: List[Int], xs0: List[List[Int]]): List[Int] = {
		xs0 match {
			case Nil => x0
			case x1 :: Nil => andFilter(x0, x1)
			case x1 :: xs1 => recursiveAnd(andFilter(x0, x1), xs1)
		}
	}                                         //> recursiveAnd: (x0: List[Int], xs0: List[List[Int]])List[Int]
	
	recursiveAnd(l1, multi1)                  //> res1: List[Int] = List(4, 5)
	
	def recursiveAnd_v2(xs0: List[List[Int]]): List[Int] = {
		xs0 match {
			case x :: Nil => x
			case x :: xs => recursiveAnd_v2(andFilter(x, xs.head) :: xs.tail)
		}
	}                                         //> recursiveAnd_v2: (xs0: List[List[Int]])List[Int]
	
	recursiveAnd_v2(multi2)                   //> res2: List[Int] = List(4, 5)
	
	def recursiveAnd_v3(xs0: List[List[Int]]): List[Int] = {
		xs0 match {
			case x :: Nil => x
			case x :: xs => recursiveAnd_v3(x.filter(xs.head.contains(_)) :: xs.tail)
		}
	}                                         //> recursiveAnd_v3: (xs0: List[List[Int]])List[Int]
	
	recursiveAnd_v3(multi2)                   //> res3: List[Int] = List(4, 5)
}
/*


*/