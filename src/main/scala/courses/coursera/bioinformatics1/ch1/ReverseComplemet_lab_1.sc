package courses.coursera.bioinformatics1.ch1

object ReverseComplemet_lab_1 {

	def revComp(str: String) = {
		val comps = str.map(ch => ch match {
			case 'A' => 'T'
			case 'T' => 'A'
			case 'C' => 'G'
			case 'G' => 'C'
		})
		comps.reverse
	}                                         //> revComp: (str: String)String
	
	revComp("CCAGATC")                        //> res0: String = GATCTGG
}