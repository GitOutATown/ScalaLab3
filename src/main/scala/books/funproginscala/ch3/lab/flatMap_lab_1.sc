package books.funproginscala.ch3.lab

object flatMap_lab_1 {
  
  List(1,2,3).flatMap { i => List(i,i) }          //> res0: List[Int] = List(1, 1, 2, 2, 3, 3)
}