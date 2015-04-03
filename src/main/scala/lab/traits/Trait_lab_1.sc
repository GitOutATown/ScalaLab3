package lab.traits

import scala.collection.mutable.SortedSet

object Trait_lab_1 {

	trait TermCount {
		var termCount: Long
	}
	
	trait RankMetric {
		val rankMetric: Double // document frequency
	}
	
	case class Term(
		val term: String, // unique token (type, word)
		val allIncidences: Map[Long, Locations] // [docId, All incidences of term in multiple docs]
	)

	class Locations(
		val docId: Long,
		val term: String,
		val indexes: SortedSet[Int] // location of each instance of the term in this document
	)
	
	// --------------------------- //
	
	class IndexedLocations (
		docId: Long,
		term: String,
		indexes: SortedSet[Int],
		var termCount: Long
	) extends Locations (
		docId,
		term,
		indexes
	) with TermCount
	0                                         //> res0: Int(0) = 0
}