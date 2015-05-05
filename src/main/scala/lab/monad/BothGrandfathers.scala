package lab.monad

object BothGrandfathers {
	
	def bothGrandfathersFlatMap(p: Person): Maybe[(Person, Person)] =
	  p.mother flatMap { m =>
	    m.father flatMap { fm =>
	      p.father flatMap { f =>
	        f.father flatMap { ff => 
	          Just(fm, ff) // Never gets this far if any parent is MaybeNot along the way.
	        }
	      }
	    }
	  }
	 
	def bothGrandfathersNoFlatMap(p: Person): Maybe[(Person, Person)] =
	  (p.mother, p.father) match {
	    case (Just(m), Just(f)) =>
	      (m.father, f.father) match {
	        case (Just(fm), Just(ff)) => Just((fm, ff))
	        case _ => MaybeNot
	      }
	    case _ => MaybeNot
	  }
	 
	def assertBothGrandfathers(
	  bothGrandfathers1: Person => Maybe[(Person, Person)],
	  bothGrandfathers2: Person => Maybe[(Person, Person)]) =
	  Person.persons foreach { p =>
	    assert(bothGrandfathers1(p) == bothGrandfathers2(p))
	  }
	 
	assertBothGrandfathers(bothGrandfathersFlatMap, bothGrandfathersNoFlatMap)
}