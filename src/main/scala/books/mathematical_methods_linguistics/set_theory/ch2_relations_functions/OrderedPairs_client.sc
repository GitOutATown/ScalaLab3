package books.mathematical_methods_linguistics.set_theory.ch2_relations_functions

import OrderedPairs._

object OrderedPairs_client {

  // NOT WORKING
  order(Set(1, 2, 3))                             //> 1
                                                  //| 2
                                                  //| 3
                                                  //| op: Set(Set())
                                                  //| op: Set(Set(1))
                                                  //| op: Set(Set(1, 2))
                                                  //| op: Set(Set(1, 2, 3))
                                                  //| res0: Set[Set[Int]] = Set(Set(1, 2, 3))
  
  ('a', 'b')                                      //> res1: (Char, Char) = (a,b)
  (('a', 'b'), 'c')                               //> res2: ((Char, Char), Char) = ((a,b),c)
  ((('a', 'b'), 'c'), 'd')                        //> res3: (((Char, Char), Char), Char) = (((a,b),c),d)

  '''                                             //> res4: Char('\'') = '
}