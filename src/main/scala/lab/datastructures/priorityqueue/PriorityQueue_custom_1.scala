package lab.datastructures.priorityqueue

object PriorityQueue_custom_1 {
    // http://amitdev.github.io/coding/2014/03/06/Priority-Queue/
    
    abstract class PriorityQueue[A](implicit val ord: Ordering[A]) {
        // Add an item
        def +(x: A): PriorityQueue[A]
      
        // Find min item
        def findMin: A
      
        // New Priority queue with min item deleted
        def deleteMin: PriorityQueue[A]
      
        // Merges two PriorityQueue together
        def meld(that: PriorityQueue[A]): PriorityQueue[A]
    } // end PriorityQueue
    
    case class Node[A](data: A, rank: Int = 0, children: List[Node[A]] = Nil)
                      (implicit val ord: Ordering[A]) extends Ordered[Node[A]] {
                                    
        /* Combines two Nodes of same rank (i.e. size, number of immediate children) making the root the one with lesser value.
         * If this.data  < other.data then produce a new Node with  this.data and increment its rank and add other to     its list of children.
         * If this.data !< other.data then produce a new Node with other.data and increment its rank and add this  to other's list of children.
         * Linking (represented graphically with edges between node vertices?) seems to just be represented by a list cons.
         * "link method...links two Node[s] together keeping the min element as new root."*/
        def link(other: Node[A]) = {
            if (ord.compare(data, other.data) < 0) Node(data, rank+1, other :: children)
            else Node(other.data, other.rank+1, this :: other.children)
        }
    
        override def compare(that: Node[A]): Int = ord.compare(data, that.data)
    } // end Node
    
    private final case class BinomialQueue[A] 
        (nodes: List[Node[A]]) (implicit override val ord: Ordering[A])
        extends PriorityQueue[A] {
                                                                
        def +(x: A): BinomialQueue[A] = BinomialQueue(insertNode(Node(x), nodes))
        
        private def insertNode[T](n: Node[T], list: List[Node[T]]): List[Node[T]] = list match {
            case Nil => List(n)
            case x :: xs => {
                /* Here is the recursive magic sauce!
                 * But here's an important question I don't yet understand the the answer to:
                 * What is the effectual difference between comparison of rank and comparison of data value??
                 * Ok, I've figured something out!: The list can hold multiple trees! The diagram illustrating
                 * node insertion (def +) shows lists as dashed boxes with disjoint trees. I still need to
                 * discover how/why/when trees are melded. Also, linking is not the same as being in the list.
                 * Let's see, I think the PriorityQueue represents the superset of all trees. Trees have rank
                 * and are structured around minimum node. But this is still fuzzy to me...
                 * Using amitdev's graphical tool would help to gain further insight! */
                if (n.rank < x.rank) n :: x :: xs // easy ordering
                else insertNode(x.link(n), xs) // needs more extensive (recursive) shuffling
            }
        } // end insertNode
        
        // Based on implicit Ordering, I presume...
        def findMin: A = nodes.min.data
        
        // GOTTA BUG HERE...
        /*
        def meld(that: PriorityQueue[A]): PriorityQueue[A] = {
            BinomialQueue(meldLists(this.nodes, that.nodes))
        }
        */
        // So getting the actual github version (which is substantially enhanced, it seems)
        def meld(that: PriorityQueue[A]) : PriorityQueue[A] = (this, that) match {
            case (BinomialQueue(Nil), q) => q
            case (q, BinomialQueue(Nil)) => q
            case (BinomialQueue(thisList), BinomialQueue(thatList)) => BinomialQueue(meldLists(thisList, thatList))
        }
        
        private def meldLists[T](q1: List[Node[T]], q2: List[Node[T]]) : List[Node[T]] = (q1, q2) match {
            case (Nil, q) => q
            case (q, Nil) => q
            case (x :: xs, y :: ys) => 
                if (x.rank < y.rank) x :: meldLists(xs, y :: ys)
                else if (x.rank > y.rank) y :: meldLists(x :: xs, ys)
                else insertNode(x.link(y), meldLists(xs, ys))
        }
        
        def deleteMin(): PriorityQueue[A] = {
            val minNode = nodes.min
            BinomialQueue(meldLists(nodes.filter(_ != minNode), minNode.children.reverse))
        }
        
    } // end BinomialQueue
}




