package lab.math.probability.ross.combinatorial_analysis

import lab.math.probability.common.Combinatorics._
 
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
  } // end filter
  
  def diagnostic(perms: Int, filtered: Int) {
  		println(filtered + "/" + perms)
  }
 
  // ....... test 1
  val perms1 = List(1,1,0,0).permutations.toList
  
  val res1 = perms1.filter(failSeq(_))
  diagnostic(perms1.length, res1.length)
  // (n - m + 1, m)
  binCoef(4 - 2 + 1, 2)
  
  //....... test 2
  val perms2 = List(1,1,1,0,0,0).permutations.toList
  
  val res2 = perms2.filter(failSeq(_))
  diagnostic(perms2.length, res2.length)
  binCoef(6 - 3 + 1, 3)
	
	//....... test 3
  val perms3 = List(1,1,0,0,0).permutations.toList
  
  val res3 = perms3.filter(failSeq(_))
  diagnostic(perms3.length, res3.length)
  binCoef(5 - 3 + 1, 3)
}
/*




*/