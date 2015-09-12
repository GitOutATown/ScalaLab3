package lab.nlp.vectorspacemodel.tfidf

import common.Path._
import java.io.File
import scala.io.Source

import lab.nlp.vectorspacemodel.tfidf.TfIdfService_5._

object TfIdfClient_5 extends App {
    
    // Documents location
    val resource_path = "src/main/scala/resources/"
    val path = root_path + resource_path
    val corpusDir = path + "shakespeare/"
    
    // Used for filtering out unimportant terms
    val stopwords = Source.fromFile(path + "stopwords.txt").getLines.toList
        .filter(w => w != "")
    
    // Load all txt files in corpus directory
    val corpus = new File(corpusDir).listFiles.filter(_.getName.endsWith(".txt"))     
    
    val allTFIDFs = tfidf(corpus, stopwords)
    
    // Display output of all TFIDF scores per doc
    allTFIDFs foreach {
        doc => {
            println(doc._1)
            println(doc._2.take(10))
            println()
        }
    }
}




