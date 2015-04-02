package lab.math.probability.ross.combinatorial_analysis
 
import lab.math.probability.ross.combinatorial_analysis.Combinatorics._

// Examples 1.4 Combinations
object lab_2 {

	// Combinations of all possible groups of 3 objects out of 5.
  
  binCoef(5, 3)                                   //> res0: Double = 10.0
  fac(5) / (fac(5 - 3) * fac(3))                  //> fac(5): 120
                                                  //| fac(2): 2
                                                  //| fac(3): 6
                                                  //| res1: Int = 10
  fac(5) / (fac(5 - 2) * fac(2))                  //> fac(5): 120
                                                  //| fac(3): 6
                                                  //| fac(2): 2
                                                  //| res2: Int = 10
  // See p.6 ch 1
  
  val objs1 = List('A', 'B', 'C', 'D', 'E')       //> objs1  : List[Char] = List(A, B, C, D, E)
	// length 10
	objs1.combinations(3).foreach(println)    //> List(A, B, C)
                                                  //| List(A, B, D)
                                                  //| List(A, B, E)
                                                  //| List(A, C, D)
                                                  //| List(A, C, E)
                                                  //| List(A, D, E)
                                                  //| List(B, C, D)
                                                  //| List(B, C, E)
                                                  //| List(B, D, E)
                                                  //| List(C, D, E)
  // Permutations of all possible groups of 3 objcts out of 5.
  5 * 4 * 3                                       //> res3: Int = 60
  objs1.combinations(3).flatMap(_.permutations).length
                                                  //> res4: Int = 60
  // Combinations
  
  binCoef(20, 3)                                  //> res5: Double = 1140.0
  
  // ---------------------------------------------------- //
  
  // EXAMPLE 4b
	// From a group of 5 women and 7 men, how many different committees consisting of 2 women and 3 men can be formed?
	binCoef(5, 2) * binCoef(7, 3)             //> res6: Double = 350.0
  // All of the women
  binCoef(5, 2)                                   //> res7: Double = 10.0
  
	// All of the men
	val men = List('A', 'B', 'C', 'D', 'E', 'F', 'G')
                                                  //> men  : List[Char] = List(A, B, C, D, E, F, G)
  binCoef(7, 3)                                   //> res8: Double = 35.0
  
	
	men.combinations(3).length                //> res9: Int = 35
	
	
	//What if 2 of the men are feuding and refuse to serve on the committee together?
	
	// Feuding men (A and B)
	men.combinations(3).filter(g =>
		g.contains('A') && g.contains('B')
	).length                                  //> res10: Int = 5
	men.combinations(3).filter(g =>
		g.contains('A') && g.contains('B')
	).foreach(println)                        //> List(A, B, C)
                                                  //| List(A, B, D)
                                                  //| List(A, B, E)
                                                  //| List(A, B, F)
                                                  //| List(A, B, G)
  // These "no-go" committees are composed from two groups.
 	// The first group that provides the third, non-feuding member is
	List('C', 'D', 'E', 'F', 'G').combinations(1).length
                                                  //> res11: Int = 5
	binCoef(5, 1)                             //> res12: Double = 5.0
	List('C', 'D', 'E', 'F', 'G').combinations(1).flatten.foreach(println)
                                                  //> C
                                                  //| D
                                                  //| E
                                                  //| F
                                                  //| G
	// The second group providing the two members who won't work together is
  List('A', 'B').combinations(2).length           //> res13: Int = 1
  binCoef(2, 2)                                   //> res14: Double = 1.0
	List('A', 'B').combinations(2).foreach(println)
                                                  //> List(A, B)
	// In combination these two groups (of length 1 and 5) comprise the 5 possible committees that would contain the feuding men (listed above).
	1 * 5                                     //> res15: Int(5) = 5
	binCoef(2, 2) * binCoef(5, 1)             //> res16: Double = 5.0
	for {
		 x <- List('C', 'D', 'E', 'F', 'G')
	} yield (List('A', 'B') ++ List(x))       //> res17: List[List[Char]] = List(List(A, B, C), List(A, B, D), List(A, B, E),
                                                  //|  List(A, B, F), List(A, B, G))
	
	// Filtering out any group containing A and B
	men.combinations(3).filter(g =>
		!(g.contains('A') && g.contains('B'))
	).length                                  //> res18: Int = 30
	men.combinations(3).filter(g =>
		!(g.contains('A') && g.contains('B'))
	).foreach(println)                        //> List(A, C, D)
                                                  //| List(A, C, E)
                                                  //| List(A, C, F)
                                                  //| List(A, C, G)
                                                  //| List(A, D, E)
                                                  //| List(A, D, F)
                                                  //| List(A, D, G)
                                                  //| List(A, E, F)
                                                  //| List(A, E, G)
                                                  //| List(A, F, G)
                                                  //| List(B, C, D)
                                                  //| List(B, C, E)
                                                  //| List(B, C, F)
                                                  //| List(B, C, G)
                                                  //| List(B, D, E)
                                                  //| List(B, D, F)
                                                  //| List(B, D, G)
                                                  //| List(B, E, F)
                                                  //| List(B, E, G)
                                                  //| List(B, F, G)
                                                  //| List(C, D, E)
                                                  //| List(C, D, F)
                                                  //| List(C, D, G)
                                                  //| List(C, E, F)
                                                  //| List(C, E, G)
                                                  //| List(C, F, G)
                                                  //| List(D, E, F)
                                                  //| List(D, E, G)
                                                  //| List(D, F, G)
                                                  //| List(E, F, G)
  // So therefor, with all the women, and allowing for the feuding men, the number of possible committees are
  val allWomen = binCoef(5, 2)                    //> allWomen  : Double = 10.0
  val allMen = binCoef(7, 3)                      //> allMen  : Double = 35.0
  val feudingMen = binCoef(2, 2) * binCoef(5, 1)  //> feudingMen  : Double = 5.0
  allWomen * (allMen - feudingMen)                //> res19: Double = 300.0
}
/*




*/