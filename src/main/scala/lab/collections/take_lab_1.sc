package lab.collections

object take_lab_1 {

  val l1 = List(1,2,3,4,5,6,7)                    //> l1  : List[Int] = List(1, 2, 3, 4, 5, 6, 7)
  val l2 = l1.take(3)                             //> l2  : List[Int] = List(1, 2, 3)
  l1                                              //> res0: List[Int] = List(1, 2, 3, 4, 5, 6, 7)
  val l3 = l1.take(10) // No error thrown         //> l3  : List[Int] = List(1, 2, 3, 4, 5, 6, 7)
  l3                                              //> res1: List[Int] = List(1, 2, 3, 4, 5, 6, 7)

  '''                                             //> res2: Char('\'') = '
}