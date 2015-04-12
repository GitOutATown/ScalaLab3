package courses.coursera.bioinformatics1.ch1

import scala.collection.mutable.Map

object kmer_lab_2 {

	val text1 = "TheQuickBrownFoxJumpedOverTheLazyDog"
                                                  //> text1  : String = TheQuickBrownFoxJumpedOverTheLazyDog
	val text2 = "TheRainInSpainFallsMainlyOnThePlainOfTheCountryWhereTheyLive"
                                                  //> text2  : String = TheRainInSpainFallsMainlyOnThePlainOfTheCountryWhereTheyLi
                                                  //| ve
  val segmentsText2 = text2.toLowerCase.iterator.sliding(3)
                                                  //> segmentsText2  : Iterator[Char]#GroupedIterator[Char] = non-empty iterator
  
  //segmentsText2 map(s =>
  
  val list = List('t', 'h', 'e')                  //> list  : List[Char] = List(t, h, e)
  
  (list map(_.toString)).mkString                 //> res0: String = the
  
  val segText2StrIter = segmentsText2 map(s => s.flatMap(_.toString).mkString)
                                                  //> segText2StrIter  : Iterator[String] = non-empty iterator
  
  //segText2StrIter foreach println
  
  val kmerStoreSegText2 = Map.empty[String, Int]  //> kmerStoreSegText2  : scala.collection.mutable.Map[String,Int] = Map()
  
  
  segText2StrIter foreach(kmer =>
  		if(kmerStoreSegText2.contains(kmer)) {
  			//println("--> if kmer: " + kmer)
  			kmerStoreSegText2(kmer) += 1
  		}
  		else {
  			//println("else kmer: " + kmer)
  			kmerStoreSegText2.put(kmer, 1)
  		}
  )
  
  
  
  kmerStoreSegText2.size                          //> res1: Int = 51
  
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