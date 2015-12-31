package books.mathematical_methods_linguistics.set_theory.ch2_relations_functions

import Function._

object Function_client {

  val A = Set('a', 'b', 'c')                      //> A  : scala.collection.immutable.Set[Char] = Set(a, b, c)
  val B = Set(1, 2, 3)                            //> B  : scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  val R1 = Set( ('a', 2), ('b', 1), ('c', 3) )    //> R1  : scala.collection.immutable.Set[(Char, Int)] = Set((a,2), (b,1), (c,3))
                                                  //| 
  val R2 = Set( ('a', 2), ('b', 2), ('c', 3) )    //> R2  : scala.collection.immutable.Set[(Char, Int)] = Set((a,2), (b,2), (c,3))
                                                  //| 
  val R3 = Set( ('a', 2), ('a', 1), ('c', 3) )    //> R3  : scala.collection.immutable.Set[(Char, Int)] = Set((a,2), (a,1), (c,3))
                                                  //| 
  
  assert(isFunction(A, B, R1))
  assert(isFunction(A, B, R2))
  assert(!isFunction(A, B, R3))
  '''                                             //> res0: Char('\'') = '
}