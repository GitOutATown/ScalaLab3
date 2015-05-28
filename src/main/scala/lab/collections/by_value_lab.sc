package lab.collections

object by_value_lab {

  var foo = List("a", "b", "c")                   //> foo  : List[String] = List(a, b, c)
  
  var bar = foo                                   //> bar  : List[String] = List(a, b, c)
  
  bar                                             //> res0: List[String] = List(a, b, c)
  
  foo = List("x", "y", "z")
  foo                                             //> res1: List[String] = List(x, y, z)
  
  bar                                             //> res2: List[String] = List(a, b, c)

  '''                                             //> res3: Char('\'') = '
}