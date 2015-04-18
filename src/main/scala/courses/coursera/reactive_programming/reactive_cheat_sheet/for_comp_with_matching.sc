package courses.coursera.reactive_programming.reactive_cheat_sheet

object for_comp_with_matching {

	// https://class.coursera.org/reactive-002/wiki/ReactiveCheatSheet
	
	// for comprehension with pattern matching
	// withFilter
	for {
		x <- 1 to 10 withFilter {
		  case x if x % 2 == 0 => true
		  case _ => false
		} map {
		  case x if x > 4 => x * 2
		  case x => x - 1
		}
		if x > 4
	} yield x                                 //> res0: scala.collection.immutable.IndexedSeq[Int] = Vector(12, 16, 20)
}