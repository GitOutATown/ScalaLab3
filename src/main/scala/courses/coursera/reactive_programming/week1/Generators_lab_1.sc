package courses.coursera.reactive_programming.week1

object Generators_lab_1 {

	// java.util.Random
	import java.util.Random
	val rand = new Random                     //> rand  : java.util.Random = java.util.Random@1f7e6153
	rand.nextInt                              //> res0: Int = -1872136868
	rand.nextInt                              //> res1: Int = -1875755455
	rand.nextBoolean                          //> res2: Boolean = true
	rand.nextBoolean                          //> res3: Boolean = false
	rand.nextGaussian                         //> res4: Double = -1.6696513548451581
	rand.nextDouble                           //> res5: Double = 0.9379564435691855
	
	// ----- boilerplate -------------- //
	
	trait Generator[+T] {
		def generate: T
	}
	
	val integers = new Generator[Int] {
		val rand = new Random
		def generate = rand.nextInt
	}                                         //> integers  : courses.coursera.reactive_programming.week1.Generators_lab_1.Gen
                                                  //| erator[Int]{val rand: java.util.Random} = courses.coursera.reactive_programm
                                                  //| ing.week1.Generators_lab_1$$anonfun$main$1$$anon$1@40e54538
  val booleans = new Generator[Boolean] {
  		def generate = integers.generate > 0
  }                                               //> booleans  : courses.coursera.reactive_programming.week1.Generators_lab_1.Gen
                                                  //| erator[Boolean] = courses.coursera.reactive_programming.week1.Generators_lab
                                                  //| _1$$anonfun$main$1$$anon$2@38ea5fcd
  val intPairs = new Generator[(Int, Int)] {
  		def generate = (integers.generate, integers.generate)
  }                                               //> intPairs  : courses.coursera.reactive_programming.week1.Generators_lab_1.Gen
                                                  //| erator[(Int, Int)] = courses.coursera.reactive_programming.week1.Generators_
                                                  //| lab_1$$anonfun$main$1$$anon$3@514b50a9
  // ----- calls ------------------- //
  
  //val bools1 = for(x <- integers) yield (x > 0)
  
  intPairs.generate                               //> res6: (Int, Int) = (-406427486,91154312)
  intPairs.generate                               //> res7: (Int, Int) = (-933731165,183364577)
  
  booleans.generate                               //> res8: Boolean = true
  booleans.generate                               //> res9: Boolean = false
  
  integers.generate                               //> res10: Int = -1224629516
  integers.generate                               //> res11: Int = -603465435
  
  
	
	'''                                       //> res12: Char('\'') = '
}
/*






*/