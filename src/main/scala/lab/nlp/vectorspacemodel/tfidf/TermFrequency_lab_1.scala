package lab.nlp.vectorspacemodel.tfidf

import common.Path._
import scala.io.Source
import scala.collection.mutable.Map

object TermFrequency_lab_1 extends App {

    // ----- Get a document and parse it into terms -------- //
    
    val resource_path = "src/main/scala/resources/"
    val path = root_path + resource_path
    val doc = Source.fromFile(path + "shakespeare/Hamlet.txt")
    val stopwords = Source.fromFile(path + "stopwords.txt").getLines.toList
    val terms = doc.getLines.flatMap(preprocess(_))
        .filter(term => !stopwords.contains(term))
        
    // ----- Count term frequencies -------- //
    
    // Term lookup. Mutable (side effect). Re-implement in Spark for immutability and scalability.
    val termDict = Map.empty[String, Int]
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
    val maxFreq = (termDict.values.max).toFloat
    val freqs = termDict.map{
        case (term, count) => (term, count / maxFreq)
    }
    
    val freqsList = freqs.toList.sortBy(_._2).reverse
    
    freqsList.take(10).foreach(println)
    
    /* Without stopwords filtered:
    (the,1.0)
    (and,0.8469657)
    (to,0.6455585)
    (of,0.587511)
    (i,0.47405452)
    (you,0.469657)
    (a,0.46350044)
    (my,0.45118734)
    (hamlet,0.4010554)
    (in,0.38258576)
    */
    
    /* With stopwords filtered
    (hamlet,1.0)
    (lord,0.6096491)
    (,0.46052632)
    (king,0.41447368)
    (will,0.37061402)
    (horatio,0.34210527)
    (claudius,0.2609649)
    (shall,0.25)
    (queen,0.25)
    (polonius,0.24561404)
    */
    
    // ------ Methods ------------------- //
    
    def preprocess(str: String): Array[String] = {
      str.split("[ !,.:;]+").map(_.toLowerCase)
    }
}