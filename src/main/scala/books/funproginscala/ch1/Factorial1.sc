package books.funproginscala.ch1

object Factorial1 {
  
  def fac(n: Int): Int = {
    def inter(n: Int, acc: Int): Int = {
      if(n <= 0) acc
      else(inter(n-1, n*acc))
    }
    inter(n, 1)
  }                                               //> fac: (n: Int)Int
  
  fac(3)                                          //> res0: Int = 6
  fac(4)                                          //> res1: Int = 24
}