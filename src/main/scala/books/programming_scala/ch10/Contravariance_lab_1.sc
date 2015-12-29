package books.programming_scala.ch10

object Contravariance_lab_1 {

  class CSuper { def msuper() = println("CSuper") }
  class C extends CSuper { def m() = println("C") }
  //class C extends CSuper { override def toString() = "**C**" }
  class CSub extends C { def msub() = println("CSub") }
  
  var f: C => C = (c: C) => new C                 //> f  : books.programming_scala.ch10.Contravariance_lab_1.C => books.programmin
                                                  //| g_scala.ch10.Contravariance_lab_1.C = <function1>
  f(new C).m()                                    //> C
  f(new C).msuper()                               //> CSuper
  f(new CSub).m()                                 //> C
  f(new CSub).msuper()                            //> CSuper
  //f(new CSuper) // Error

  '''                                             //> res0: Char('\'') = '
}