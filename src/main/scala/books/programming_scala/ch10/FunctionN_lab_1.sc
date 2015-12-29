package books.programming_scala.ch10

object FunctionN_lab_1 {

  val max = (x: Int, y: Int) => if(x < y) y else x//> max  : (Int, Int) => Int = <function2>
  
  val anonfun2: (Int, Int) => Int = new Function2[Int, Int, Int] {
    def apply(x: Int, y: Int): Int = if(x < y) y else x
  }                                               //> anonfun2  : (Int, Int) => Int = <function2>
  
  assert(max(4, 7) == anonfun2(7, 4))
  
  // ------------------- //
  
  List(1,2,3,4) map (i => i + 1)                  //> res0: List[Int] = List(2, 3, 4, 5)
  
  def f(i: Int) = i + 1                           //> f: (i: Int)Int
  
  List(1,2,3,4) map f                             //> res1: List[Int] = List(2, 3, 4, 5)
  
  val f1: Int => Int = new Function1[Int, Int] {
    def apply(i: Int) = i + 1
  }                                               //> f1  : Int => Int = <function1>
  
  List(1,2,3,4) map f1                            //> res2: List[Int] = List(2, 3, 4, 5)

  '''                                             //> res3: Char('\'') = '
}