package books.mathematical_methods_linguistics.set_theory.ch3_properties_relations

import Reflexivity._

object Reflexivity_client_2 {

  case class Person(
    name: String,
    age: Int,
    height: Double
  )
    
  def tallerThan(a1: Person, a2: Person): Boolean = a1.height > a2.height
                                                  //> tallerThan: (a1: books.mathematical_methods_linguistics.set_theory.ch3_prope
                                                  //| rties_relations.Reflexivity_client_2.Person, a2: books.mathematical_methods_
                                                  //| linguistics.set_theory.ch3_properties_relations.Reflexivity_client_2.Person)
                                                  //| Boolean
  
  def sameAge(a1: Person, a2: Person): Boolean = a1.age == a2.age
                                                  //> sameAge: (a1: books.mathematical_methods_linguistics.set_theory.ch3_properti
                                                  //| es_relations.Reflexivity_client_2.Person, a2: books.mathematical_methods_lin
                                                  //| guistics.set_theory.ch3_properties_relations.Reflexivity_client_2.Person)Boo
                                                  //| lean
  // --------------- //
  
  
  val sophie = Person("Sophie", 42, 5.4)          //> sophie  : books.mathematical_methods_linguistics.set_theory.ch3_properties_r
                                                  //| elations.Reflexivity_client_2.Person = Person(Sophie,42,5.4)
  val margerie = Person("Margerie", 42, 5.8)      //> margerie  : books.mathematical_methods_linguistics.set_theory.ch3_properties
                                                  //| _relations.Reflexivity_client_2.Person = Person(Margerie,42,5.8)
  val jasmine = Person("Jasmine", 10, 5.8)        //> jasmine  : books.mathematical_methods_linguistics.set_theory.ch3_properties_
                                                  //| relations.Reflexivity_client_2.Person = Person(Jasmine,10,5.8)
  val clare = Person("Clare", 31, 5.6)            //> clare  : books.mathematical_methods_linguistics.set_theory.ch3_properties_re
                                                  //| lations.Reflexivity_client_2.Person = Person(Clare,31,5.6)
  
  val persons = Set(sophie, margerie, jasmine, clare)
                                                  //> persons  : scala.collection.immutable.Set[books.mathematical_methods_linguis
                                                  //| tics.set_theory.ch3_properties_relations.Reflexivity_client_2.Person] = Set(
                                                  //| Person(Sophie,42,5.4), Person(Margerie,42,5.8), Person(Jasmine,10,5.8), Pers
                                                  //| on(Clare,31,5.6))
  assert(irreflexFunc(persons)(tallerThan))
  assert(!irreflexFunc(persons)(sameAge))
  
  assert(nonReflexFunc(persons)(tallerThan))
  assert(!nonReflexFunc(persons)(sameAge))
  
  assert(!isReflexFunc(persons)(tallerThan))
  assert(isReflexFunc(persons)(sameAge))
  
  // ------------------- //
  
  // Financial relation
  val supports = Set(
    (sophie, sophie),
    (sophie, jasmine),
    (clare, clare),
    (margerie, margerie)
  )                                               //> supports  : scala.collection.immutable.Set[(books.mathematical_methods_ling
                                                  //| uistics.set_theory.ch3_properties_relations.Reflexivity_client_2.Person, bo
                                                  //| oks.mathematical_methods_linguistics.set_theory.ch3_properties_relations.Re
                                                  //| flexivity_client_2.Person)] = Set((Person(Sophie,42,5.4),Person(Sophie,42,5
                                                  //| .4)), (Person(Sophie,42,5.4),Person(Jasmine,10,5.8)), (Person(Clare,31,5.6)
                                                  //| ,Person(Clare,31,5.6)), (Person(Margerie,42,5.8),Person(Margerie,42,5.8)))
  assert(!irreflexive(persons)(supports))
  assert(nonReflexive(persons)(supports))
  
  '''                                             //> res0: Char('\'') = '
}