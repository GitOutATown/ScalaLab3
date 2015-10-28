package books.funproginscala.ch2

object Factorial1 {
  
  def fac(n0: Int): Int = {
    require(n0 > 0)
    def inner(n: Int, acc: Int): Int = {
      if(n <= 0) acc
      else(inner(n-1, n*acc))
    }
    inner(n0, 1)
  }                                               //> fac: (n0: Int)Int
  
  fac(3)                                          //> res0: Int = 6
  fac(4)                                          //> res1: Int = 24
}