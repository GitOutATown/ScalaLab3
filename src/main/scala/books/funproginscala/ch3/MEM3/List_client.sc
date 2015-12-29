package books.funproginscala.ch3.MEM3

import List._
object List_client {

  val ints = List(1,2,3)                          //> ints  : books.funproginscala.ch3.MEM3.List[Int] = Cons(1,Cons(2,Cons(3,Nil)))
                                                  //| 
  foldRight(ints, 0)(_+_)                         //> res0: Int = 6
  '''                                             //> res1: Char('\'') = '
}