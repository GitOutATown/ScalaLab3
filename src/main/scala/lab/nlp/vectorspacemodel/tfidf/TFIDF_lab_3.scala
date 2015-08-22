package lab.nlp.vectorspacemodel.tfidf

import common.Path._
import scala.io.Source
import scala.collection.mutable.Map
import java.io.File
import math._

object TFIDF_lab_3 extends App {

    // ----- Get documents and parse them into terms -------- //
    
    val resource_path = "src/main/scala/resources/"
    val path = root_path + resource_path
    val corpusDir = path + "shakespeare/"
    val stopwords = Source.fromFile(path + "stopwords.txt").getLines.toList
    
    val corpus = new File(corpusDir).listFiles
        .filter(_.getName.endsWith(".txt"))
        
    val docsPerTerm = Map.empty[String, Int]
    
    val termDocMaps = for(file <- corpus) yield mapTerms(file)
    
    val tfCounts = termDocMaps.map{
        case (title, termMap) => {
            termMap.foreach{
                // Side effects!
                case (term, _) => docsPerTerm.get(term) match {
                    case Some(_) => docsPerTerm(term) += 1
                    case None => docsPerTerm(term) = 1
                }
            }
        }
        
        // counts, frequency ratio, normalized
        val maxFreq = (termMap.values.max).toFloat
        val freqs = termMap.map{
            case (term, count) => (term, count / maxFreq)
        }
        val freqsList = freqs.toList.sortBy(_._2).reverse
        (title, freqsList)
    } // END termDocMaps.map
                
    def mapTerms(file: File) = {
        val doc = Source.fromFile(file)
        val terms = doc.getLines.flatMap(preprocess(_))
            .filter(term => !stopwords.contains(term) && term != "")
            
        // Term lookup. Mutable (side effect). Re-implement in Spark for immutability and scalability.
        val termCounts = Map.empty[String, Int] // not parallelizable
        terms.foreach {
            term => termCounts.get(term) match {
                case Some(count) => termCounts(term) += 1
                case None => termCounts(term) = 1
            }
        }
        
        (file.getName, termCounts)
    } // end countTF
    
    def preprocess(str: String): Array[String] = {
        val splits = str.split("[ !,.:;]+").map(_.toLowerCase)
        splits.map { s => s.replaceAll("(?m)^[ \t]*\r?\n", "") }
    }
    
    /*tfCounts foreach {
        tf => {
            println(tf._1);
            println(tf._2.take(20))
            println
        }
    }*/
    
    // https://groups.google.com/forum/#!topic/scala-language/K5tbYSYqQc8
    def log2(x: Double) = scala.math.log(x)/scala.math.log(2)
    
    val allTFIDFs = tfCounts.map{
        case (title, terms) => {
            val tfidfs = terms.map{
                case (term, tf) => {
                    val idf = log2(docsPerTerm.size.toFloat / docsPerTerm(term))
                    (term, tf * idf)
                }
            }
            (title, tfidfs)
        }
    } // end allTFIDFs
    
    allTFIDFs foreach {
        doc => {
            println(doc._1)
            println(doc._2.take(10))
            println()
        }
    }
}

