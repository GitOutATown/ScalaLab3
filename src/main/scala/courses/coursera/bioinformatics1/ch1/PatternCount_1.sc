package courses.coursera.bioinformatics1.ch1

object PatternCount_1 {

	def pattPos(pattern: String, str: String): List[Int] = {
	  // recursive search and accumulator
		def inter(index: Int, indices: List[Int]): List[Int] = {
			val found = str.indexOf(pattern, index) // index of pattern occurance
			if (found < 0) indices // none found, we're done
			else inter(found + 1, indices ++ List(found)) // search again starting one char after index of previous occurance
		}
		// start
		inter(0, List.empty[Int]) // index, accumulator
	}                                         //> pattPos: (pattern: String, str: String)List[Int]
	
	//val result = pattPos("ATAT", "GATATATGCATATACTT")
	//val result = pattPos("ACTAT", "ACAACTATGCATACTATCGGGAACTATCCT")
	val result = pattPos("GCG", "GCGCG")      //> result  : List[Int] = List(0, 2)
	result.length                             //> res0: Int = 2
	
}