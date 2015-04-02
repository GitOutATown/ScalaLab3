package lab.math.probability.ross.combinatorial_analysis

import lab.math.probability.ross.combinatorial_analysis.Combinatorics._
 
object lab_3 {
	// 4c
	
	// Recursive
	def failSeq(perms: List[Int]): Boolean = {
  		perms match {
  			case x :: Nil => true
  			case x :: xs => {
  				if(x == 0 && x == xs.head) false
  				else failSeq(xs)
  			}
  		}
  } // end filter                                 //> failSeq: (perms: List[Int])Boolean
  
  def diagnostic(perms: Int, filtered: Int) {
  		println(filtered + "/" + perms)
  }                                               //> diagnostic: (perms: Int, filtered: Int)Unit
 
  // ....... test 1
  val perms1 = List(1,1,0,0).permutations.toList  //> perms1  : List[List[Int]] = List(List(1, 1, 0, 0), List(1, 0, 1, 0), List(1,
                                                  //|  0, 0, 1), List(0, 1, 1, 0), List(0, 1, 0, 1), List(0, 0, 1, 1))
  
  val res1 = perms1.filter(failSeq(_))            //> res1  : List[List[Int]] = List(List(1, 0, 1, 0), List(0, 1, 1, 0), List(0, 1
                                                  //| , 0, 1))
  diagnostic(perms1.length, res1.length)          //> 3/6
  // (n - m + 1, m)
  binCoef(4 - 2 + 1, 2)                           //> res0: Double = 3.0
  
  //....... test 2
  val perms2 = List(1,1,1,0,0,0).permutations.toList
                                                  //> perms2  : List[List[Int]] = List(List(1, 1, 1, 0, 0, 0), List(1, 1, 0, 1, 0,
                                                  //|  0), List(1, 1, 0, 0, 1, 0), List(1, 1, 0, 0, 0, 1), List(1, 0, 1, 1, 0, 0),
                                                  //|  List(1, 0, 1, 0, 1, 0), List(1, 0, 1, 0, 0, 1), List(1, 0, 0, 1, 1, 0), Lis
                                                  //| t(1, 0, 0, 1, 0, 1), List(1, 0, 0, 0, 1, 1), List(0, 1, 1, 1, 0, 0), List(0,
                                                  //|  1, 1, 0, 1, 0), List(0, 1, 1, 0, 0, 1), List(0, 1, 0, 1, 1, 0), List(0, 1, 
                                                  //| 0, 1, 0, 1), List(0, 1, 0, 0, 1, 1), List(0, 0, 1, 1, 1, 0), List(0, 0, 1, 1
                                                  //| , 0, 1), List(0, 0, 1, 0, 1, 1), List(0, 0, 0, 1, 1, 1))
  
  val res2 = perms2.filter(failSeq(_))            //> res2  : List[List[Int]] = List(List(1, 0, 1, 0, 1, 0), List(0, 1, 1, 0, 1, 0
                                                  //| ), List(0, 1, 0, 1, 1, 0), List(0, 1, 0, 1, 0, 1))
  diagnostic(perms2.length, res2.length)          //> 4/20
  binCoef(6 - 3 + 1, 3)                           //> res1: Double = 4.0
	
	//....... test 3
  val perms3 = List(1,1,0,0,0).permutations.toList//> perms3  : List[List[Int]] = List(List(1, 1, 0, 0, 0), List(1, 0, 1, 0, 0), L
                                                  //| ist(1, 0, 0, 1, 0), List(1, 0, 0, 0, 1), List(0, 1, 1, 0, 0), List(0, 1, 0, 
                                                  //| 1, 0), List(0, 1, 0, 0, 1), List(0, 0, 1, 1, 0), List(0, 0, 1, 0, 1), List(0
                                                  //| , 0, 0, 1, 1))
  
  val res3 = perms3.filter(failSeq(_))            //> res3  : List[List[Int]] = List(List(0, 1, 0, 1, 0))
  diagnostic(perms3.length, res3.length)          //> 1/10
  binCoef(5 - 3 + 1, 3)                           //> res2: Double = 1.0
}
/*



*/