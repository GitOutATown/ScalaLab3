package lab.regex

object Impatient2 {

  val datePattern = """^[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,4}""".r
                                                  //> datePattern  : scala.util.matching.Regex = ^[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,4}
                                                  //| 
  val datePatternNoCaret = """[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,4}""".r
                                                  //> datePatternNoCaret  : scala.util.matching.Regex = [0-9]{1,2}/[0-9]{1,2}/[0-9
                                                  //| ]{1,4}
  
  val m1 = datePattern.findFirstIn("99 bottles, 98 bottles")
                                                  //> m1  : Option[String] = None
  val m2 = datePattern.findFirstIn("8/12/15")     //> m2  : Option[String] = Some(8/12/15)
  
  val m3 = datePattern.findFirstIn("18/12/15")    //> m3  : Option[String] = Some(18/12/15)
  
  val m4 = datePattern.findFirstIn("183/12/15")   //> m4  : Option[String] = None
  
  val m5 = datePattern.findFirstIn("first 18/12/15")
                                                  //> m5  : Option[String] = None
  
  val m6 = datePattern.findFirstIn("18/12/2015")  //> m6  : Option[String] = Some(18/12/2015)
  
  val m7 = datePattern.findFirstIn("18/12/2015 and then")
                                                  //> m7  : Option[String] = Some(18/12/2015)
  
  m7 match {
    case Some(d) => print(d)
    case None =>
  }                                               //> 18/12/2015
  
  val m8 = datePatternNoCaret.findFirstIn("first 18/12/15")
                                                  //> m8  : Option[String] = Some(18/12/15)
  
  val m9 = datePatternNoCaret.findPrefixOf("first 18/12/15")
                                                  //> m9  : Option[String] = None
  
  val m10 = datePattern.findPrefixOf("18/12/2015 and then")
                                                  //> m10  : Option[String] = Some(18/12/2015)
  
  val m11 = datePattern.findPrefixOf("3/5/14")    //> m11  : Option[String] = Some(3/5/14)
  
  

  '''                                             //> res0: Char('\'') = '
}