package courses.coursera.bioinformatics1.ch1

object TEST {

	def highestFreqSeq(text: String, k: Int) = {
		require(k < text.length)
		
		// prepare kmers
		val kSegments = text.toLowerCase.iterator.sliding(k).map(
			segment => segment.flatMap(_.toString).mkString
		).toList
		
		// Index kmers in Dictionary, recursive
		def indexKmers(
			kSegments: List[String], kmerStore: Map[String, Int]
		): Map[String, Int] = {
			kSegments match {
				case Nil => kmerStore
				case kmer :: tail => {
					if(kmerStore.contains(kmer)) {
			  			indexKmers(kSegments.tail, kmerStore + (kmer -> (kmerStore(kmer) + 1)))
			  		}
			  		else {
			  			indexKmers(kSegments.tail, kmerStore + (kmer -> 1))
			  		}
		  		} // end case kmer :: tail
	  		} // end kSegments match
		} // end indexKmers
		// Start
		indexKmers(kSegments, Map.empty[String, Int])
	} // end highestFreqSeq
} // end object kmer_lab_3
/*
























*/