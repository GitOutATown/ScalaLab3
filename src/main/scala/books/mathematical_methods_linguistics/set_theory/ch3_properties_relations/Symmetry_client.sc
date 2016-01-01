package books.mathematical_methods_linguistics.set_theory.ch3_properties_relations

import Symmetry._

object Symmetry_client {

  val s1 = Set(1,2,3)                             //> s1  : scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  
  // symmetrical
  
  val r4 = Set(
    (1,2), (2,1), (3,2), (2,3)
  )                                               //> r4  : scala.collection.immutable.Set[(Int, Int)] = Set((1,2), (2,1), (3,2), 
                                                  //| (2,3))
  val r5 = Set((2,2))                             //> r5  : scala.collection.immutable.Set[(Int, Int)] = Set((2,2))
  
  assert(isSymConstr(s1)(r4))
  assert(isSymConstr(s1)(r5))
  
  // nonsemmetrical

  val r1 = Set(
    (2,3), (1,2)
  )                                               //> r1  : scala.collection.immutable.Set[(Int, Int)] = Set((2,3), (1,2))
  val r2 = Set(
    (3,3), (1,3)
  )                                               //> r2  : scala.collection.immutable.Set[(Int, Int)] = Set((3,3), (1,3))
  val r3 = Set(
    (1,2), (2,1), (2,2), (1,1), (2,3)
  )                                               //> r3  : scala.collection.immutable.Set[(Int, Int)] = Set((1,1), (2,2), (2,3), 
                                                  //| (1,2), (2,1))

  assert(!isSym(r1))
  assert(!isSym(r2))
  assert(!isSym(r3))
  
  assert(!isSymConstr(s1)(r1))
  
  '''                                             //> res0: Char('\'') = '
}