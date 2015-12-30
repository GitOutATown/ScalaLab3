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
  smallest(M)                                     //> res5: (Set[Int], Set[Int]) = (Set(1, 3),Set(1, 2))
  
  // ------------- //
  
  val P = Set((1,1), (1,2), (3,2), (3,5))         //> P  : scala.collection.immutable.Set[(Int, Int)] = Set((1,1), (1,2), (3,2), (
                                                  //| 3,5))
  smallest(P)                                     //> res6: (Set[Int], Set[Int]) = (Set(1, 3),Set(1, 2, 5))
  
  // -------------- //
  
  val motherDaughter = Set(
    ("Sophie", "Glenda"),
    ("Margerie", "Bruce"),
    ("Margerie", "Anna"),
    ("Jasmine", "Howie"),
    ("Clare", "Peter"),
    ("Clare", "Jennifer"),
    ("Margerie", "Clare")
  )                                               //> motherDaughter  : scala.collection.immutable.Set[(String, String)] = Set((C
                                                  //| lare,Peter), (Margerie,Bruce), (Jasmine,Howie), (Sophie,Glenda), (Clare,Jen
                                                  //| nifer), (Margerie,Clare), (Margerie,Anna))
  val md1 = smallest(motherDaughter)              //> md1  : (Set[String], Set[String]) = (Set(Clare, Margerie, Jasmine, Sophie),
                                                  //| Set(Glenda, Anna, Clare, Jennifer, Bruce, Howie, Peter))
  (md1._1.size, md1._2.size)                      //> res7: (Int, Int) = (4,7)
  
  case class Person(name: String)
  
  val sophie = Person("Sophie")                   //> sophie  : books.mathematical_methods_linguistics.set_theory.ch2_relations_f
                                                  //| unctions.CartesianProduct_client.Person = Person(Sophie)
  val margerie = Person("Margerie")               //> margerie  : books.mathematical_methods_linguistics.set_theory.ch2_relations
                                                  //| _functions.CartesianProduct_client.Person = Person(Margerie)
  val jasmine = Person("Jasmine")                 //> jasmine  : books.mathematical_methods_linguistics.set_theory.ch2_relations_
                                                  //| functions.CartesianProduct_client.Person = Person(Jasmine)
  val clare = Person("Clare")                     //> clare  : books.mathematical_methods_linguistics.set_theory.ch2_relations_fu
                                                  //| nctions.CartesianProduct_client.Person = Person(Clare)
  val glenda = Person("Glenda")                   //> glenda  : books.mathematical_methods_linguistics.set_theory.ch2_relations_f
                                                  //| unctions.CartesianProduct_client.Person = Person(Glenda)
  val bruce = Person("Bruce")                     //> bruce  : books.mathematical_methods_linguistics.set_theory.ch2_relations_fu
                                                  //| nctions.CartesianProduct_client.Person = Person(Bruce)
  val anna = Person("Anna")                       //> anna  : books.mathematical_methods_linguistics.set_theory.ch2_relations_fun
                                                  //| ctions.CartesianProduct_client.Person = Person(Anna)
  val howie = Person("Howie")                     //> howie  : books.mathematical_methods_linguistics.set_theory.ch2_relations_fu
                                                  //| nctions.CartesianProduct_client.Person = Person(Howie)
  val peter = Person("Peter")                     //> peter  : books.mathematical_methods_linguistics.set_theory.ch2_relations_fu
                                                  //| nctions.CartesianProduct_client.Person = Person(Peter)
  val jennifer = Person("Jennifer")               //> jennifer  : books.mathematical_methods_linguistics.set_theory.ch2_relations
                                                  //| _functions.CartesianProduct_client.Person = Person(Jennifer)
  
  val motherDaughter2 = Set(
    (sophie, glenda),
    (margerie, bruce),
    (margerie, anna),
    (jasmine, howie),
    (clare, peter),
    (clare, jennifer),
    (margerie, clare)
  )                                               //> motherDaughter2  : scala.collection.immutable.Set[(books.mathematical_metho
                                                  //| ds_linguistics.set_theory.ch2_relations_functions.CartesianProduct_client.P
                                                  //| erson, books.mathematical_methods_linguistics.set_theory.ch2_relations_func
                                                  //| tions.CartesianProduct_client.Person)] = Set((Person(Margerie),Person(Clare
                                                  //| )), (Person(Jasmine),Person(Howie)), (Person(Clare),Person(Jennifer)), (Per
                                                  //| son(Margerie),Person(Bruce)), (Person(Margerie),Person(Anna)), (Person(Soph
                                                  //| ie),Person(Glenda)), (Person(Clare),Person(Peter)))
             
  val md2 = smallest(motherDaughter2)             //> md2  : (Set[books.mathematical_methods_linguistics.set_theory.ch2_relations
                                                  //| _functions.CartesianProduct_client.Person], Set[books.mathematical_methods_
                                                  //| linguistics.set_theory.ch2_relations_functions.CartesianProduct_client.Pers
                                                  //| on]) = (Set(Person(Margerie), Person(Jasmine), Person(Clare), Person(Sophie
                                                  //| )),Set(Person(Anna), Person(Glenda), Person(Peter), Person(Howie), Person(B
                                                  //| ruce), Person(Clare), Person(Jennifer)))
  (md2._1.size, md2._2.size)                      //> res8: (Int, Int) = (4,7)
  
  // -------------- //
  
  val (mothers, daughters) = smallest(motherDaughter2)
                                                  //> mothers  : Set[books.mathematical_methods_linguistics.set_theory.ch2_relati
                                                  //| ons_functions.CartesianProduct_client.Person] = Set(Person(Margerie), Perso
                                                  //| n(Jasmine), Person(Clare), Person(Sophie))
                                                  //| daughters  : Set[books.mathematical_methods_linguistics.set_theory.ch2_rela
                                                  //| tions_functions.CartesianProduct_client.Person] = Set(Person(Anna), Person(
                                                  //| Glenda), Person(Peter), Person(Howie), Person(Bruce), Person(Clare), Person
                                                  //| (Jennifer))
  val cartProdAll = cartProd(mothers, daughters)  //> cartProdAll  : Set[(books.mathematical_methods_linguistics.set_theory.ch2_r
                                                  //| elations_functions.CartesianProduct_client.Person, books.mathematical_metho
                                                  //| ds_linguistics.set_theory.ch2_relations_functions.CartesianProduct_client.P
                                                  //| erson)] = Set((Person(Jasmine),Person(Peter)), (Person(Margerie),Person(Pet
                                                  //| er)), (Person(Sophie),Person(Bruce)), (Person(Sophie),Person(Clare)), (Pers
                                                  //| on(Jasmine),Person(Bruce)), (Person(Sophie),Person(Anna)), (Person(Margerie
                                                  //| ),Person(Clare)), (Person(Jasmine),Person(Howie)), (Person(Sophie),Person(J
                                                  //| ennifer)), (Person(Clare),Person(Jennifer)), (Person(Jasmine),Person(Jennif
                                                  //| er)), (Person(Margerie),Person(Jennifer)), (Person(Jasmine),Person(Clare)),
                                                  //|  (Person(Margerie),Person(Bruce)), (Person(Margerie),Person(Glenda)), (Pers
                                                  //| on(Jasmine),Person(Glenda)), (Person(Sophie),Person(Peter)), (Person(Marger
                                                  //| ie),Person(Anna)), (Person(Clare),Person(Clare)), (Person(Margerie),Person(
                                                  //| Howie)), (Person(Sophie
                                                  //| Output exceeds cutoff limit.
  val comp = compliment(cartProdAll)(motherDaughter2)
                                                  //> comp  : Set[(books.mathematical_methods_linguistics.set_theory.ch2_relation
                                                  //| s_functions.CartesianProduct_client.Person, books.mathematical_methods_ling
                                                  //| uistics.set_theory.ch2_relations_functions.CartesianProduct_client.Person)]
                                                  //|  = Set((Person(Jasmine),Person(Peter)), (Person(Margerie),Person(Peter)), (
                                                  //| Person(Sophie),Person(Bruce)), (Person(Sophie),Person(Clare)), (Person(Jasm
                                                  //| ine),Person(Bruce)), (Person(Sophie),Person(Anna)), (Person(Sophie),Person(
                                                  //| Jennifer)), (Person(Jasmine),Person(Jennifer)), (Person(Margerie),Person(Je
                                                  //| nnifer)), (Person(Jasmine),Person(Clare)), (Person(Margerie),Person(Glenda)
                                                  //| ), (Person(Jasmine),Person(Glenda)), (Person(Sophie),Person(Peter)), (Perso
                                                  //| n(Clare),Person(Clare)), (Person(Margerie),Person(Howie)), (Person(Jasmine)
                                                  //| ,Person(Anna)), (Person(Clare),Person(Glenda)), (Person(Clare),Person(Bruce
                                                  //| )), (Person(Sophie),Person(Howie)), (Person(Clare),Person(Howie)), (Person(
                                                  //| Clare),Person(Anna)))
  cartProdAll.size                                //> res9: Int = 28
  motherDaughter2.size                            //> res10: Int = 7
  comp.size                                       //> res11: Int = 21
  (motherDaughter2 union comp) == cartProdAll     //> res12: Boolean = true
  (motherDaughter2 intersect comp) == Set.empty   //> res13: Boolean = true
  
  val persons = mothers ++ daughters              //> persons  : scala.collection.immutable.Set[books.mathematical_methods_lingui
                                                  //| stics.set_theory.ch2_relations_functions.CartesianProduct_client.Person] = 
                                                  //| Set(Person(Anna), Person(Margerie), Person(Glenda), Person(Peter), Person(H
                                                  //| owie), Person(Bruce), Person(Clare), Person(Sophie), Person(Jasmine), Perso
                                                  //| n(Jennifer))
  persons.size                                    //> res14: Int = 10
  
  '''                                             //> res15: Char('\'') = '
}