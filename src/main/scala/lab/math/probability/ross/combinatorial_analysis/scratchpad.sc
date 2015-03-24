package lab.math.probability.ross.combinatorial_analysis

import lab.math.probability.ross.combinatorial_analysis.Combinatorics._

// Examples 1.1, 1.2
object scratchpad {
	10 * 3                                    //> res0: Int(30) = 30
	
	val women = 1 to 10                       //> women  : scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6
                                                  //| , 7, 8, 9, 10)
	val children = 1 to 3                     //> children  : scala.collection.immutable.Range.Inclusive = Range(1, 2, 3)
	
	val choices = for{
		w <- women
		c <- children
	} yield (w,c)                             //> choices  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1),
                                                  //|  (1,2), (1,3), (2,1), (2,2), (2,3), (3,1), (3,2), (3,3), (4,1), (4,2), (4,3)
                                                  //| , (5,1), (5,2), (5,3), (6,1), (6,2), (6,3), (7,1), (7,2), (7,3), (8,1), (8,2
                                                  //| ), (8,3), (9,1), (9,2), (9,3), (10,1), (10,2), (10,3))
	choices.length                            //> res1: Int = 30
	
	// ------------------------------ //
	
	3 * 4 * 5 * 2                             //> res2: Int = 120
	
	26 * 26 * 26 * 10 * 10 * 10 * 10          //> res3: Int = 175760000
	
	26 * 25 * 24 * 10 * 9 * 8 * 7             //> res4: Int = 78624000
	
	// ----------------------------- //
	
	val abc = List('a', 'b', 'c')             //> abc  : List[Char] = List(a, b, c)
	val perms = abc.permutations              //> perms  : Iterator[List[Char]] = non-empty iterator
	3 * 2 * 1                                 //> res5: Int = 6
	//perms.length // 6
	perms.foreach(println)                    //> List(a, b, c)
                                                  //| List(a, c, b)
                                                  //| List(b, a, c)
                                                  //| List(b, c, a)
                                                  //| List(c, a, b)
                                                  //| List(c, b, a)
  
	fac(3)                                    //> fac(3): 6
                                                  //| res6: Int = 6
	fac(9)                                    //> fac(9): 362880
                                                  //| res7: Int = 362880
  fac(10)                                         //> fac(10): 3628800
                                                  //| res8: Int = 3628800
  fac(6) * fac(4)                                 //> fac(6): 720
                                                  //| fac(4): 24
                                                  //| res9: Int = 17280
  fac(4) * fac(4) * fac(3) * fac(2) * fac(1)      //> fac(4): 24
                                                  //| fac(4): 24
                                                  //| fac(3): 6
                                                  //| fac(2): 2
                                                  //| fac(1): 1
                                                  //| res10: Int = 6912
  fac(6) / (fac(3) * fac(2))                      //> fac(6): 720
                                                  //| fac(3): 6
                                                  //| fac(2): 2
                                                  //| res11: Int = 60
  fac(10) / (fac(4) * fac(3) * fac(2) * fac(1))   //> fac(10): 3628800
                                                  //| fac(4): 24
                                                  //| fac(3): 6
                                                  //| fac(2): 2
                                                  //| fac(1): 1
                                                  //| res12: Int = 12600
  fac(9) / (fac(4) * fac(3) * fac(2))             //> fac(9): 362880
                                                  //| fac(4): 24
                                                  //| fac(3): 6
                                                  //| fac(2): 2
                                                  //| res13: Int = 1260
  binCoef(4, 2)                                   //> res14: Double = 6.0

}
/*





*/