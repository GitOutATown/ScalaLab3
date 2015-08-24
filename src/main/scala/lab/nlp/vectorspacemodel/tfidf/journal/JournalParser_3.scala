package lab.nlp.vectorspacemodel.tfidf.journal

object JournalParser_3 extends App {
    
    case class JournalEntry(date: String, text: List[String])

    val text = List ("1/2/03", "Abc def.", "Ghi klm.", "Nop qrs.", "11/22/04", "Tuv wxy.", "Zhi ozh.", "14/30/06", "Foo bar.", "Too much.")
    val datePattern = """[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,4}""".r
    
    def isDate(line: String): Boolean = {
        datePattern.findPrefixMatchOf(line) match {
            case Some(_) => true
            case None => false
        }
    }
    
    def process(text: List[String]): List[JournalEntry] = {
        
        def inter(interText: List[String], journal: List[JournalEntry], entry: JournalEntry = null): List[JournalEntry] = {
            interText match {
                case Nil => journal :+ entry
                case line :: tail => {
                    if(isDate(line)) {
                        val date = line
                        val iterJournal = if(entry == null) journal else journal :+ entry
                        inter(tail, iterJournal, JournalEntry(date, List[String]()))
                    }
                    else {
                        val iterEntry = JournalEntry(entry.date, entry.text :+ line)
                        inter(tail, journal, iterEntry)
                    }
                }
            }
        } // End inter
        
        inter(text, List[JournalEntry]())
    } // End process

    val result = process(text)
    
    println(result)

}