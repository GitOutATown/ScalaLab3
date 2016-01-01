package books.mathematical_methods_linguistics.set_theory.ch3_properties_relations

import Reflexivity._
import books.mathematical_methods_linguistics.set_theory.ch2_relations_functions.CartesianProduct._
import books.mathematical_methods_linguistics.set_theory.ch2_relations_functions.Identity._
import books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts.SetOperations1._

object Reflexivity_client {

  val A = Set(1,2,3)                              //> A  : scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  val R1 = Set((1,1), (2,2), (3,3), (3,1))        //> R1  : scala.collection.immutable.Set[(Int, Int)] = Set((1,1), (2,2), (3,3), 
                                                  //| (3,1))
  val R2 = Set((1,1), (2,2))                      //> R2  : scala.collection.immutable.Set[(Int, Int)] = Set((1,1), (2,2))
  
  isReflexive(A)(R1)                              //> res0: Boolean = true
  isReflexive(A)(R2)                              //> res1: Boolean = false
  
  // --------------- //
  
  case class Monkey(name: String, species: String)
  val chimp = Monkey("Howie", "Chimpanzie")       //> chimp  : books.mathematical_methods_linguistics.set_theory.ch3_properties_re
                                                  //| lations.Reflexivity_client.Monkey = Monkey(Howie,Chimpanzie)
  
  val B = Set(chimp, 3.9, Set("true"))            //> B  : scala.collection.immutable.Set[Any] = Set(Monkey(Howie,Chimpanzie), 3.9
                                                  //| , Set(true))
  
  val R3 = Set((chimp, chimp), (3.9, 3.9), (Set("true"), Set("true")), (chimp, 3.9))
                                                  //> R3  : scala.collection.immutable.Set[(Any, Any)] = Set((Monkey(Howie,Chimpan
                                                  //| zie),Monkey(Howie,Chimpanzie)), (3.9,3.9), (Set(true),Set(true)), (Monkey(Ho
                                                  //| wie,Chimpanzie),3.9))
  val R4 = Set((chimp, chimp), (3.9, 3.9), (chimp, 3.9), (Set("true"), Set("true")))
                                                  //> R4  : scala.collection.immutable.Set[(Any, Any)] = Set((Monkey(Howie,Chimpan
                                                  //| zie),Monkey(Howie,Chimpanzie)), (3.9,3.9), (Monkey(Howie,Chimpanzie),3.9), (
                                                  //| Set(true),Set(true)))
  
  val R5 = Set((chimp, chimp), (3.9, 3.9), (chimp, 3.9), (Set("true"), Set("true")))
                                                  //> R5  : scala.collection.immutable.Set[(Any, Any)] = Set((Monkey(Howie,Chimpan
                                                  //| zie),Monkey(Howie,Chimpanzie)), (3.9,3.9), (Monkey(Howie,Chimpanzie),3.9), (
                                                  //| Set(true),Set(true)))
  
  val R6 = Set((3.9, 3.9), (chimp, 3.9), (Set("true"), Set("true")))
                                                  //> R6  : scala.collection.immutable.Set[(Any, Any)] = Set((3.9,3.9), (Monkey(H
                                                  //| owie,Chimpanzie),3.9), (Set(true),Set(true)))
  // Note the required val type parameter here. Not exactly understanding which type combinations trigger this requirement.
  val R7: Set[(Any, Any)] = Set((chimp, chimp), (chimp, 3.9))
                                                  //> R7  : Set[(Any, Any)] = Set((Monkey(Howie,Chimpanzie),Monkey(Howie,Chimpanz
                                                  //| ie)), (Monkey(Howie,Chimpanzie),3.9))
  
  
  
  
  isReflexive(B)(R3)                              //> res2: Boolean = true
  isReflexive(B)(inverse(R3))                     //> res3: Boolean = true
  isReflexive(B)(R4)                              //> res4: Boolean = true
  isReflexive(B)(R5)                              //> res5: Boolean = true
  isReflexive(B)(R6)                              //> res6: Boolean = false
  isReflexive(B)(R7)                              //> res7: Boolean = false
  
  assert(isSubset(R3, identityRel(B)))
  assert(!isSubset(R7, identityRel(B)))
  
  nonReflexive(B)(R7)                             //> res8: Boolean = true
  
  val R8 = Set((1,2), (3,2))                      //> R8  : scala.collection.immutable.Set[(Int, Int)] = Set((1,2), (3,2))
  irreflexive(A)(R8)                              //> res9: Boolean = true
  
  irreflexive(B)(R7)                              //> res10: Boolean = false
  '''                                             //> res11: Char('\'') = '
}