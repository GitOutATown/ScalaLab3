package lab.currying

object curry_lab_1_client_1 {
  import lab.currying.curry_lab_1._
  import lab.currying.curry_lab_1_MEM._
  
  val nums = List(1, 2, 3, 4, 5, 6, 7, 8)         //> nums  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)

  modN(2)_                                        //> res0: Int => Boolean = <function1>
  
  filter(nums, modN(2))                           //> res1: List[Int] = List(2, 4, 6, 8)
  filter(nums, modN(3))                           //> res2: List[Int] = List(3, 6)
  
  // ----------------------- //
  
  filterMEM(nums, modNMEM(2))                     //> res3: List[Int] = List(2, 4, 6, 8)
  filterMEM(nums, modNMEM(3))                     //> res4: List[Int] = List(3, 6)
  
  
  '''                                             //> res5: Char('\'') = '
}