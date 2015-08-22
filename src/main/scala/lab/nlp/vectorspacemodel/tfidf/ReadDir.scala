package lab.nlp.vectorspacemodel.tfidf

import common.Path._
import scala.io.Source
import scala.collection.JavaConversions._

object ReadDir extends App {
    
    val resource_path = "src/main/scala/resources/"
    val corpusDir = root_path + resource_path + "shakespeare/"
    
    val corpus = new java.io.File(corpusDir).listFiles.filter(_.getName.endsWith(".txt"))
    
    for(file <- corpus if file.getName endsWith ".txt"){
        println(file.getName)
        Source.fromFile(file)
    }

}