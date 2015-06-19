package courses.coursera.bioinformatics1.ch1

import scala.io.Source
import courses.coursera.bioinformatics1.util.Paths._

object PatternCount2 extends App {

	//val docName = "data2.txt"
    val docName = "exercizeData1.txt"
	
	val source = Source.fromFile(path + docName)
	val text = source.getLines.mkString
	source.close // should be in finally
	
	def pattPos(pattern: String, str: String): List[Int] = {
        // (index, accumulator)
		def inter(index: Int, indices: List[Int]): List[Int] = {
			val found = str.indexOf(pattern, index)
			if (found < 0) indices // none found, we're done
			else inter(found + 1, indices :+ found)
		}
        // (index, accumulator)
		inter(0, List.empty[Int])
	}
	
	val pattern = "TGT"
	val result = pattPos(pattern , text)
	println("pattern locations: " + result)
	println("number of locations: " + result.length)
}







