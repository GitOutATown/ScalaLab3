package lab.monad

import lab.monad.Grandfathers._
import lab.monad.Person._

object Person_test_1 {
	
	persons                                   //> res0: List[lab.monad.Person] = List(Person(P), Person(MP), Person(MMP), Pers
                                                  //| on(FMP), Person(FP), Person(MFP), Person(FFP))
	
	Person.persons foreach { p =>

		val eq = maternalGrandfather(p) == maternalGrandfatherNoFlatMap(p)
	  	assert(maternalGrandfather(p) == maternalGrandfatherNoFlatMap(p))
    
    println("name :" + p.name + " father :" + p.father + " mother :" + p.mother +
    "\nmaternal grandfather :" + maternalGrandfather(p) +
    "\nboth grandfathers: " + bothGrandfathersFlatMap(p) +
    "\n")                                         //> name :P father :Just(Person(FP)) mother :Just(Person(MP))
                                                  //| maternal grandfather :Just(Person(FMP))
                                                  //| both grandfathers: Just((Person(FMP),Person(FFP)))
                                                  //| 
                                                  //| name :MP father :Just(Person(FMP)) mother :Just(Person(MMP))
                                                  //| maternal grandfather :MaybeNot
                                                  //| both grandfathers: MaybeNot
                                                  //| 
                                                  //| name :MMP father :MaybeNot mother :MaybeNot
                                                  //| maternal grandfather :MaybeNot
                                                  //| both grandfathers: MaybeNot
                                                  //| 
                                                  //| name :FMP father :MaybeNot mother :MaybeNot
                                                  //| maternal grandfather :MaybeNot
                                                  //| both grandfathers: MaybeNot
                                                  //| 
                                                  //| name :FP father :Just(Person(FFP)) mother :Just(Person(MFP))
                                                  //| maternal grandfather :MaybeNot
                                                  //| both grandfathers: MaybeNot
                                                  //| 
                                                  //| name :MFP father :MaybeNot mother :MaybeNot
                                                  //| maternal grandfather :MaybeNot
                                                  //| both grandfathers: MaybeNot
                                                  //| 
                                                  //| name :FFP father :MaybeNot mother :MaybeNot
                                                  //| maternal grandfather :MaybeNot
                                                  //| both grandfathers: MaybeNot
                                                  //| 
	}
	'''                                       //> res1: Char('\'') = '
}