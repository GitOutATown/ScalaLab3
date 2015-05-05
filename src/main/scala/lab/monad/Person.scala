package lab.monad

object Person {
 
	val persons = List("P", "MP", "MMP", "FMP", "FP", "MFP", "FFP") map { Person(_) }
 
	/* These are the actual mappings of extant relationships.
	 * And by the way, the mechanism here has no actual binding to the 
	 * List of instantiated Persons
	 */
	private val mothers = Map(
	    Person("P") -> Person("MP"),
	    Person("MP") -> Person("MMP"),
	    Person("FP") -> Person("MFP")
    )
  
    private val fathers = Map(
	    Person("P") -> Person("FP"),
	    Person("MP") -> Person("FMP"),
	    Person("FP") -> Person("FFP")
    )
  
    // Look up mappings
    def mother(p: Person): Maybe[Person] = relation(p, mothers)
    def father(p: Person): Maybe[Person] = relation(p, fathers)
  
    /* Look up mechanism and transformation from Some and None to 
     * Just and MaybeNot.
     */
    private def relation(
        p: Person,
        relationMap: Map[Person, Person]
    ) = relationMap.get(p) match {
        case Some(m) => Just(m) // This is where the filtering and assignment
	    case None => MaybeNot   // actually take place.
	}
}
 
case class Person(name: String) {
	def mother: Maybe[Person] = Person.mother(this)
	def father: Maybe[Person] = Person.father(this)
}


