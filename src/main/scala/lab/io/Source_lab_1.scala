package lab.io

import common.Path.root_path
import scala.io.Source

object Source_lab_1 extends App {
  
    val path = "src/main/data/"
	val docName = "Vibrio_cholerae.txt"
	
	val source = Source.fromFile(root_path + path + docName)
	val text = source.getLines.mkString
	source.close // should be in finally
	
	println(text)
}