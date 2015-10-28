package books.funproginscala.ch2

import Curry1_MEM._

object Curry_client {

  val foo = curry[Int, Int, Int]((x, y) => x + y) //> foo  : Int => (Int => Int) = <function1>
  val bar = foo(2)                                //> bar  : Int => Int = <function1>
  bar(3)                                          //> res0: Int = 5
  
  val fiz = uncurry[Int, Int, Int]((a) => (b) => a + b)
                                                  //> fiz  : (Int, Int) => Int = <function2>
  val baz = fiz(2, 3)                             //> baz  : Int = 5

  '''                                             //> res1: Char('\'') = '
}