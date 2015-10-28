package books.funproginscala.ch2

import PolymorphicFun_MEM._

object PolymorphicFun_MEM_client {

  val fooMatch = stringMatch("foo")_              //> fooMatch  : String => Boolean = <function1>

  // ---- Data ------------- //
  
  val numbs1 = Array(97, 25, 480, 23)             //> numbs1  : Array[Int] = Array(97, 25, 480, 23)
  val numbs2 = Array(1,2,2,4,7,10,14,14)          //> numbs2  : Array[Int] = Array(1, 2, 2, 4, 7, 10, 14, 14)
  val strings = Array("bar", "bee", "foo", "jax", "bear")
                                                  //> strings  : Array[String] = Array(bar, bee, foo, jax, bear)
  val strings2 = Array("apple", "carrot", "grape", "grapefruit")
                                                  //> strings2  : Array[String] = Array(apple, carrot, grape, grapefruit)
  val strings3 = Array("apple", "carrot", "grapefruit", "grape")
                                                  //> strings3  : Array[String] = Array(apple, carrot, grapefruit, grape)
  
  // --- Results -------- //
  
  findFirst(strings, fooMatch)                    //> res0: Int = 2
  findFirst(strings2, fooMatch)                   //> res1: Int = -1
  
  isSorted(strings, (a: String, b: String) => a <= b)
                                                  //> res2: Boolean = false
  isSorted(numbs2, (a: Int, b: Int) => a <= b)    //> res3: Boolean = true

  '''                                             //> res4: Char('\'') = '
}