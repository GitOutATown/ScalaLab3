package courses.coursera.bioinformatics1.ch1

import scala.io.Source
import courses.coursera.bioinformatics1.ch1.KmerFrequency.highestFreqSeq
import courses.coursera.bioinformatics1.util.Paths._

object HighestFreq_io {
	
	//val docName = "data2.txt"
	//val docName = "Vibrio_cholerae.txt"
	val docName = "exercizeData1.txt"         //> docName  : String = exercizeData1.txt
	
	val source = Source.fromFile(path + docName)
                                                  //> source  : scala.io.BufferedSource = non-empty iterator
	val text = source.getLines.mkString       //> text  : String = CACTAGCATACTCCCACTAGCAGTTCCAGAGTTCCAGTTAGTGAAGTTCCAGATACTCC
                                                  //| AGTTCCAGAGTTCCAGTTAGTGAATACTCCCACTAGCAGTTCCAGAGTTCCAGTTAGTGACAATTGCTCAATTGCT
                                                  //| ATACTCCCAATTGCTATACTCCAGTTCCAGTTAGTGAAGTTCCAGCACTAGCATACTCCTTAGTGACAATTGCTAT
                                                  //| ACTCCCAATTGCTCACTAGCAGTTCCAGATACTCCTTAGTGAAGTTCCAGAGTTCCAGTTAGTGACAATTGCTCAA
                                                  //| TTGCTATACTCCAGTTCCAGTTAGTGAATACTCCATACTCCAGTTCCAGAGTTCCAGTTAGTGAAGTTCCAGCAAT
                                                  //| TGCTCAATTGCTCAATTGCTTTAGTGAATACTCCAGTTCCAGATACTCCCAATTGCTCACTAGCTTAGTGATTAGT
                                                  //| GATTAGTGATTAGTGAAGTTCCAGAGTTCCAGCACTAGCCACTAGCATACTCCATACTCCTTAGTGAAGTTCCAGA
                                                  //| GTTCCAGATACTCCTTAGTGACAATTGCTATACTCCATACTCCTTAGTGAAGTTCCAGCACTAGCCAATTGCTATA
                                                  //| CTCCCAATTGCTATACTCCATACTCCTTAGTGAATACTCCCACTAGCATACTCCCAATTGCTAGTTCCAGTTAGTG
                                                  //| ACAATTGCTCAATTGCTATACTCCATACTCCCACTAGCCACTAGCAGTTCCAGATACTCCCACTAGCCACTAGCAT
                                                  //| ACTCCCAATTGCTTTAGTGAAGTTCCAGATACTCCTTAGTGAATACTCCCAATTGCTCACTAGCAGTTCCAGCACT
                                                  //| AGCATACTCCATACTCCAGTTCCAGCACTAGCCACTAGCAGTTCCAG
	source.close
	//val k = 11
	val k = 14                                //> k  : Int = 14
	highestFreqSeq(text, k).head._1           //> res0: Int = 8
	highestFreqSeq(text, k).head._2.mkString(" ")
                                                  //> res1: String = TTAGTGAAGTTCCA AATTGCTATACTCC AGTTCCAGTTAGTG CAATTGCTATACTC G
                                                  //| TTCCAGTTAGTGA TAGTGAAGTTCCAG
}
/*




*/