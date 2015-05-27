package lab.collections

object nested_contains_lab {

  List(1,3,5).contains(2)                         //> res0: Boolean = false
  
  // Wrapper
  case class W(n: Int)
  val Ws = List(W(1), W(3), W(5))                 //> Ws  : List[lab.collections.nested_contains_lab.W] = List(W(1), W(3), W(5))
  Ws.contains(W(3))                               //> res1: Boolean = true
  
  def contains(Ws: List[W])(n: Int): Boolean = {
    val res = for {
      w <- Ws
      if (w.n == n)
    } yield true
    if(res.contains(true)) true else false
  }                                               //> contains: (Ws: List[lab.collections.nested_contains_lab.W])(n: Int)Boolean
  
  contains(Ws)(3)                                 //> res2: Boolean = true
  contains(Ws)(2)                                 //> res3: Boolean = false
  

  '''                                             //> res4: Char('\'') = '
}