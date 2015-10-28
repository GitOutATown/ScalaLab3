package books.funproginscala.ch2

object NthFib1 {

  def nthFib(nth: Int): Int = {
    require(nth >= 0)
    
    def inner(cnt: Int, n1: Int, n2: Int): Int = {
      if(cnt < nth) inner(cnt + 1, n2 , n1 + n2)
      else n2
    }
   
    val cnt = 1
    val n1 = 0
    val n2 = 1
    
    if(nth == 0) 0
    else inner(cnt, n1, n2)
  }                                               //> nthFib: (nth: Int)Int
  
  nthFib(0)                                       //> res0: Int = 0
  nthFib(1)                                       //> res1: Int = 1
  nthFib(2)                                       //> res2: Int = 1
  nthFib(3)                                       //> res3: Int = 2
  nthFib(4)                                       //> res4: Int = 3
  nthFib(5)                                       //> res5: Int = 5
  nthFib(6)                                       //> res6: Int = 8

  '''                                             //> res7: Char('\'') = '
}