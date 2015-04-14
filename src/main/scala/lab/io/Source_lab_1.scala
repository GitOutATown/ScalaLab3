package lab.io

import scala.io.Source

object Source_lab_1 extends App {
  
	val path = "/Users/hieronymus/Development/Workspace_BAK/ScalaLab3/src/main/data/"
	val docName = "Vibrio_cholerae.txt"
	
	val source = Source.fromFile(path + docName)
	val text = source.getLines.mkString
	source.close // should be in finally
	
	println(text)
}