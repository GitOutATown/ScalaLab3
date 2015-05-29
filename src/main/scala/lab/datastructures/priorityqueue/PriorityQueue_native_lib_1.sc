package lab.datastructures.priorityqueue

import scala.collection.mutable.PriorityQueue

object PriorityQueue_native_lib_1 {
  // http://rosettacode.org/wiki/Priority_queue#Scala
  // http://www.scala-lang.org/api/2.11.5/index.html#scala.collection.mutable.PriorityQueue
  // http://www.scala-lang.org/api/2.11.5/index.html#scala.collection.mutable.PriorityQueue$
  
  case class Task(pri:Int, text:String) extends Ordered[Task] {
    def compare(that: Task) = that.pri compare this.pri
  }
 
  // Instantiate and invoke
  // Not ordered by toString
  var q0 = PriorityQueue[Task]() ++ Seq(Task(3, "Clear drains"), Task(4, "Feed cat"),
      Task(5, "Make tea"), Task(1, "Solve RC tasks"), Task(2, "Tax return"))
                                                  //> q0  : scala.collection.mutable.PriorityQueue[lab.datastructures.priorityqueu
                                                  //| e.PriorityQueue_native_lib_1.Task] = PriorityQueue(Task(1,Solve RC tasks), T
                                                  //| ask(2,Tax return), Task(5,Make tea), Task(4,Feed cat), Task(3,Clear drains))
                                                  //| 
  val q1 = q0                                     //> q1  : scala.collection.mutable.PriorityQueue[lab.datastructures.priorityqueu
                                                  //| e.PriorityQueue_native_lib_1.Task] = PriorityQueue(Task(1,Solve RC tasks), T
                                                  //| ask(2,Tax return), Task(5,Make tea), Task(4,Feed cat), Task(3,Clear drains))
                                                  //| 
  q0                                              //> res0: scala.collection.mutable.PriorityQueue[lab.datastructures.priorityqueu
                                                  //| e.PriorityQueue_native_lib_1.Task] = PriorityQueue(Task(1,Solve RC tasks), T
                                                  //| ask(2,Tax return), Task(5,Make tea), Task(4,Feed cat), Task(3,Clear drains))
                                                  //| 
  while(q0.nonEmpty) println(q0 dequeue)          //> Task(1,Solve RC tasks)
                                                  //| Task(2,Tax return)
                                                  //| Task(3,Clear drains)
                                                  //| Task(4,Feed cat)
                                                  //| Task(5,Make tea)
  q0 // Emptied by dequeue                        //> res1: scala.collection.mutable.PriorityQueue[lab.datastructures.priorityqueu
                                                  //| e.PriorityQueue_native_lib_1.Task] = PriorityQueue()
  
  q1 // by name, not a copy                       //> res2: scala.collection.mutable.PriorityQueue[lab.datastructures.priorityqueu
                                                  //| e.PriorityQueue_native_lib_1.Task] = PriorityQueue()
  '''                                             //> res3: Char('\'') = '
}