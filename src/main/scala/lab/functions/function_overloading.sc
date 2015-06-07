package lab.functions

object function_overloading {

  // WORKSHEET CAN EVIDENTLY NOT DEAL WITH OVERLOADING!
  // see function_overloading_lab_2.scala
  def func(int: Int) { println(int) }
  def func(str: String) { println(str) }
  
  func(1)
  func("one")
  
  '''
}