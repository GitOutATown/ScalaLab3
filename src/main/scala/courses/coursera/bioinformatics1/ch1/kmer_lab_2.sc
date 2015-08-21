package courses.coursera.bioinformatics1.ch1

import scala.collection.mutable.Map
import courses.coursera.bioinformatics1.util.KmerUtils._

object kmer_lab_2 {

	val text1 = "TheQuickBrownFoxJumpedOverTheLazyDog"
                                                  //> text1  : String = TheQuickBrownFoxJumpedOverTheLazyDog
	val text2 = "TheRainInSpainFallsMainlyOnThePlainOfTheCountryWhereTheyLived"
                                                  //> text2  : String = TheRainInSpainFallsMainlyOnThePlainOfTheCountryWhereTheyLi
                                                  //| ved
  kmerFormula(text2, 3)                           //> res0: (String, String, String, String) = (k:3,times:20,leftover:1,formula:59
                                                  //| )
  
  val segmentsText2 = text2.toLowerCase.iterator.sliding(3)
                                                  //> segmentsText2  : Iterator[Char]#GroupedIterator[Char] = non-empty iterator
  // val copyOfST2 = segmentsText2
  // segmentsText2.length // Int = 58 // .length, and any operation that causes iteration empties the iterator.
  // copyOfST2 // pointer to segmentsText2, so an iteration on segmentsText2 results in copyOfST2 to also point to an empty iterator.
  // segmentsText2 // empty iterator
  // segmentsText2 foreach println // List[(char, char, char)] eg. List(t, h, e)
    
  val example = List('t', 'h', 'e')               //> example  : List[Char] = List(t, h, e)
  
  (example map(_.toString)).mkString              //> res1: String = the
  
  val segText2StrIter = segmentsText2 map(s => s.flatMap(_.toString).mkString)
                                                  //> segText2StrIter  : Iterator[String] = non-empty iterator
  
  // segText2StrIter foreach println // List[String] eg. List("the", "her", "era", "rai", ...)
  
  // mutable
  val kmerStoreSegText2 = Map.empty[String, Int]  //> kmerStoreSegText2  : scala.collection.mutable.Map[String,Int] = Map()
  
  
  segText2StrIter foreach(kmer =>
  		if(kmerStoreSegText2.contains(kmer)) {
  			//println("--> if kmer: " + kmer)
  			kmerStoreSegText2(kmer) += 1 // mutable
  		}
  		else {
  			//println("else kmer: " + kmer)
  			kmerStoreSegText2.put(kmer, 1)
  		}
  )
  
  
  
  kmerStoreSegText2.size                          //> res2: Int = 52
  
  var highestFreq: List[(String, Int)] = List(("", 0))
                                                  //> highestFreq  : List[(String, Int)] = List(("",0))
  
	kmerStoreSegText2.foreach{ kFreq =>
		highestFreq.foreach{ soFar =>
			if(kFreq._2 > soFar._2) {
				highestFreq = List(kFreq)
			}
			else if(kFreq._2 == soFar._2) {
				highestFreq = kFreq :: highestFreq
			}
		}
	}
	
	highestFreq foreach println               //> (ain,4)
                                                  //| (the,4)
  
  
}
/*



*/