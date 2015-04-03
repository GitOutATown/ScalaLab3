package lab.properties

import scala.collection.mutable.Map

object MapProperties_lab_1 {
	
	class Term(private var _allIncidences: Map[Int, String]) {
		def allIncidences = _allIncidences.values
		def incidence(k:Int, v:String) {
			_allIncidences += (k -> v)
		}
		def incidence(k:Int): Option[String] = {
			_allIncidences.get(k)
		}
	}
	
	val term1 = new Term( Map(3 -> "three", 4 -> "four") )
                                                  //> term1  : lab.properties.MapProperties_lab_1.Term = lab.properties.MapPropert
                                                  //| ies_lab_1$Term@63560d4c
  term1.allIncidences                             //> res0: Iterable[String] = HashMap(four, three)
  term1.incidence(3)                              //> res1: Option[String] = Some(three)
  term1.incidence(6, "six")
  term1.allIncidences                             //> res2: Iterable[String] = HashMap(four, three, six)
	term1.incidence(6)                        //> res3: Option[String] = Some(six)
	
}