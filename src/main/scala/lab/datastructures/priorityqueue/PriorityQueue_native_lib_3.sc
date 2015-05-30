package lab.datastructures.priorityqueue

import scala.collection.mutable.PriorityQueue

object PriorityQueue_native_lib_3 {

  // http://rosettacode.org/wiki/Priority_queue#Scala
  // http://www.scala-lang.org/api/2.11.5/index.html#scala.collection.mutable.PriorityQueue
  // http://www.scala-lang.org/api/2.11.5/index.html#scala.collection.mutable.PriorityQueue$
  
  case class Task(pri:Int, text:String) extends Ordered[Task] {
    def compare(that: Task) = that.pri compare this.pri
  }
  
  val tasks = Seq(Task(3, "Clear drains"), Task(4, "Feed cat"),
      Task(5, "Make tea"), Task(1, "Solve RC tasks"), Task(2, "Tax return"))
                                                  //> tasks  : Seq[lab.datastructures.priorityqueue.PriorityQueue_native_lib_3.Tas
                                                  //| k] = List(Task(3,Clear drains), Task(4,Feed cat), Task(5,Make tea), Task(1,S
                                                  //| olve RC tasks), Task(2,Tax return))
 
  // Instantiate and invoke
  // Not ordered by toString
  val q0 = PriorityQueue[Task]() ++ tasks         //> q0  : scala.collection.mutable.PriorityQueue[lab.datastructures.priorityqueu
                                                  //| e.PriorityQueue_native_lib_3.Task] = PriorityQueue(Task(1,Solve RC tasks), T
                                                  //| ask(2,Tax return), Task(5,Make tea), Task(4,Feed cat), Task(3,Clear drains))
                                                  //| 
  
  val taskVect = for(task <- q0.dequeueAll) yield task
                                                  //> taskVect  : scala.collection.immutable.IndexedSeq[lab.datastructures.priorit
                                                  //| yqueue.PriorityQueue_native_lib_3.Task] = Vector(Task(1,Solve RC tasks), Tas
                                                  //| k(2,Tax return), Task(3,Clear drains), Task(4,Feed cat), Task(5,Make tea))
  
  val q1: PriorityQueue[Task] = PriorityQueue(Task(3, "Clear drains"), Task(4, "Feed cat"),
      Task(5, "Make tea"), Task(1, "Solve RC tasks"), Task(2, "Tax return"))
                                                  //> q1  : scala.collection.mutable.PriorityQueue[lab.datastructures.priorityqueu
                                                  //| e.PriorityQueue_native_lib_3.Task] = PriorityQueue(Task(1,Solve RC tasks), T
                                                  //| ask(2,Tax return), Task(5,Make tea), Task(4,Feed cat), Task(3,Clear drains))
                                                  //| 
  
  val q2: PriorityQueue[Task] = for(task <- q1) yield task
                                                  //> q2  : scala.collection.mutable.PriorityQueue[lab.datastructures.priorityque
                                                  //| ue.PriorityQueue_native_lib_3.Task] = PriorityQueue(Task(1,Solve RC tasks),
                                                  //|  Task(2,Tax return), Task(5,Make tea), Task(4,Feed cat), Task(3,Clear drain
                                                  //| s))
  
}