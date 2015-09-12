package lab.regex

import scala.util.matching.Regex
import scala.io.Source
import java.io.File
import common.Path._

object group_lab_3 {

  // ------ Source/read file ------------ //
  // Documents location
  val resource_path = "src/main/scala/resources/edx_100_week3/"
                                                  //> resource_path  : String = src/main/scala/resources/edx_100_week3/
  val file = "Google_small.csv"                   //> file  : String = Google_small.csv
  
  val source = Source.fromFile(new File(root_path + resource_path + file), "ISO-8859-1")
                                                  //> source  : scala.io.BufferedSource = non-empty iterator
  val dataLines = source.getLines                 //> dataLines  : Iterator[String] = non-empty iterator

  //dataLines.take(3).foreach(line => println(line + "\n"))
  // ------ Parse lines ----------------- //
  
  val dataLinePattern = """^(.+),"(.+)",(.*),(.*),(.*)""".r
                                                  //> dataLinePattern  : scala.util.matching.Regex = ^(.+),"(.+)",(.*),(.*),(.*)
  /*
  val foo = dataLines.take(3).map(line => line match {
      case dataLinePattern(grp1, grp2, grp3, grp4, grp5) => grp1
  })
  */
  
  val foo = for{
    dataLinePattern(grp1, grp2, grp3, grp4, grp5) <- dataLines
  } yield grp1                                    //> foo  : Iterator[String] = non-empty iterator
  
  foo.take(3) foreach println                     //> "id"
                                                  //| "http://www.google.com/base/feeds/snippets/11448761432933644608"
                                                  //| "http://www.google.com/base/feeds/snippets/8175198959985911471"
  
  source.close // should be in finally
  '''                                             //> res0: Char('\'') = '
}