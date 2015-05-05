package lab.monad

object Person {
 
	/*
	 * person, mother of person, father of ferson
	 * mother of mother of person (maternal grandmother)
	 * father of mother of Person (Maternal grandfather)
	 * mother of father of Person (Paternal grandmother)
	 * father of father of Person (Paternal grandfather)
	 */
	val persons = List("P", "MP", "MMP", "FMP", "FP", "MFP", "FFP") map { Person(_) }
 
	/* These are the actual mappings of extant relationships.
	 * And by the way, the mechanism here has no actual object reference 
	 * binding to the List of instantiated Persons.
	 */
	private val mothers = Map(
	    Person("P") -> Person("MP"),   // mother
	    Person("MP") -> Person("MMP"), // maternal grandmother
	    Person("FP") -> Person("MFP")  // paternal grandmother
    )
  
    private val fathers = Map(
	    Person("P") -> Person("FP"),   // father
	    Person("MP") -> Person("FMP"), // maternal grandfather
	    Person("FP") -> Person("FFP")  // paternal grandfather
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
	// buck stops at relationMap.get(this), i.e. Some => Just, None => MaybeNot
	def mother: Maybe[Person] = Person.mother(this)
	def father: Maybe[Person] = Person.father(this)
}


