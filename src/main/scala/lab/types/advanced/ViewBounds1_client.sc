package lab.types.advanced

object ViewBounds1_client {
  
  import ViewBounds1._

  "123"                                           //> res0: String("123") = 123
  val y: Int = "123"                              //> y  : Int = 123
  //val z: Int = "huh" //NumberFormatException
  math.max("123", 111)                            //> res1: Int = 123
  
  (new Container[String]).addIt("123")            //> res2: Int = 246
  //(new Container[String]).addIt(123) // type mismatch
  (new Container[Int]).addIt(123)                 //> res3: Int = 246
  
  //(new Container[Float]).addIt(123.2F) // No implicit view available from Float => Int.
  
  List(1,2).sum                                   //> res4: Int = 3
  List(1,2.2).sum                                 //> res5: Double = 3.2
}