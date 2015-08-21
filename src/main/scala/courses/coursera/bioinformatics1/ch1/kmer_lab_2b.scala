package courses.coursera.bioinformatics1.ch1

import courses.coursera.bioinformatics1.util.KmerUtils._

object kmer_lab_2b extends App {

    val text1 = "TheRainInSpainFallsMainlyOnThePlainOfTheCountryWhereTheyLive"
    val text2 = text1 + "d"
    
    // --------------------- //
    
    println("===> text1: " + kmerFormula(text1, 3))
  
    val segmentsText1 = text1.toLowerCase.iterator.sliding(3)
  
    val segText1StrIter = segmentsText1 map(s => s.flatMap(_.toString).mkString)
  
    segText1StrIter.zipWithIndex.foreach(println(_))
    
    // --------------------- //

    println("\n===> text2: " + kmerFormula(text2, 3))
  
    val segmentsText2 = text2.toLowerCase.iterator.sliding(3)
  
    val segText2StrIter = segmentsText2 map(s => s.flatMap(_.toString).mkString)
  
    segText2StrIter.zipWithIndex.foreach(println(_))

}