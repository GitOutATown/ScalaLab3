package books.funreactdomainmodels.lab

object Function1 {

   val succ = (x: Int) => x + 1                   //> succ  : Int => Int = <function1>
   val anonfun1 = new Function1[Int, Int] {
     def apply(x: Int): Int = x + 1
   }                                              //> anonfun1  : Int => Int = <function1>
   assert(succ(0) == anonfun1(0))
}