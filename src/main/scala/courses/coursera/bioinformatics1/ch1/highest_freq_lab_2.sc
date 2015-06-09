package courses.coursera.bioinformatics1.ch1

import courses.coursera.bioinformatics1.ch1.KmerFrequency.highestFreqSeq

object highest_freq_lab_2 {

  val text1 = "aaaabbbbcccchhiijjklmaaaabbbbcccchhiijjklm".reverse +
    "aaaabbbbcccchhiijjklm".reverse               //> text1  : String = mlkjjiihhccccbbbbaaaamlkjjiihhccccbbbbaaaamlkjjiihhccccbbb
                                                  //| baaaa
    
  val text2 = text1 + "cccc"                      //> text2  : String = mlkjjiihhccccbbbbaaaamlkjjiihhccccbbbbaaaamlkjjiihhccccbbb
                                                  //| baaaacccc
  
  val k = 4                                       //> k  : Int = 4
  
  // ---- text1, k=4 --------------------- //
    
  highestFreqSeq(text1, k).head._1                //> res0: Int = 3
  val list = highestFreqSeq(text1, k).head._2.toList.sorted
                                                  //> list  : List[String] = List(AAAA, BAAA, BBAA, BBBA, BBBB, CBBB, CCBB, CCCB, 
                                                  //| CCCC, HCCC, HHCC, IHHC, IIHH, JIIH, JJII, KJJI, LKJJ, MLKJ)
  // ---- text2, k=4 ------------------- //
  highestFreqSeq(text2, k).head._1                //> res1: Int = 4
  val list2 = highestFreqSeq(text2, k).head._2.toList.sorted
                                                  //> list2  : List[String] = List(CCCC)
}
/*




*/