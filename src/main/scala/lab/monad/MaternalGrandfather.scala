package lab.monad

object MaternalGrandfather {

	def maternalGrandfather(p: Person): Maybe[Person] =
		p.mother flatMap { _.father }
 
  	def maternalGrandfatherNoFlatMap(p: Person): Maybe[Person] =
		p.mother match {
		    case Just(m) => m.father
		    case MaybeNot => MaybeNot
	  	}
 
	/*Person.persons foreach { p =>
	  	assert(maternalGrandfather(p) == maternalGrandfatherNoFlatMap(p))
	}*/
}