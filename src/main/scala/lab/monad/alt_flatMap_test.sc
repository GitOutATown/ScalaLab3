package lab.monad

object alt_flatMap_test {

	// Last, but not least
	def altFlatMap(
	    m: Maybe[Person],
	    f: Person => Maybe[Person]
	): Maybe[Person] = m.map(f).flatten       //> altFlatMap: (m: lab.monad.Maybe[lab.monad.Person], f: lab.monad.Person => la
                                                  //| b.monad.Maybe[lab.monad.Person])lab.monad.Maybe[lab.monad.Person]

	val maybes = MaybeNot +: (Person.persons map { Just(_) })
                                                  //> maybes  : List[Product with Serializable with lab.monad.Maybe[lab.monad.Pers
                                                  //| on]] = List(MaybeNot, Just(Person(P)), Just(Person(MP)), Just(Person(MMP)), 
                                                  //| Just(Person(FMP)), Just(Person(FP)), Just(Person(MFP)), Just(Person(FFP)))

	maybes foreach { m =>
  		assert(altFlatMap(m, _.mother) == (m flatMap { _.mother }))
	}

	'''                                       //> res0: Char('\'') = '
}