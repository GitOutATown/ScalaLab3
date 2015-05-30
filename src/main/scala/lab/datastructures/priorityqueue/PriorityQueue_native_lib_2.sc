package lab.datastructures.priorityqueue

import scala.collection.mutable.PriorityQueue

object PriorityQueue_native_lib_2 {
  // http://rosettacode.org/wiki/Priority_queue#Scala
  
  case class Task(pri:Int, text:String) extends Ordered[Task] {
    def compare(that: Task) = that.pri compare this.pri
  }

  var q = PriorityQueue[Task]() ++ Seq(Task(3, "Clear drains"), Task(4, "Feed cat"),
      Task(5, "Make tea"), Task(1, "Solve RC tasks"), Task(2, "Tax return"))
                                                  //> q  : scala.collection.mutable.PriorityQueue[lab.datastructures.priorityqueue
                                                  //| .PriorityQueue_native_lib_2.Task] = PriorityQueue(Task(1,Solve RC tasks), Ta
                                                  //| sk(2,Tax return), Task(5,Make tea), Task(4,Feed cat), Task(3,Clear drains))
      
  q.dequeue()                                     //> res0: lab.datastructures.priorityqueue.PriorityQueue_native_lib_2.Task = Tas
                                                  //| k(1,Solve RC tasks)
  
  q                                               //> res1: scala.collection.mutable.PriorityQueue[lab.datastructures.priorityqueu
                                                  //| e.PriorityQueue_native_lib_2.Task] = PriorityQueue(Task(2,Tax return), Task(
                                                  //| 3,Clear drains), Task(5,Make tea), Task(4,Feed cat))
  
  q.enqueue(Task(1, "Listen to Amy"))
  
  q                                               //> res2: scala.collection.mutable.PriorityQueue[lab.datastructures.priorityqueu
                                                  //| e.PriorityQueue_native_lib_2.Task] = PriorityQueue(Task(1,Listen to Amy), Ta
                                                  //| sk(2,Tax return), Task(5,Make tea), Task(4,Feed cat), Task(3,Clear drains))
  
  q.dequeue()                                     //> res3: lab.datastructures.priorityqueue.PriorityQueue_native_lib_2.Task = Tas
                                                  //| k(1,Listen to Amy)
  
  q                                               //> res4: scala.collection.mutable.PriorityQueue[lab.datastructures.priorityqueu
                                                  //| e.PriorityQueue_native_lib_2.Task] = PriorityQueue(Task(2,Tax return), Task(
                                                  //| 3,Clear drains), Task(5,Make tea), Task(4,Feed cat))
  
  '''                                             //> res5: Char('\'') = '
}