package lab.datastructures.priorityqueue.amitdev

import scala.collection.mutable.ArrayBuffer
import scala.collection.generic.{CanBuildFrom, OrderedTraversableFactory, GenericOrderedCompanion, GenericOrderedTraversableTemplate}
import scala.collection._
import scala.Iterator

// https://github.com/amitdev/functional-ds/blob/master/src/main/scala/ds/PriorityQueue.scala
/**
 * Abstract class representing a PriorityQueue which can be used thus:
 *
 * @example {{{
 *  // Make a PriorityQueue via the companion object factory
 *  val pq = PriorityQueue(4,3,2,1,5)
 *
 *  val min = pq.findMin // 1
 *  val secondMin = pq.deleteMin.findMin // 2
 *  val npq = pq + 0
 *  val npq.findMin // 0
 *  }}}
 * @param ord Ordering of data.
 * @tparam A Type of data.
 */
abstract class PriorityQueue[A](implicit val ord: Ordering[A])
    extends Iterable[A]
    with GenericOrderedTraversableTemplate[A, PriorityQueue]
    with IterableLike[A, PriorityQueue[A]] {
    
    println("~~abst class PriorityQueue TOP")

    /**
     * Adds a new item to the PriorityQueue.
     * @param x Item to add
     * @return New PriorityQueue which has this item added
     */
    def +(x: A) : PriorityQueue[A]

    /**
     * Finds the minimum item.
     * @return the minimum item
     */
    def findMin: A

    /**
     * Deletes the minimum item.
     *
     * @return New PriorityQueue which has the min item deleted.
     */
    def deleteMin(): PriorityQueue[A]

    /**
     * Merges two PriorityQueue together.
     *
     * @param that the PriorityQueue to merge
     * @return merged PriorityQueue
     */
    def meld(that: PriorityQueue[A]) : PriorityQueue[A]

    override def orderedCompanion: GenericOrderedCompanion[PriorityQueue] = {
        println("~~abst class PriorityQueue def orderedCompanion assigned as object PriorityQueue")
        PriorityQueue
    }
    override protected[this] def newBuilder: mutable.Builder[A, PriorityQueue[A]] = {
        println("~~abst class PriorityQueue def newBuilder")
        PriorityQueue.newBuilder
    }
} // end abstract class PriorityQueue

object PriorityQueue extends OrderedTraversableFactory[PriorityQueue] {
    println("~~object PriorityQueue TOP")

    // Methods related to scala collections
    override def newBuilder[A](implicit ord: Ordering[A]): mutable.Builder[A, PriorityQueue[A]] = {
        println("~~object PriorityQueue def newBuilder TOP")
        new ArrayBuffer[A] mapResult { xs =>
            println("~~object PriorityQueue def newBuilder new ArrayBuffer")
            xs.foldLeft(BinomialQueue[A](Nil))((t, x) => {
                println("~~object PriorityQueue def newBuilder new ArrayBuffer foldLeft BinomialQue +")
                t + x
            })
        }
    }

    implicit def canBuildFrom[A](implicit ord: Ordering[A]): CanBuildFrom[Coll, A, PriorityQueue[A]] = new GenericCanBuildFrom[A]
}

/**
 * A class representing a Node in the Binomial queue. Not intended to be used directly.
 * @param data The actual value stored in the Node.
 * @param rank Rank of the node.
 * @param children List of children.
 * @param ord Ordering of data.
 * @tparam A Type of data.
 */
private[amitdev] case class Node[A]
    (data: A, rank: Int = 0, children: List[Node[A]] = Nil)
    (implicit val ord: Ordering[A]) extends Ordered[Node[A]] {
    
    println("..class Node TOP, data:" + data + " rank:" + rank + " num children:" + children.length)

    /**
     * Links this node with another one and appropriately rearranges things.
     * @param other the node to link
     * @return Node with this and other linked.
     */
    def link(other: Node[A]) = {
        println("..class Node def link")
        if (ord.compare(data, other.data) < 0) Node(data, rank+1, other :: children)
        else Node(other.data, other.rank+1, this :: other.children)
    }

    def toList : List[A] = data :: children.flatMap(_.toList)

    override def compare(that: Node[A]): Int = ord.compare(data, that.data)
} // end Node

/**
 * This class implements a PriorityQueue using Binomial heaps.
 * @param nodes The forest of Nodes [rw: binomial trees]
 * @param ord Ordering of data
 * @tparam A Type of data
 */
private[amitdev] final case class BinomialQueue[A] 
    (nodes: List[Node[A]])(implicit override val ord: Ordering[A])
    extends PriorityQueue[A] {
    
    println("~~class BinomialQueue TOP, nodes: " + nodes)
    
    def +(x: A) : BinomialQueue[A] = BinomialQueue(insertNode(Node(x), nodes))

    def findMin: A = nodes.min.data

    def deleteMin(): PriorityQueue[A] = {
        val minNode = nodes.min
        BinomialQueue(meldLists(nodes.filter(_ != minNode), minNode.children.reverse))
    }

    def meld(that: PriorityQueue[A]) : PriorityQueue[A] = {
        println("~~class BinomialQueue def meld")
        (this, that) match {
            case (BinomialQueue(Nil), q) => q
            case (q, BinomialQueue(Nil)) => q
            case (BinomialQueue(thisList), BinomialQueue(thatList)) => BinomialQueue(meldLists(thisList, thatList))
        }
    }

    // Methods related to scala collections
    override def isEmpty: Boolean = nodes.isEmpty
    override def iterator: Iterator[A] = nodes.flatMap(_.toList).iterator

    private def meldLists[T](q1: List[Node[T]], q2: List[Node[T]]) : List[Node[T]] = {
        println("~~class BinomialQueue def meldLists")
        (q1, q2) match {
            case (Nil, q) => q
            case (q, Nil) => q
            case (x :: xs, y :: ys) => 
                if (x.rank < y.rank) x :: meldLists(xs, y :: ys)
                else if (x.rank > y.rank) y :: meldLists(x :: xs, ys)
                else insertNode(x.link(y), meldLists(xs, ys))
        }
    }

    private def insertNode[T](n: Node[T], lst: List[Node[T]]) : List[Node[T]] = {
        println("~~class BinomialQueue def insertNode, n:" + n)
        lst match {
            case Nil => List(n)
            case x :: xs => 
                if (n.rank < x.rank) n :: x :: xs
                else insertNode(x.link(n), xs)
        }
    }
} // end class BinomialQueue





