package books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts

import PowerSets_diagnostic._
import math.pow

object PowerSets_diagnostic_client {

  val s1 = Set('a', 'b', 'c')                     //> s1  : scala.collection.immutable.Set[Char] = Set(a, b, c)

  val res1 = powerDiag(s1)                        //> -----------------------
                                                  //| s: Set(a, b, c)
                                                  //| s.head: a
                                                  //| s.tail: Set(b, c)
                                                  //| ps: Set(Set())
                                                  //| ps map (_ + s.head): Set(Set(a))
                                                  //| ps ++ (ps map (_ + s.head)): Set(Set(), Set(a))
                                                  //| -----------------------
                                                  //| s: Set(b, c)
                                                  //| s.head: b
                                                  //| s.tail: Set(c)
                                                  //| ps: Set(Set(), Set(a))
                                                  //| ps map (_ + s.head): Set(Set(b), Set(a, b))
                                                  //| ps ++ (ps map (_ + s.head)): Set(Set(), Set(a), Set(b), Set(a, b))
                                                  //| -----------------------
                                                  //| s: Set(c)
                                                  //| s.head: c
                                                  //| s.tail: Set()
                                                  //| ps: Set(Set(), Set(a), Set(b), Set(a, b))
                                                  //| ps map (_ + s.head): Set(Set(c), Set(a, c), Set(b, c), Set(a, b, c))
                                                  //| ps ++ (ps map (_ + s.head)): Set(Set(), Set(a, b), Set(b, c), Set(a, c), Set
                                                  //| (a, b, c), Set(b), Set(c), Set(a))
                                                  //| -----------------------
                                                  //| s: Set()
                                                  //| s is empty. Returning ps...
                                                  //| res1  : Set[Set[Char]] = Set(Set(), Set(a, b), Set(b, c), Set(a, c), Set(a, 
                                                  //| b, c), Set(b), Set(c), Set(a))
  res1.size                                       //> res0: Int = 8
  
  Set(Set())                                      //> res1: scala.collection.immutable.Set[scala.collection.immutable.Set[Nothing]
                                                  //| ] = Set(Set())
  Set(Set(), Set('a'))                            //> res2: scala.collection.immutable.Set[scala.collection.immutable.Set[_ <: Cha
                                                  //| r]] = Set(Set(), Set(a))
  Set(Set(), Set('a'), Set('b'), Set('a', 'b'))   //> res3: scala.collection.immutable.Set[scala.collection.immutable.Set[_ <: Cha
                                                  //| r]] = Set(Set(), Set(a), Set(b), Set(a, b))
  Set(Set(), Set('a'), Set('b'), Set('a', 'b'), Set('c'), Set('a', 'c'), Set('b', 'c'), Set('a', 'b', 'c')).size
                                                  //> res4: Int = 8
  pow(2, 3)                                       //> res5: Double = 8.0
  
  
  '''                                             //> res6: Char('\'') = '
 
}