package lab.odersky.acm

object Article_tut_1 {
	
	class Person(val name: String, val age: Int) {
		override def toString = s"$name ($age)"
	}
	
	val persons = List(
		new Person("Mike Jones", 37),
		new Person("Sandra O'Connor", 95),
		new Person("Ricky Romero", 13),
		new Person("Algernon Blackwood", 3)
	)                                         //> persons  : List[lab.odersky.acm.Article_tut_1.Person] = List(Mike Jones (37)
                                                  //| , Sandra O'Connor (95), Ricky Romero (13), Algernon Blackwood (3))
  // Example of functional combinator
	// Takes a function predicate. Short for annonymous function x => x.age < 18
	val (minors, adults) = persons partition(_.age < 18)
                                                  //> minors  : List[lab.odersky.acm.Article_tut_1.Person] = List(Ricky Romero (13
                                                  //| ), Algernon Blackwood (3))
                                                  //| adults  : List[lab.odersky.acm.Article_tut_1.Person] = List(Mike Jones (37),
                                                  //|  Sandra O'Connor (95))
  // ------------------------------ //
  
  trait Try[T] {
  		def get: T
  }
  case class Success[T](value: T) extends Try[T] {
  		def get = value
  }
  case class Failure[T](ex: Exception) {
  		def get = throw ex
  }
}
/*





*/