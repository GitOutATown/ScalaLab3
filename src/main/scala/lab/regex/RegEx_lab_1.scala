package lab.regex

import scala.util.matching.Regex

object RegEx_lab_1 extends App {
    
    val text1 = "Maybe it was the Buddha on the freeway."
    val text2 = "8/22/15"
    val text3 = "Email I just sent to Waseem and May"
    
    val datePattern = """^[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,4}""".r
    val maybe = "May".r
    
    val allText = List(text1, text2, text3)
    
    println(datePattern.findFirstIn(text2))
}