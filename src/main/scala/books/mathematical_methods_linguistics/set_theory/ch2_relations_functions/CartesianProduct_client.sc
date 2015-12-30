package books.mathematical_methods_linguistics.set_theory.ch2_relations_functions

import books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts.SetOperations1._
import books.mathematical_methods_linguistics.set_theory.ch2_relations_functions.CartesianProduct._

object CartesianProduct_client {

  val K = Set('a', 'b', 'c')                      //> K  : scala.collection.immutable.Set[Char] = Set(a, b, c)
  val L = Set(1, 2)                               //> L  : scala.collection.immutable.Set[Int] = Set(1, 2)
  
  val res1 = for{
    k <- K
    l <- L
  } yield (k,l)                                   //> res1  : scala.collection.immutable.Set[(Char, Int)] = Set((c,2), (b,2), (a,2
                                                  //| ), (b,1), (c,1), (a,1))
  
  res1.size                                       //> res0: Int = 6
  
  // ------------- //
  
  cartProd(K, L)                                  //> res1: Set[(Char, Int)] = Set((c,2), (b,2), (a,2), (b,1), (c,1), (a,1))
  cartProd(L, K)                                  //> res2: Set[(Int, Char)] = Set((2,c), (1,c), (2,a), (1,a), (1,b), (2,b))
  cartProd(L, L)                                  //> res3: Set[(Int, Int)] = Set((1,1), (1,2), (2,1), (2,2))
  
  // ------------ //
  
  val M = Set((1,1), (1,2), (3,2))                //> M  : scala.collection.immutable.Set[(Int, Int)] = Set((1,1), (1,2), (3,2))
  val N = Set(1, 3)                               //> N  : scala.collection.immutable.Set[Int] = Set(1, 3)
  val O = Set(1, 2)                               //> O  : scala.collection.immutable.Set[Int] = Set(1, 2)
  val c1 = cartProd(N, O)                         //> c1  : Set[(Int, Int)] = Set((1,1), (1,2), (3,1), (3,2))
  
  isSubset(c1)(M)                                 //> res4: Boolean = true
  '''                                             //> res5: Char('\'') = '
}