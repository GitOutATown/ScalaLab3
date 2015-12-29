package lab.typesystem.variance

object Variance_lab_2 {

  class Foo
  class Bar extends Foo
  
  val listA1: List[Foo] = List(new Foo)           //> listA1  : List[lab.typesystem.variance.Variance_lab_2.Foo] = List(lab.typesy
                                                  //| stem.variance.Variance_lab_2$Foo@3936d1b4)
  val listA2: List[Foo] = List(new Bar)           //> listA2  : List[lab.typesystem.variance.Variance_lab_2.Foo] = List(lab.typesy
                                                  //| stem.variance.Variance_lab_2$Bar@60483218)
  val listB1: List[Bar] = List(new Bar)           //> listB1  : List[lab.typesystem.variance.Variance_lab_2.Bar] = List(lab.typesy
                                                  //| stem.variance.Variance_lab_2$Bar@23d0f70a)
  
  // val listB2: List[Bar] = List(new Foo) // Error. Lists are covarriant
  
  // val listB3: List[-Bar] = List(new Foo) // Error.
  
  '''                                             //> res0: Char('\'') = '
}