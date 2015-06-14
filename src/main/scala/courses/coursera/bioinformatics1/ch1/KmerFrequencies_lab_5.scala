package courses.coursera.bioinformatics1.ch1

import scala.io.Source
import courses.coursera.bioinformatics1.util.Paths._
import courses.coursera.bioinformatics1.ch1.KmerFrequency.highestFreqSeq

object KmerFrequencies_lab_5 extends App {
    
    println("START")

    val docName = "Vibrio_cholerae.txt"
    
    val source = Source.fromFile(path + docName)
    val text = source.getLines.mkString
    source.close // should be in finally
    
    val freqMaps = for{
        k <- 13 to 20 //////// WARNING: slow...! ///////
    } yield (highestFreqSeq(text, k))
    
    freqMaps.foreach(kmer => println(kmer.head._1)) 
    
    println("END")
    
}

// (3 to 12): START, 31901, 10206, 3193, 866, 326, 183, 128, 119, 112, 112, END
// (13 to 20): START, 112, 111, 110, 106, 106, 105, 104, 103, END