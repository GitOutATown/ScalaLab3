package books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts

import PowerSets_MEM._
import math.pow

object PowerSets_MEM_client {

  val s1 = Set('a', 'b')                          //> s1  : scala.collection.immutable.Set[Char] = Set(a, b)
  val s2 = Set('c', 'd', 'e', 'f')                //> s2  : scala.collection.immutable.Set[Char] = Set(c, d, e, f)
  
  pow(2, s1.size) // number of power sets = 2^n   //> res0: Double = 4.0
  pow(2, s2.size)                                 //> res1: Double = 16.0
  
  powerMEM(s1)                                    //> res2: Set[Set[Char]] = Set(Set(), Set(a), Set(b), Set(a, b))
  powerMEM(s2)                                    //> res3: Set[Set[Char]] = Set(Set(), Set(c, d, e, f), Set(c, e, f), Set(c, d, f
                                                  //| ), Set(c, d), Set(d), Set(c, d, e), Set(d, e), Set(c), Set(f), Set(d, f), Se
                                                  //| t(c, e), Set(d, e, f), Set(c, f), Set(e), Set(e, f))

  '''                                             //> res4: Char('\'') = '
}