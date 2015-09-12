package lab.regex

import scala.util.matching.Regex
import scala.io.Source
import java.io.File
import common.Path._

object Group_lab_2 extends App {

    // ------ Source/read file ------------ //
    // Documents location
    val resource_path = "src/main/scala/resources/edx_100_week3/"
    val file = "Google_small.csv"
    
    val source = Source.fromFile(new File(root_path + resource_path + file), "ISO-8859-1")
    val dataLines = source.getLines//.drop(1)

    //dataLines.take(3).foreach(line => println(line + "\n"))
    // ------ Parse lines ----------------- //
    
    val dataLinePattern = """^(.+),"(.+)",(.*),(.*),(.*)""".r
    
    dataLines.take(3).foreach(line => {
        println("-->datalines, line: " + line)
        line match {
            case dataLinePattern(grp1, grp2, grp3, grp4, grp5) => {
                println("grp1: " + grp1)
            }
            case _ => print("NOT MATCHING!")
        }
    })
    
    
    //dataLines.map(line -> dataLinePattern(grp1, grp2, grp3, grp4, grp5) = line)
    
    /*val groupedLines = for{
        dataLinePattern(grp1, grp2, grp3, grp4, grp5) <- dataLines
    }*/
    
    source.close // should be in finally

}