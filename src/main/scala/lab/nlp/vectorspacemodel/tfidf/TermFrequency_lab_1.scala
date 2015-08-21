package lab.nlp.vectorspacemodel.tfidf

import common.Path._
import scala.io.Source

object TermFrequency_lab_1 extends App {

    // Let's get a document and parse it into terms.
    // Document path
    val doc_path = "src/main/scala/data/shakespeare/"
    val path = root_path + doc_path
    val doc = Source.fromFile(path + "Hamlet.txt")
}