package courses.coursera.reactive_programming.reactive_cheat_sheet

object for_comp_with_matching {

	// https://class.coursera.org/reactive-002/wiki/ReactiveCheatSheet
	// for comprehension with pattern matching
	for {
		x <- 5 to 10 withFilter {
		  case x if x % 2 == 0 => true
		  case _ => false
		} map {
		  case x if x > 2 => x
		}
	} yield x                                 //> res0: scala.collection.immutable.IndexedSeq[Int] = Vector(6, 8, 10)
}