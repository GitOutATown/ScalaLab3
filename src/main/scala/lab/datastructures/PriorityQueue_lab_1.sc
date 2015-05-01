package lab.datastructures
import scala.collection.mutable.PriorityQueue

object PriorityQueue_lab_1 {
	// http://rosettacode.org/wiki/Priority_queue#Scala
	// http://www.scala-lang.org/api/2.11.5/index.html#scala.collection.mutable.PriorityQueue
	// http://www.scala-lang.org/api/2.11.5/index.html#scala.collection.mutable.PriorityQueue$
	
	case class Task(prio:Int, text:String) extends Ordered[Task] {
	  def compare(that: Task) = that.prio compare this.prio
	}
 
	//test
	var q = PriorityQueue[Task]() ++ Seq(Task(3, "Clear drains"), Task(4, "Feed cat"),
  		Task(5, "Make tea"), Task(1, "Solve RC tasks"), Task(2, "Tax return"))
                                                  //> q  : scala.collection.mutable.PriorityQueue[lab.datastructures.PriorityQueue
                                                  //| _lab_1.Task] = PriorityQueue(Task(1,Solve RC tasks), Task(2,Tax return), Tas
                                                  //| k(5,Make tea), Task(4,Feed cat), Task(3,Clear drains))
	while(q.nonEmpty) println(q dequeue)      //> Task(1,Solve RC tasks)
                                                  //| Task(2,Tax return)
                                                  //| Task(3,Clear drains)
                                                  //| Task(4,Feed cat)
                                                  //| Task(5,Make tea)
}
/*



*/