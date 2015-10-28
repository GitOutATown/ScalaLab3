package books.funproginscala.ch2

import Curry1_MEM._

object Curry_client {

  def foo = curry[Int, Int, Int]((x, y) => x + y) //> foo: => Int => (Int => Int)
  val bar = foo(2)                                //> bar  : Int => Int = <function1>
  bar(3)                                          //> res0: Int = 5

  '''                                             //> res1: Char('\'') = '
}