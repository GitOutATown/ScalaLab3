package lab.datastructures.priorityqueue.amitdev

object PriorityQueue_client_3 extends App {

    case class Task(pri:Int, text:String) extends Ordered[Task] {
        // Note this compare order is oposite that of native Scala PriorityQueue for same behavioral order.
        def compare(that: Task) = this.pri compare that.pri
    }
    
    println("==>PriorityQueue_client_3, Creating PriorityQueue")
    val pq1 = PriorityQueue(Task(3, "Clear drains"), Task(4, "Feed cat"),
        Task(5, "Make tea"), Task(1, "Solve RC tasks"), Task(2, "Tax return"))
        
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
    
    println("\nCalling pq3 = pq2 + Task(0, \"Go for walk\")")
    val pq3 = pq2 + Task(0, "Go for walk")
    val pq3Min = pq3.findMin
    println("==>pq3Min: " + pq3Min)
    println("==>pq1: " + pq1)
    
}


