package lab.monad

object MaternalGrandfather {

	def maternalGrandfather(p: Person): Maybe[Person] = {
	  /* This is trait Maybe def flatMap
	   * which is instantiated in both case class Just and object MaybeNot.
	   * So if p.mother exists, Person.relationship maps Some(m) => Just(m)
	   * and the Just.flatMap implementation calls f(a). f is _.father and 
	   * a is the mother Person (i.e. the maternal grandfather). We transform
	   * Some to Just in order to provide application behavior.
	   * If p has no mother, Person.relationship maps None => MaybeNot and 
	   * MaybeNot uses flatMap(f: Nothing => Maybe[B]) = MaybeNot
	   */
	  p.mother flatMap { _.father } // "_.father" is an argument to the flatMap function parameter as implemented for trait Maybe by Just and MaybeNot.
	} 
 
  	def maternalGrandfatherNoFlatMap(p: Person): Maybe[Person] =
		p.mother match {
		    case Just(m) => m.father
		    case MaybeNot => MaybeNot
	  	}
}