package lab.forall

object forall_lab {

  val result = List(1,2,3,4,5,6).forall { x => println(x); x < 3 }
                                                  //> 1
                                                  //| 2
                                                  //| 3
                                                  //| result  : Boolean = false

  '''                                             //> res0: Char('\'') = '
}