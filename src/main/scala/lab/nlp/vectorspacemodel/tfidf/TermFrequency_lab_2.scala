package lab.nlp.vectorspacemodel.tfidf

import common.Path._
import scala.io.Source
import scala.collection.mutable.Map
import java.io.File

object TermFrequency_lab_2 extends App {

    // ----- Get documents and parse them into terms -------- //
    
    val resource_path = "src/main/scala/resources/"
    val path = root_path + resource_path
    val corpusDir = path + "shakespeare/"
    val stopwords = Source.fromFile(path + "stopwords.txt").getLines.toList
    
    val corpus = new File(corpusDir).listFiles
        .filter(_.getName.endsWith(".txt"))
    
    val tfCounts = for(file <- corpus) yield countTF(file)
    
    def countTF(file: File) = {
        //println(file.getName)
        val doc = Source.fromFile(file)
        val terms = doc.getLines.flatMap(preprocess(_))
            .filter(term => !stopwords.contains(term) && term != "")
            
        // Term lookup. Mutable (side effect). Re-implement in Spark for immutability and scalability.
        val termDict = Map.empty[String, Int] // not parallelizable
        terms.foreach {
            term => termDict.get(term) match {
                case Some(count) => {
                    termDict(term) += 1
                }
                case None => {
                    termDict(term) = 1
                }
            }
        }
        
        // counts, frequency ratio, normalized
        val maxFreq = (termDict.values.max).toFloat
        val freqs = termDict.map{
            case (term, count) => (term, count / maxFreq)
        }
        val freqsList = freqs.toList.sortBy(_._2).reverse
        (file.getName, freqsList)
    } // end countTF
    
    def preprocess(str: String): Array[String] = {
        val splits = str.split("[ !,.:;]+").map(_.toLowerCase)
        splits.map { s => s.replaceAll("(?m)^[ \t]*\r?\n", "") }
    }
    
    // The result
    tfCounts foreach {
        tf => {
            println(tf._1);
            println(tf._2.take(20))
            println
        }
    }
}

