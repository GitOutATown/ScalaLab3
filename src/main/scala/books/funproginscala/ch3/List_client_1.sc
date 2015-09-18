package books.funproginscala.ch3

object List_client_1 {
  import books.funproginscala.ch3.List._
  
  val l1 = List(1,2,3,4)                          //> l1  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons(1,
                                                  //| Cons(2,Cons(3,Cons(4,Nil))))
  List.sum(l1)                                    //> res0: Int#1123 = 10
  List.tail(l1)                                   //> res1: books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons(2,
                                                  //| Cons(3,Cons(4,Nil)))
  //List.tail(List()) // correctly throws error
  List.setHead("fee", List("ho", "fi", "fo"))     //> res2: books#35.funproginscala#17381.ch3#17393.List#17412[String#264] = Cons(
                                                  //| fee,Cons(fi,Cons(fo,Nil)))
  //List.setHead("fee", List()) // correctly throws error
  val res0 = List.drop(l1, 0)                     //> res0  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons(
                                                  //| 1,Cons(2,Cons(3,Cons(4,Nil))))
  
  val res1 = List.drop(l1, 1)                     //> res1  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons(
                                                  //| 2,Cons(3,Cons(4,Nil)))
  val res2 = List.drop(l1, 2)                     //> res2  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons(
                                                  //| 3,Cons(4,Nil))
  val res3 = List.drop(l1, 3)                     //> res3  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons(
                                                  //| 4,Nil)
  val res4 = List.drop(l1, 4)                     //> res4  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Nil
 
  val res5 = List.drop(l1, 5)                     //> res5  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Nil
  

  '''                                             //> res3: Char#1783('\'') = '
}