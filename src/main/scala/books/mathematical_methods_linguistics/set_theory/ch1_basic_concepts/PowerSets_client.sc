package books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts

import PowerSets._
import math.{pow}

object PowerSets_client {

  val s1 = Set('a', 'b')                          //> s1  : scala.collection.immutable.Set[Char] = Set(a, b)
  val s2 = Set('c', 'd', 'e', 'f')                //> s2  : scala.collection.immutable.Set[Char] = Set(c, d, e, f)
  
  pow(2, s1.size) // number of power sets = 2^n   //> res0: Double = 4.0
  pow(2, s2.size)                                 //> res1: Double = 16.0
  
  power(s1)                                       //> res2: Set[Set[Char]] = Set(Set(), Set(a), Set(b), Set(a, b))
  power(s2)                                       //> res3: Set[Set[Char]] = Set(Set(), Set(c, d, e, f), Set(c, e, f), Set(c, d, f
                                                  //| ), Set(c, d), Set(d), Set(c, d, e), Set(d, e), Set(c), Set(f), Set(d, f), Se
                                                  //| t(c, e), Set(d, e, f), Set(c, f), Set(e), Set(e, f))
  
  // -------------------- //
  
  case class Monkey(name: String, species: String)
  val chimp = Monkey("Howie", "Chimpanzie")       //> chimp  : books.mathematical_methods_linguistics.set_theory.ch1_basic_concept
                                                  //| s.PowerSets_client.Monkey = Monkey(Howie,Chimpanzie)
  
  val s3 = Set(chimp, 3.9, Set(true))             //> s3  : scala.collection.immutable.Set[Any] = Set(Monkey(Howie,Chimpanzie), 3.
                                                  //| 9, Set(true))
  pow(2, s3.size)                                 //> res4: Double = 8.0
  
  power(s3)                                       //> res5: Set[Set[Any]] = Set(Set(), Set(Set(true)), Set(Monkey(Howie,Chimpanzie
                                                  //| ), 3.9, Set(true)), Set(3.9), Set(3.9, Set(true)), Set(Monkey(Howie,Chimpanz
                                                  //| ie), 3.9), Set(Monkey(Howie,Chimpanzie)), Set(Monkey(Howie,Chimpanzie), Set(
                                                  //| true)))
  
  '''                                             //> res6: Char('\'') = '
}