package lab.datastructures.priorityqueue.amitdev

object PriorityQueue_client_2 extends App {
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
    val pq1 = PriorityQueue(4,3,2,1,5)
    println("==>pq1: " + pq1)
    
    // Pure functional behavior: delete and add create new PriorityQueues
    println("\nCalling pq1.findMin")
    val pq1Min = pq1.findMin
    println("==>pq1Min: " + pq1Min)
    
    println("\nCalling pq2 = pq1.deleteMin")
    val pq2 = pq1.deleteMin
    println("==>pq2: " + pq2)
    
    println("\nCalling pq2Min = pq2.findMin")
    val pq2Min = pq2.findMin
    println("==>pq2Min: " + pq2Min)
    
    println("\nCalling pq3 = pq2 + 0")
    val pq3 = pq2 + 0
    val pq3Min = pq3.findMin
    println("==>pq3Min: " + pq3Min)
}
