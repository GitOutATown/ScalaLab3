package books.funproginscala.ch3.MEM2

object List_Lab_1_client {
  import books.funproginscala.ch3.MEM2.List._
  
  List(1,2,3)                                     //> res0: books.funproginscala.ch3.MEM2.List[Int] = Cons(1,Cons(2,Cons(3,Nil)))
  
  foldRight(List(1,2,3), 0)(_+_)                  //> res1: Int = 6
  foldRight(List[Int](), 0)(_+_)                  //> res2: Int = 0
  foldRightTR(List(1,2,3), 0)(_+_)                //> res3: Int = 6
  foldRightTR(List[Int](), 0)(_+_)                //> res4: Int = 0
  
  foldRight(List(1,2,3), 1)(_*_)                  //> res5: Int = 6
  // Example of inappropriate result for Nil arg multiplication op:
  foldRight(List[Int](), 1)(_*_)                  //> res6: Int = 1
  foldRightTR(List(1,2,3), 1)(_*_)                //> res7: Int = 6
  foldRightTR(List[Int](), 1)(_*_)                //> res8: Int = 1
  
  sumFR(List(1,2,3))                              //> res9: Int = 6
  prodFR(List(1.2, 3.7, 0.9))                     //> res10: Double = 3.996
  
  sumFRTR(List(1,2,3))                            //> res11: Int = 6
  prodFRTR(List(1.2, 3.7, 0.9))                   //> res12: Double = 3.9960000000000004
  
  sumFLTR(List(1,2,3))                            //> res13: Int = 6
  prodFLTR(List(1.2, 3.7, 0.9))                   //> res14: Double = 3.9960000000000004
}
/*




*/