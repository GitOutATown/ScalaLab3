package books.mathematical_methods_linguistics.set_theory.ch3_properties_relations

import Symmetry._

object Symmetry_client_2 {

  trait Gender
  case object M extends Gender
  case object F extends Gender

  case class Person(name: String, sex: Gender)

  val glenda = Person("Glenda", F)                //> glenda  : books.mathematical_methods_linguistics.set_theory.ch3_properties_r
                                                  //| elations.Symmetry_client_2.Person = Person(Glenda,F)
  val bruce = Person("Bruce", M)                  //> bruce  : books.mathematical_methods_linguistics.set_theory.ch3_properties_re
                                                  //| lations.Symmetry_client_2.Person = Person(Bruce,M)
  val anna = Person("Anna", F)                    //> anna  : books.mathematical_methods_linguistics.set_theory.ch3_properties_rel
                                                  //| ations.Symmetry_client_2.Person = Person(Anna,F)
  val howie = Person("Howie", M)                  //> howie  : books.mathematical_methods_linguistics.set_theory.ch3_properties_re
                                                  //| lations.Symmetry_client_2.Person = Person(Howie,M)
  val peter = Person("Peter", M)                  //> peter  : books.mathematical_methods_linguistics.set_theory.ch3_properties_re
                                                  //| lations.Symmetry_client_2.Person = Person(Peter,M)
  val jennifer = Person("Jennifer", F)            //> jennifer  : books.mathematical_methods_linguistics.set_theory.ch3_properties
                                                  //| _relations.Symmetry_client_2.Person = Person(Jennifer,F)
  
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
                                                  //| client_2.Person)] = Set((Person(Howie,M),Person(Glenda,F)), (Person(Jennifer
                                                  //| ,F),Person(Howie,M)), (Person(Glenda,F),Person(Jennifer,F)), (Person(Anna,F)
                                                  //| ,Person(Peter,M)), (Person(Peter,M),Person(Anna,F)), (Person(Howie,M),Person
                                                  //| (Jennifer,F)), (Person(Jennifer,F),Person(Glenda,F)), (Person(Glenda,F),Pers
                                                  //| on(Howie,M)))
  
  
  
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
                                                  //| try_client_2.Person)] = Set((Person(Bruce,M),Person(Anna,F)), (Person(Anna,
                                                  //| F),Person(Glenda,F)), (Person(Glenda,F),Person(Anna,F)), (Person(Bruce,M),P
                                                  //| erson(Glenda,F)), (Person(Peter,M),Person(Howie,M)), (Person(Glenda,F),Pers
                                                  //| on(Bruce,M)), (Person(Howie,M),Person(Peter,M)), (Person(Anna,F),Person(Bru
                                                  //| ce,M)))
  
  val sisters = Set(
    (anna, glenda), (glenda, anna),
    (anna, jennifer), (jennifer, anna)
  )                                               //> sisters  : scala.collection.immutable.Set[(books.mathematical_methods_lingu
                                                  //| istics.set_theory.ch3_properties_relations.Symmetry_client_2.Person, books.
                                                  //| mathematical_methods_linguistics.set_theory.ch3_properties_relations.Symmet
                                                  //| ry_client_2.Person)] = Set((Person(Anna,F),Person(Glenda,F)), (Person(Glend
                                                  //| a,F),Person(Anna,F)), (Person(Anna,F),Person(Jennifer,F)), (Person(Jennifer
                                                  //| ,F),Person(Anna,F)))
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

  '''                                             //> res0: Char('\'') = '
}