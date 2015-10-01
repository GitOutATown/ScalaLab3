package lab.option_try_either.bold_radius

object Lab1_client1 {
  import lab.option_try_either.bold_radius.Lab1._

  val out1 = searchObject("id1")                  //> out1  : lab.option_try_either.bold_radius.Lab1.MyObject = {"id": id1}
  s"(200, ${out1})"                               //> res0: String = (200, {"id": id1})
  
  val out2 = searchObject("id2")                  //> out2  : lab.option_try_either.bold_radius.Lab1.MyObject = {"id": id2}
  s"(200, ${out2})"                               //> res1: String = (200, {"id": id2})
  
  '''                                             //> res2: Char('\'') = '
}