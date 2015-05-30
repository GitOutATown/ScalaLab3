package lab.datastructures.priorityqueue.amitdev

object PriorityQueue_client_1 {
  // http://amitdev.github.io/coding/2014/03/06/Priority-Queue/
  // https://github.com/amitdev/functional-ds/blob/master/src/main/scala/ds/PriorityQueue.scala

  // [amit:] Make a PriorityQueue via the companion object factory
  /* [rw:] This calls GenericOrderedCompanion, author Aleksandar Prokopec
   * def apply[A](elems: A*)(implicit ord: Ordering[A]): CC[A]
   * The code flow trail winds up (perhaps through higherKinds?) at
   * object PriorityQueue extends OrderedTraversableFactory[PriorityQueue]
   * where a new ArrayBuffer calls foldLeft to build the BinomialQueue
   * (as accumulator).
   */
  println("==>PriorityQueue_client_1, Creating PriorityQueue")
                                                  //> ==>PriorityQueue_client_1, Creating PriorityQueue
  val pq1 = PriorityQueue(4,3,2,1,5)              //> ~~object PriorityQueue TOP
                                                  //| ~~object PriorityQueue def newBuilder TOP
                                                  //| ~~object PriorityQueue new ArrayBuffer
                                                  //| ~~In abst class PriorityQueue TOP
                                                  //| ~~class BinomialQueue TOP, nodes: List()
                                                  //| ..In class Node, data:4 rank:0 num children:0
                                                  //| ~~In abst class PriorityQueue TOP
                                                  //| ~~class BinomialQueue TOP, nodes: List(Node(4,0,List()))
                                                  //| ..In class Node, data:3 rank:0 num children:0
                                                  //| ..In class Node, data:3 rank:1 num children:1
                                                  //| ~~In abst class PriorityQueue TOP
                                                  //| ~~class BinomialQueue TOP, nodes: List(Node(3,1,List(Node(4,0,List()))))
                                                  //| ..In class Node, data:2 rank:0 num children:0
                                                  //| ~~In abst class PriorityQueue TOP
                                                  //| ~~class BinomialQueue TOP, nodes: List(Node(2,0,List()), Node(3,1,List(Node(
                                                  //| 4,0,List()))))
                                                  //| ..In class Node, data:1 rank:0 num children:0
                                                  //| ..In class Node, data:1 rank:1 num children:1
                                                  //| ..In class Node, data:1 rank:2 num children:2
                                                  //| ~~In abst class PriorityQueue TOP
                                                  //| ~~class BinomialQueue TOP, nodes: List(Node(1,2,List(
                                                  //| Output exceeds cutoff limit.
  // Pure functional behavior: delete and add create new PriorityQueues
  val pq1Min = pq1.findMin                        //> pq1Min  : Int = 1
  
  val pq2 = pq1.deleteMin                         //> ~~class BinomialQueue def meldLists
                                                  //| ..In class Node, data:2 rank:1 num children:1
                                                  //| ~~class BinomialQueue def meldLists
                                                  //| ..In class Node, data:2 rank:2 num children:2
                                                  //| ~~In abst class PriorityQueue TOP
                                                  //| ~~class BinomialQueue TOP, nodes: List(Node(2,2,List(Node(3,1,List(Node(4,0,
                                                  //| List()))), Node(5,0,List()))))
                                                  //| pq2  : lab.datastructures.priorityqueue.amitdev.PriorityQueue[Int] = Binomia
                                                  //| lQueue(2, 3, 4, 5)
  val pq2Min = pq2.findMin                        //> pq2Min  : Int = 2
  
  val pq3 = pq2 + 0                               //> ..In class Node, data:0 rank:0 num children:0
                                                  //| ~~In abst class PriorityQueue TOP
                                                  //| ~~class BinomialQueue TOP, nodes: List(Node(0,0,List()), Node(2,2,List(Node(
                                                  //| 3,1,List(Node(4,0,List()))), Node(5,0,List()))))
                                                  //| pq3  : lab.datastructures.priorityqueue.amitdev.PriorityQueue[Int] = Binomia
                                                  //| lQueue(0, 2, 3, 4, 5)
  val pq3Min = pq3.findMin                        //> pq3Min  : Int = 0
}
/*






*/