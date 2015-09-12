package lab.regex

import scala.util.matching.Regex
import scala.io.Source
import java.io.File
import common.Path._

object group_lab_1 {

  // ------ Source/read file ------------ //
  // Documents location
  val resource_path = "src/main/scala/resources/edx_100_week3/"
                                                  //> resource_path  : String = src/main/scala/resources/edx_100_week3/
  val file = "Google_small.csv"                   //> file  : String = Google_small.csv
  
  val source = Source.fromFile(new File(root_path + resource_path + file), "ISO-8859-1")
                                                  //> source  : scala.io.BufferedSource = non-empty iterator
  val dataLines = source.getLines                 //> dataLines  : Iterator[String] = non-empty iterator

  dataLines.take(3).foreach(line => println(line + "\n"))
                                                  //> "id","name","description","manufacturer","price"
                                                  //| 
                                                  //| "http://www.google.com/base/feeds/snippets/11448761432933644608","spanish vo
                                                  //| cabulary builder","expand your vocabulary! contains fun lessons that both te
                                                  //| ach and entertain you'll quickly find yourself mastering new terms. includes
                                                  //|  games and more!",,6.95
                                                  //| 
                                                  //| "http://www.google.com/base/feeds/snippets/8175198959985911471","topics pres
                                                  //| ents: museums of world","5 cd-rom set. step behind the velvet rope to examin
                                                  //| e some of the most treasured collections of antiquities art and inventions. 
                                                  //| includes the following the louvre - virtual visit 25 rooms in full screen in
                                                  //| teractive video detailed map of the louvre ...",,12.9
                                                  //| 
  // ------ Parse lines ----------------- //
  
  val dataLinePattern = """^(.+),"(.+)",(.*),(.*),(.*)""".r
                                                  //> dataLinePattern  : scala.util.matching.Regex = ^(.+),"(.+)",(.*),(.*),(.*)
  
  val foo = dataLines.take(3).map(line => line match {
	    case dataLinePattern(grp1, grp2, grp3, grp4, grp5) => grp1
  })                                              //> foo  : Iterator[String] = non-empty iterator
  
  foo foreach println                             //> "http://www.google.com/base/feeds/snippets/18445827127704822533"
                                                  //| "http://www.google.com/base/feeds/snippets/18274317756231697680"
                                                  //| "http://www.google.com/base/feeds/snippets/18409551702230917208"
  
  
  source.close // should be in finally
  '''                                             //> res0: Char('\'') = '
}