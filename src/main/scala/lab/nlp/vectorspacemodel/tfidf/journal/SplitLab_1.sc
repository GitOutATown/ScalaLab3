package lab.nlp.vectorspacemodel.tfidf.journal

/*
 * THIS VERSION IS NOT WORKING CORRECTLY YET
 */
object SplitLab_1 {

  val text = List ("1/2/03", "Abc def.", "Ghi klm.", "Nop qrs.", "11/22/04", "Tuv wxy.", "Zhi ozh.", "14/30/06", "Foo bar.", "Too much.")
                                                  //> text  : List[String] = List(1/2/03, Abc def., Ghi klm., Nop qrs., 11/22/04, 
                                                  //| Tuv wxy., Zhi ozh., 14/30/06, Foo bar., Too much.)
  val datePattern = """[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,4}""".r
                                                  //> datePattern  : scala.util.matching.Regex = [0-9]{1,2}/[0-9]{1,2}/[0-9]{1,4}
  
  def isNewEntry(line: String): Boolean = {
    datePattern.findPrefixMatchOf(line) match {
      case Some(_) => {
        //println("-->NEW ENTRY: " + line)
        true
      }
      case None => false
    }
  }                                               //> isNewEntry: (line: String)Boolean
  
  def process(text: List[String]): List[List[String]] = {
    //println("==>STARTING")
    
    def inter(interText: List[String], acc1: List[String], acc2: List[List[String]]): List[List[String]] = {
      //println("-->ACCUM: " + acc1)
      interText match {
        case Nil => acc2
        case line :: tail => {
          if(isNewEntry(line)) {
            val newAcc2 = acc1 :: acc2
            //println("-->newAcc2 at new Entry: " + newAcc2)
            inter(tail, List(line), newAcc2)
          }
          else {
            val newAcc1 = line :: acc1
            //println("-->newAcc1: " + newAcc1)
            inter(tail, newAcc1, acc2)
          }
        }
      }
    }
    
    inter(text, List[String](), List[List[String]]())
  }                                               //> process: (text: List[String])List[List[String]]

  process(text)                                   //> res0: List[List[String]] = List(List(Zhi ozh., Tuv wxy., 11/22/04), List(No
                                                  //| p qrs., Ghi klm., Abc def., 1/2/03), List())

}