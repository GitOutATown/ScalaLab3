package courses.coursera.bioinformatics1.ch1

object kmer_lab_3 {

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
	}                                         //> highestFreqSeq: (text: String, k: Int)Map[String,Int]
	
	val text2 = "TheRainInSpainFallsMainlyOnThePlainOfTheCountryWhereTheyLive"
                                                  //> text2  : String = TheRainInSpainFallsMainlyOnThePlainOfTheCountryWhereTheyLi
                                                  //| ve
	highestFreqSeq(text2, 3)                  //> res0: Map[String,Int] = Map(ino -> 1, pai -> 1, try -> 1, nly -> 1, ret -> 1
                                                  //| , ini -> 1, all -> 1, inl -> 1, eth -> 1, oun -> 1, nof -> 1, yon -> 1, lyo 
                                                  //| -> 1, hep -> 1, ryw -> 1, ins -> 1, ntr -> 1, lsm -> 1, ain -> 4, epl -> 1, 
                                                  //| inf -> 1, liv -> 1, eyl -> 1, hec -> 1, nth -> 1, sma -> 1, whe -> 1, lls ->
                                                  //|  1, eco -> 1, fth -> 1, mai -> 1, pla -> 1, rai -> 1, era -> 1, cou -> 1, he
                                                  //| r -> 2, unt -> 1, spa -> 1, ere -> 1, lai -> 1, ywh -> 1, nin -> 1, fal -> 1
                                                  //| , nfa -> 1, yli -> 1, hey -> 1, ive -> 1, oft -> 1, ont -> 1, the -> 4, nsp 
                                                  //| -> 1)
}
/*
























*/