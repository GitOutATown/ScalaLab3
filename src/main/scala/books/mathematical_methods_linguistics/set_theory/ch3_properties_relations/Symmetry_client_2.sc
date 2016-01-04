package books.mathematical_methods_linguistics.set_theory.ch3_properties_relations

import Symmetry._

object Symmetry_client_2 {

  trait Gender
  case object M extends Gender
  case object F extends Gender

  case class Person(name: String, sex: Gender, age: Int)

  val glenda = Person("Glenda", F, 40)            //> glenda  : books.mathematical_methods_linguistics.set_theory.ch3_properties_r
                                                  //| elations.Symmetry_client_2.Person = Person(Glenda,F,40)
  val bruce = Person("Bruce", M, 20)              //> bruce  : books.mathematical_methods_linguistics.set_theory.ch3_properties_re
                                                  //| lations.Symmetry_client_2.Person = Person(Bruce,M,20)
  val anna = Person("Anna", F, 13)                //> anna  : books.mathematical_methods_linguistics.set_theory.ch3_properties_rel
                                                  //| ations.Symmetry_client_2.Person = Person(Anna,F,13)
  val howie = Person("Howie", M, 50)              //> howie  : books.mathematical_methods_linguistics.set_theory.ch3_properties_re
                                                  //| lations.Symmetry_client_2.Person = Person(Howie,M,50)
  val peter = Person("Peter", M, 19)              //> peter  : books.mathematical_methods_linguistics.set_theory.ch3_properties_re
                                                  //| lations.Symmetry_client_2.Person = Person(Peter,M,19)
  val jennifer = Person("Jennifer", F, 2)         //> jennifer  : books.mathematical_methods_linguistics.set_theory.ch3_properties
                                                  //| _relations.Symmetry_client_2.Person = Person(Jennifer,F,2)
  
  // For this relation to be logically appropriate, it must include
  // all reverse pairs since the definition of cousins is symmetric.
  val cousins = Set(
    (glenda, jennifer), (jennifer, glenda),
    (howie, jennifer), (jennifer, howie),
    (glenda, howie), (howie, glenda),
    (anna, peter), (peter, anna)
  )                                               //> cousins  : scala.collection.immutable.Set[(books.mathematical_methods_lingui
                                                  //| stics.set_theory.ch3_properties_relations.Symmetry_client_2.Person, books.ma
                                                  //| thematical_methods_linguistics.set_theory.ch3_properties_relations.Symmetry_
                                                  //| client_2.Person)] = Set((Person(Glenda,F,40),Person(Howie,M,50)), (Person(Ho
                                                  //| wie,M,50),Person(Jennifer,F,2)), (Person(Anna,F,13),Person(Peter,M,19)), (Pe
                                                  //| rson(Peter,M,19),Person(Anna,F,13)), (Person(Glenda,F,40),Person(Jennifer,F,
                                                  //| 2)), (Person(Jennifer,F,2),Person(Howie,M,50)), (Person(Howie,M,50),Person(G
                                                  //| lenda,F,40)), (Person(Jennifer,F,2),Person(Glenda,F,40)))
  
  
  
  // So, to be consistent with the idea of relations being ordered,
  // I also need to make this relation symmetric.
  val siblings = Set(
    (bruce, anna), (anna, bruce),
    (anna, glenda), (glenda, anna),
    (glenda, bruce), (bruce, glenda),
    (howie, peter), (peter, howie)
  )                                               //> siblings  : scala.collection.immutable.Set[(books.mathematical_methods_ling
                                                  //| uistics.set_theory.ch3_properties_relations.Symmetry_client_2.Person, books
                                                  //| .mathematical_methods_linguistics.set_theory.ch3_properties_relations.Symme
                                                  //| try_client_2.Person)] = Set((Person(Glenda,F,40),Person(Bruce,M,20)), (Pers
                                                  //| on(Bruce,M,20),Person(Anna,F,13)), (Person(Peter,M,19),Person(Howie,M,50)),
                                                  //|  (Person(Bruce,M,20),Person(Glenda,F,40)), (Person(Howie,M,50),Person(Peter
                                                  //| ,M,19)), (Person(Glenda,F,40),Person(Anna,F,13)), (Person(Anna,F,13),Person
                                                  //| (Bruce,M,20)), (Person(Anna,F,13),Person(Glenda,F,40)))
  
  val parentOf = Set(
    (glenda, anna), (howie, peter), (bruce, jennifer)
  )                                               //> parentOf  : scala.collection.immutable.Set[(books.mathematical_methods_ling
                                                  //| uistics.set_theory.ch3_properties_relations.Symmetry_client_2.Person, books
                                                  //| .mathematical_methods_linguistics.set_theory.ch3_properties_relations.Symme
                                                  //| try_client_2.Person)] = Set((Person(Glenda,F,40),Person(Anna,F,13)), (Perso
                                                  //| n(Howie,M,50),Person(Peter,M,19)), (Person(Bruce,M,20),Person(Jennifer,F,2)
                                                  //| ))
  
  val sisters = Set(
    (anna, glenda), (glenda, anna),
    (anna, jennifer), (jennifer, anna)
  )                                               //> sisters  : scala.collection.immutable.Set[(books.mathematical_methods_lingu
                                                  //| istics.set_theory.ch3_properties_relations.Symmetry_client_2.Person, books.
                                                  //| mathematical_methods_linguistics.set_theory.ch3_properties_relations.Symmet
                                                  //| ry_client_2.Person)] = Set((Person(Anna,F,13),Person(Glenda,F,40)), (Person
                                                  //| (Glenda,F,40),Person(Anna,F,13)), (Person(Anna,F,13),Person(Jennifer,F,2)),
                                                  //|  (Person(Jennifer,F,2),Person(Anna,F,13)))
  val duplicateRecords = Set(
    (Person("Howie", M, 50), Person("Howie", M, 50))
  )                                               //> duplicateRecords  : scala.collection.immutable.Set[(books.mathematical_meth
                                                  //| ods_linguistics.set_theory.ch3_properties_relations.Symmetry_client_2.Perso
                                                  //| n, books.mathematical_methods_linguistics.set_theory.ch3_properties_relatio
                                                  //| ns.Symmetry_client_2.Person)] = Set((Person(Howie,M,50),Person(Howie,M,50))
                                                  //| )
  // Relevant qualifier
  def isBrotherOf(p1: Person, p2: Person): Boolean = {
    p1.sex == M &&
    p1 != p2 // Not part of core logic, just a guard.
  }                                               //> isBrotherOf: (p1: books.mathematical_methods_linguistics.set_theory.ch3_pro
                                                  //| perties_relations.Symmetry_client_2.Person, p2: books.mathematical_methods_
                                                  //| linguistics.set_theory.ch3_properties_relations.Symmetry_client_2.Person)Bo
                                                  //| olean
  
  def isSisterOf(p1: Person, p2: Person): Boolean = {
    p1.sex == F &&
    p1 != p2
  }                                               //> isSisterOf: (p1: books.mathematical_methods_linguistics.set_theory.ch3_prop
                                                  //| erties_relations.Symmetry_client_2.Person, p2: books.mathematical_methods_l
                                                  //| inguistics.set_theory.ch3_properties_relations.Symmetry_client_2.Person)Boo
                                                  //| lean
  assert(isSym(cousins))
  assert(!isSymFunc(siblings)(isBrotherOf))
  assert(!isSymFunc(siblings)(isSisterOf))
  assert(isSymFunc(sisters)(isSisterOf))
  assert(isAsym(parentOf))
  assert(antiSym(duplicateRecords))

  '''                                             //> res0: Char('\'') = '
}