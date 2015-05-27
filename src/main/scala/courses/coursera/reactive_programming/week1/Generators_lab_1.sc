package courses.coursera.reactive_programming.week1

object Generators_lab_1 {

	// java.util.Random
	import java.util.Random
	val rand = new Random                     //> rand  : java.util.Random = java.util.Random@1f5e4ae5
	rand.nextInt                              //> res0: Int = 180576576
	rand.nextInt                              //> res1: Int = -1993729828
	rand.nextBoolean                          //> res2: Boolean = true
	rand.nextBoolean                          //> res3: Boolean = true
	rand.nextGaussian                         //> res4: Double = 1.6248512817542973
	rand.nextDouble                           //> res5: Double = 0.46350008495656403
	
	// ----- boilerplate -------------- //
	
	trait Generator[+T] {
		def generate: T
	}
	
	val integers = new Generator[Int] {
		val rand = new Random
		def generate = rand.nextInt
	}                                         //> integers  : courses.coursera.reactive_programming.week1.Generators_lab_1.Gen
                                                  //| erator[Int]{val rand: java.util.Random} = courses.coursera.reactive_programm
                                                  //| ing.week1.Generators_lab_1$$anonfun$main$1$$anon$1@3c09ff77
  val booleans = new Generator[Boolean] {
  		def generate = integers.generate > 0
  }                                               //> booleans  : courses.coursera.reactive_programming.week1.Generators_lab_1.Gen
                                                  //| erator[Boolean] = courses.coursera.reactive_programming.week1.Generators_lab
                                                  //| _1$$anonfun$main$1$$anon$2@78c26d7
  val intPairs = new Generator[(Int, Int)] {
  		def generate = (integers.generate, integers.generate)
  }                                               //> intPairs  : courses.coursera.reactive_programming.week1.Generators_lab_1.Gen
                                                  //| erator[(Int, Int)] = courses.coursera.reactive_programming.week1.Generators_
                                                  //| lab_1$$anonfun$main$1$$anon$3@6b030dea
  // ----- calls ------------------- //
  
  //val bools1 = for(x <- integers) yield (x > 0)
  
  intPairs.generate                               //> res6: (Int, Int) = (-82615295,1957377256)
  intPairs.generate                               //> res7: (Int, Int) = (57855869,-1773900603)
  
  booleans.generate                               //> res8: Boolean = false
  booleans.generate                               //> res9: Boolean = true
  
  integers.generate                               //> res10: Int = -355087589
  integers.generate                               //> res11: Int = 1743575920
  
  
	
}
/*






*/