package books.mathematical_methods_linguistics.set_theory.ch2_relations_functions

import Identity._
import Function._
import books.mathematical_methods_linguistics.set_theory.ch2_relations_functions.CartesianProduct._

object Identity_client {

  val A = Set('a', 'b', 'c')                      //> A  : scala.collection.immutable.Set[Char] = Set(a, b, c)
  val B = Set(1, 2, 3)                            //> B  : scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  val R1 = Set( ('a', 2), ('b', 1), ('c', 3) )    //> R1  : scala.collection.immutable.Set[(Char, Int)] = Set((a,2), (b,1), (c,3))
                                                  //| 
  
  identityRel(A)                                  //> res0: Set[(Char, Char)] = Set((a,a), (b,b), (c,c))
  
  inverse(identityRel(A))                         //> res1: Set[(Char, Char)] = Set((a,a), (b,b), (c,c))
  
  assert(identityRel(A) == inverse(identityRel(A)))
  
  identitySet(A)                                  //> res2: Set[Char] = Set(a, b, c)
  
  assert(identitySet(A) == A)
  
  // --------------- //
  
  // (2-10), Figure 2-5
  
  // idA
  val F = func(A)(B)(R1)                          //> F  : Set[Int] = Set(2, 1, 3)
  val Finv = func(F)(A)(inverse(R1))              //> Finv  : Set[Char] = Set(a, b, c)
  assert(Finv == identitySet(A))
  
  func(func(A)(B)(R1))(A)(inverse(R1))            //> res3: Set[Char] = Set(a, b, c)
  assert(func(func(A)(B)(R1))(A)(inverse(R1)) == identitySet(A))
  
  assert(F == B)
  assert(Finv == A)
  val Finv2 = func(B)(A)(inverse(R1))             //> Finv2  : Set[Char] = Set(b, a, c)
  assert(Finv2 == A)
  
  //idB
  val F2 = func(Finv2)(B)(R1)                     //> F2  : Set[Int] = Set(1, 2, 3)
  assert(F2 == identitySet(B))
  
  // ---------------- //
  
  '''                                             //> res4: Char('\'') = '
}