package lab.functions

object function_overloading_lab_2 extends App {

    // overloading depends on params, not return type
    def func(int: Int) { println(int) }
    def func(str: String) { println(str) }
    // error: func defined twice!
    // def func(int: Int): String = { int.toString() } 
  
    func(1)
    func("one")
}