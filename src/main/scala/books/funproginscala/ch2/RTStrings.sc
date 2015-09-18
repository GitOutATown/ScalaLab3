package books.funproginscala.ch2

object RTStrings {

  // def reverse is referentially transparent
  val x1 = "Hello World"                          //> x1  : String = Hello World
  val rev1 = x1.reverse                           //> rev1  : String = dlroW olleH
  val rev2 = x1.reverse                           //> rev2  : String = dlroW olleH
  rev1 == rev2                                    //> res0: Boolean = true
  rev1 == "Hello World".reverse                   //> res1: Boolean = true
  
  // def append is NOT referentially transparent
  val x2 = new StringBuilder("Hello")             //> x2  : StringBuilder = Hello
  val y2 = x2.append(" World")                    //> y2  : StringBuilder = Hello World
  val ref1 = y2.toString                          //> ref1  : String = Hello World
  val ref2 = y2.toString                          //> ref2  : String = Hello World
  ref1 == ref2 // So far, so good...              //> res2: Boolean = true
  // but...
  val y3 = x2.append(" World")                    //> y3  : StringBuilder = Hello World World
  val ref3 = y3.toString                          //> ref3  : String = Hello World World
  ref3 == ref2                                    //> res3: Boolean = false
  '''                                             //> res4: Char('\'') = '
}