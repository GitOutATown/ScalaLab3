package courses.langmead.tries

object Trie_lab_12 extends App {
    
    // Success
    // https://www.youtube.com/watch?v=hLsrPsFHPcQ
    
    val T = "abaaba"
    val T$ = T + "$"
    println("T$: " + T$ + "\n")
    
    val root = new Node('R')
    
    for{
        i <- 0 to T$.length() - 1
    } yield root.place(T$.substring(i).toList)
    
    case class Node(val nodeData: Char, var children: List[Node] = Nil) {
        def place(suf: List[Char]) {
            suf match {
                case Nil => // on to the next suffix
                case x :: xs => {
                    contains(children, x) match {
                        case Some(charNode) => charNode.place(xs)
                        case None => {
                            val charNode = Node(x)
                            children = charNode :: children
                            charNode.place(xs)
                        }
                    }
                }
            }
        } // end def place
        
        def contains(children: List[Node], ch: Char): Option[Node] = {
            val res = (for {
                node <- children
                if (node.nodeData == ch)
            } yield node).headOption
            res
        }
        
    } // end case class Node
    
    println("root: " + root)
    
}






