package lab.monad
 
object Monad_laws {

	Person.persons foreach { p =>
  		// left unit
  		assert((Just(p) flatMap { _.mother }) == p.mother)
	}
 
	val maybes = MaybeNot +: (Person.persons map { Just(_) })
                                                  //> maybes  : List[Product with Serializable with lab.monad.Maybe[lab.monad.Pers
                                                  //| on]] = List(MaybeNot, Just(Person(P)), Just(Person(MP)), Just(Person(MMP)), 
                                                  //| Just(Person(FMP)), Just(Person(FP)), Just(Person(MFP)), Just(Person(FFP)))
	maybes foreach { m => {
		println("m: " + m + " | m.flatMap: " + (m flatMap{Just(_)}))
  		// right unit
  		assert((m flatMap { Just(_) }) == m)
  	}
 
  		// associativity
	  assert(
	    (m flatMap { _.mother } flatMap { _.father }) ==
	    (m flatMap { _.mother flatMap { _.father } }))
                                                  //> m: MaybeNot | m.flatMap: MaybeNot
                                                  //| m: Just(Person(P)) | m.flatMap: Just(Person(P))
                                                  //| m: Just(Person(MP)) | m.flatMap: Just(Person(MP))
                                                  //| m: Just(Person(MMP)) | m.flatMap: Just(Person(MMP))
                                                  //| m: Just(Person(FMP)) | m.flatMap: Just(Person(FMP))
                                                  //| m: Just(Person(FP)) | m.flatMap: Just(Person(FP))
                                                  //| m: Just(Person(MFP)) | m.flatMap: Just(Person(MFP))
                                                  //| m: Just(Person(FFP)) | m.flatMap: Just(Person(FFP))
	}

	'''                                       //> res0: Char('\'') = '
}