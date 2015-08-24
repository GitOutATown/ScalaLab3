package lab.nlp.vectorspacemodel.tfidf.journal

object JournalParser_3 extends App {

  val text = List ("1/2/03", "Abc def.", "Ghi klm.", "Nop qrs.", "11/22/04", "Tuv wxy.", "Zhi ozh.", "14/30/06", "Foo bar.", "Too much.")
  val datePattern = """[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,4}""".r
  
  def isDate(line: String): Boolean = {
    datePattern.findPrefixMatchOf(line) match {
      case Some(_) => true
      case None => false
    }
  }
  
  def process(text: List[String]): List[List[String]] = {
    
    def inter(interText: List[String], acc1: List[String], acc2: List[List[String]]): List[List[String]] = {
      interText match {
        case Nil => acc2 :+ acc1
        case line :: tail => {
          if(isDate(line)) {
            val newAcc2 = if(acc1.isEmpty) acc2 else acc2 :+ acc1
            inter(tail, List(line), newAcc2)
          }
          else {
            val newAcc1 = acc1 :+ line
            inter(tail, newAcc1, acc2)
          }
        }
      }
    } // End inter
    
    inter(text, List[String](), List[List[String]]())
  } // End process

  val result = process(text)
  
  println(result)

}