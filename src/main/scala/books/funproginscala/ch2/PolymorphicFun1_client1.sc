package books.funproginscala.ch2

object PolymorphicFun1_client1 {

  import books.funproginscala.ch2.PolymorphicFun1._
  
  val fooMatch = strMatch("foo")_                 //> fooMatch  : String => Boolean = <function1>
  val startsWithJ = (s: String) =>
    s.startsWith("j")                             //> startsWithJ  : String => Boolean = <function1>
  val gt100 = (x: Int) => (x > 100)               //> gt100  : Int => Boolean = <function1>
  
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
  
  val res1 = findFirst(strings, fooMatch)         //> res1  : Int = 2
  
  val res1a = findFirst(strings2, fooMatch)       //> res1a  : Int = -1
    
  val res2 = findFirst(strings, startsWithJ)      //> res2  : Int = 3
  
  val res3 = findFirst(numbs1, gt100)             //> res3  : Int = 2
    
  val res4 = isSorted(numbs2, orderedInt)         //> res4  : Boolean = true
  
  val res5 = isSorted(strings2, orderedStr)       //> res5  : Boolean = true
  
  val res6 = isSorted(strings3, orderedStr)       //> res6  : Boolean = false
  
  val res7 = isSorted(numbs2, (a: Int, b: Int) => a <= b)
                                                  //> res7  : Boolean = true
  
  val res8 = isSorted(strings3, (a: String, b: String) => a <= b)
                                                  //> res8  : Boolean = false

  '''                                             //> res0: Char('\'') = '
}
/*



*/