package books.funproginscala.ch2

object Factorial_MEM {

  def facMEM(n: Int): Int = {
    require(n > 0)
    def inner(n: Int, acc: Int): Int = {
      if(n <= 1) acc
      else inner(n-1, n*acc)
    }
    
    inner(n, 1)
  }                                               //> facMEM: (n: Int)Int
  
  facMEM(3)                                       //> res0: Int = 6
  facMEM(4)                                       //> res1: Int = 24

  '''                                             //> res2: Char('\'') = '
}