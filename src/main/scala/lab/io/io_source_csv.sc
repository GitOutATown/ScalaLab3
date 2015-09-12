package lab.regex

import scala.util.matching.Regex
import scala.io.Source
import java.io.File
import common.Path._

object io_source_csv {

  // Documents location
  val resource_path = "src/main/scala/resources/edx_100_week3/"
                                                  //> resource_path  : String = src/main/scala/resources/edx_100_week3/
  val file = "Google_small.csv"                   //> file  : String = Google_small.csv
  
  val source = Source.fromFile(new File(root_path + resource_path + file), "ISO-8859-1")
                                                  //> source  : scala.io.BufferedSource = non-empty iterator
  val dataLines = source.getLines.drop(1).map(_.split(","))
                                                  //> dataLines  : Iterator[Array[String]] = non-empty iterator
  source.close // should be in finally

  val DATAFILE_PATTERN = """^(.+),"(.+)",(.*),(.*),(.*)""".r
                                                  //> DATAFILE_PATTERN  : scala.util.matching.Regex = ^(.+),"(.+)",(.*),(.*),(.*)
  dataLines.take(3).foreach(println)              //> [Ljava.lang.String;@fbfa8de
                                                  //| [Ljava.lang.String;@6fe78ee5
                                                  //| [Ljava.lang.String;@4b5695c8

  '''                                             //> res0: Char('\'') = '
}