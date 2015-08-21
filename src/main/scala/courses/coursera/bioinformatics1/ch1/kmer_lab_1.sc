package courses.coursera.bioinformatics1.ch1

import courses.coursera.bioinformatics1.util.KmerUtils._

object kmer_lab_1 {

	// There are |Text| - k + 1 k-mers in Text.
	// where |Text| denotes the length of Text.
	// kmer is a sliding window.
	// The "times" and "leftover" (below) don't matter because
	// the kmers are not fitting end to end, but rather slide
	// along the text in one character position increments.

	val text1 = "TheQuickBrownFoxJumpedOverTheLazyDog"
                                                  //> text1  : String = TheQuickBrownFoxJumpedOverTheLazyDog
	text1.length                              //> res0: Int = 36
	
	val result = for(
		k <- 1 to text1.length
	) yield 	kmerFormula(text1, k)     //> result  : scala.collection.immutable.IndexedSeq[(String, String, String, Str
                                                  //| ing)] = Vector((k:1,times:36,leftover:0,formula:36), (k:2,times:18,leftover:
                                                  //| 0,formula:35), (k:3,times:12,leftover:0,formula:34), (k:4,times:9,leftover:0
                                                  //| ,formula:33), (k:5,times:7,leftover:1,formula:32), (k:6,times:6,leftover:0,f
                                                  //| ormula:31), (k:7,times:5,leftover:1,formula:30), (k:8,times:4,leftover:4,for
                                                  //| mula:29), (k:9,times:4,leftover:0,formula:28), (k:10,times:3,leftover:6,form
                                                  //| ula:27), (k:11,times:3,leftover:3,formula:26), (k:12,times:3,leftover:0,form
                                                  //| ula:25), (k:13,times:2,leftover:10,formula:24), (k:14,times:2,leftover:8,for
                                                  //| mula:23), (k:15,times:2,leftover:6,formula:22), (k:16,times:2,leftover:4,for
                                                  //| mula:21), (k:17,times:2,leftover:2,formula:20), (k:18,times:2,leftover:0,for
                                                  //| mula:19), (k:19,times:1,leftover:17,formula:18), (k:20,times:1,leftover:16,f
                                                  //| ormula:17), (k:21,times:1,leftover:15,formula:16), (k:22,times:1,leftover:14
                                                  //| ,formula:15), (k:23,time
                                                  //| Output exceeds cutoff limit.
	
	result foreach println                    //> (k:1,times:36,leftover:0,formula:36)
                                                  //| (k:2,times:18,leftover:0,formula:35)
                                                  //| (k:3,times:12,leftover:0,formula:34)
                                                  //| (k:4,times:9,leftover:0,formula:33)
                                                  //| (k:5,times:7,leftover:1,formula:32)
                                                  //| (k:6,times:6,leftover:0,formula:31)
                                                  //| (k:7,times:5,leftover:1,formula:30)
                                                  //| (k:8,times:4,leftover:4,formula:29)
                                                  //| (k:9,times:4,leftover:0,formula:28)
                                                  //| (k:10,times:3,leftover:6,formula:27)
                                                  //| (k:11,times:3,leftover:3,formula:26)
                                                  //| (k:12,times:3,leftover:0,formula:25)
                                                  //| (k:13,times:2,leftover:10,formula:24)
                                                  //| (k:14,times:2,leftover:8,formula:23)
                                                  //| (k:15,times:2,leftover:6,formula:22)
                                                  //| (k:16,times:2,leftover:4,formula:21)
                                                  //| (k:17,times:2,leftover:2,formula:20)
                                                  //| (k:18,times:2,leftover:0,formula:19)
                                                  //| (k:19,times:1,leftover:17,formula:18)
                                                  //| (k:20,times:1,leftover:16,formula:17)
                                                  //| (k:21,times:1,leftover:15,formula:16)
                                                  //| (k:22,times:1,leftover:14,formula:15)
                                                  //| (k:23,times:1,leftover:13,formula:14)
                                                  //| (k:24,times:1,leftover:12,formula:13)
                                                  //| (k:25,times
                                                  //| Output exceeds cutoff limit.
	
}
/*



*/