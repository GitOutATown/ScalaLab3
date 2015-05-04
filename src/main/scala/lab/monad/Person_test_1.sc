package lab.monad

import lab.monad.MaternalGrandfather._
import lab.monad.Person._

object Person_test_1 {
	
	persons                                   //> res0: List[lab.monad.Person] = List(Person(P), Person(MP), Person(MMP), Pers
                                                  //| on(FMP), Person(FP), Person(MFP), Person(FFP))
	
	Person.persons foreach { p =>

		val eq = maternalGrandfather(p) == maternalGrandfatherNoFlatMap(p)
	  	assert(maternalGrandfather(p) == maternalGrandfatherNoFlatMap(p))
    
    println("name:" + p.name + " father:" + p.father + " mother:" + p.mother +
    "\nmaternalGrandfather:" + maternalGrandfather(p) +
    "\n")                                         //> name:P father:Just(Person(FP)) mother:Just(Person(MP))
                                                  //| maternalGrandfather:Just(Person(FMP))
                                                  //| 
                                                  //| name:MP father:Just(Person(FMP)) mother:Just(Person(MMP))
                                                  //| maternalGrandfather:MaybeNot
                                                  //| 
                                                  //| name:MMP father:MaybeNot mother:MaybeNot
                                                  //| maternalGrandfather:MaybeNot
                                                  //| 
                                                  //| name:FMP father:MaybeNot mother:MaybeNot
                                                  //| maternalGrandfather:MaybeNot
                                                  //| 
                                                  //| name:FP father:Just(Person(FFP)) mother:Just(Person(MFP))
                                                  //| maternalGrandfather:MaybeNot
                                                  //| 
                                                  //| name:MFP father:MaybeNot mother:MaybeNot
                                                  //| maternalGrandfather:MaybeNot
                                                  //| 
                                                  //| name:FFP father:MaybeNot mother:MaybeNot
                                                  //| maternalGrandfather:MaybeNot
                                                  //| 
	}
	'''                                       //> res1: Char('\'') = '
}