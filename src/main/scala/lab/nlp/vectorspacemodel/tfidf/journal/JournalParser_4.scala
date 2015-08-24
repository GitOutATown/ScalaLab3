package lab.nlp.vectorspacemodel.tfidf.journal

object JournalParser_4 {
    
    val datePattern = """[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,4}""".r
    
    def isDate(line: String): Boolean = {
        //println("def isDate, line: " + line)
        //println("def isDate, datePattern: " + datePattern)
        datePattern.findPrefixMatchOf(line) match {
            case Some(_) => true
            case None => false
        }
    }
    
    def process(text: List[String]): List[Document] = {
        
        def inter(interText: List[String], journal: List[Document], entry: Document = null): List[Document] = {
            interText match {
                case Nil => journal :+ entry
                case line :: tail => {
                    if(isDate(line)) {
                        val title = line
                        val iterJournal = if(entry == null) journal else journal :+ entry
                        inter(tail, iterJournal, Document(title, List[String]()))
                    }
                    else {
                        val iterEntry = Document(entry.title, entry.text :+ line)
                        inter(tail, journal, iterEntry)
                    }
                }
            }
        } // End inter
        
        inter(text, List[Document]())
    } // End process
}