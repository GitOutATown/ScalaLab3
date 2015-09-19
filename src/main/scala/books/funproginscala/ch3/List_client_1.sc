package books.funproginscala.ch3

object List_client_1 {
  import books.funproginscala.ch3.List._
  
  val l1 = List(1,2,3,4)                          //> l1  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons(1,
                                                  //| Cons(2,Cons(3,Cons(4,Nil))))
  val l2 = List("ape", "apple", "banana", "app")  //> l2  : books#35.funproginscala#17381.ch3#17393.List#17412[String#264] = Cons(
                                                  //| ape,Cons(apple,Cons(banana,Cons(app,Nil))))
  val l3 = List(5, 6, 7)                          //> l3  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons(5,
                                                  //| Cons(6,Cons(7,Nil)))
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
  
  val res6 = List.dropWhile(l2, (x:String) => x.length < 4)
                                                  //> res6  : books#35.funproginscala#17381.ch3#17393.List#17412[String#264] = Con
                                                  //| s(apple,Cons(banana,Cons(app,Nil)))
  val res7 = List.dropWhile(l2, (x:String) => x.startsWith("a"))
                                                  //> res7  : books#35.funproginscala#17381.ch3#17393.List#17412[String#264] = Con
                                                  //| s(banana,Cons(app,Nil))
  val res8 = List.append(l1, l3)                  //> res8  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons(
                                                  //| 1,Cons(2,Cons(3,Cons(4,Cons(5,Cons(6,Cons(7,Nil)))))))
  val res9 = List.init(l1)                        //> res9  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons(
                                                  //| 1,Cons(2,Cons(3,Nil)))
  val res10 = List.init(List(1))                  //> res10  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons
                                                  //| (1,Nil)
  //val res11 = List.init(List()) // correctly throws error
  val res12 = List.init(List(1,2))                //> res12  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons
                                                  //| (1,Nil)
  
  val res13 = List.initAlt(l1)                    //> res13  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons
                                                  //| (1,Cons(2,Cons(3,Nil)))
  val res14 = List.initAlt(List(1))               //> res14  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons
                                                  //| (1,Nil)
  val res15 = List.initAlt(List(1,2))             //> res15  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons
                                                  //| (1,Nil)
  
  '''                                             //> res3: Char#1783('\'') = '
}