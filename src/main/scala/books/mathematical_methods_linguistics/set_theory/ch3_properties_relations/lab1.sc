package books.mathematical_methods_linguistics.set_theory.ch3_properties_relations

object lab1 {

  val v1 = 1                                      //> v1  : Int = 1
  val v2 = 1                                      //> v2  : Int = 1
  
  v1 == v2                                        //> res0: Boolean = true
  
  case class Person(name: String)
  
  val v3 = Person("Bob")                          //> v3  : books.mathematical_methods_linguistics.set_theory.ch3_properties_relat
                                                  //| ions.lab1.Person = Person(Bob)
  val v4 = Person("Bob")                          //> v4  : books.mathematical_methods_linguistics.set_theory.ch3_properties_relat
                                                  //| ions.lab1.Person = Person(Bob)
  
  v3 == v4                                        //> res1: Boolean = true

  '''                                             //> res2: Char('\'') = '
}