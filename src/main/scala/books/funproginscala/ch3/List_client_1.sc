package books.funproginscala.ch3

object List_client_1 {
  import books.funproginscala.ch3.List._
  
  val l1 = List(1,2,3,4)                          //> l1  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons(1,
                                                  //| Cons(2,Cons(3,Cons(4,Nil))))
  val l2 = List("ape", "apple", "banana", "app")  //> l2  : books#35.funproginscala#17381.ch3#17393.List#17412[String#264] = Cons(
                                                  //| ape,Cons(apple,Cons(banana,Cons(app,Nil))))
  val l3 = List(5, 6, 7)                          //> l3  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons(5,
                                                  //| Cons(6,Cons(7,Nil)))
  
  val l4 = List(1d,2,3,4)                         //> l4  : books#35.funproginscala#17381.ch3#17393.List#17412[Double#1639] = Cons
                                                  //| (1.0,Cons(2.0,Cons(3.0,Cons(4.0,Nil))))
  
  val l5 = Cons(0d, l4)                           //> l5  : books#35.funproginscala#17381.ch3#17393.Cons#154872[Double#1639] = Con
                                                  //| s(0.0,Cons(1.0,Cons(2.0,Cons(3.0,Cons(4.0,Nil)))))
  val res01 = List.sum(l1)                        //> res01  : Int#1123 = 10
  val res02 = List.sumAlt1(l1)                    //> res02  : Int#1123 = 10
  val res03 = List.sumAlt2(l1)                    //> res03  : Int#1123 = 10
  List.sumAlt3(l1)                                //> res0: Int#1123 = 10
  List.sumAlt4(l1)                                //> res1: Int#1123 = 10
  List.sumAlt5(l1)                                //> res2: Int#1123 = 10
  
  val res04 = List.product(l4)                    //> res04  : Double#1639 = 24.0
  val res05 = List.prodAlt1(l4)                   //> res05  : Double#1639 = 24.0
  val res06 = List.prodAlt1(Nil)                  //> res06  : Double#1639 = 1.0
  val res07 = List.prodAlt1(l5)                   //> res07  : Double#1639 = 0.0
  val res08 = List.prodAlt2(l5)                   //> res08  : Double#1639 = 0.0
  val res09 = List.prodAlt2(l4)                   //> res09  : Double#1639 = 24.0
  val resA1 = List.prodAlt3(l4)                   //> resA1  : Double#1639 = 24.0
  val resA2 = List.prodAlt4(l4)                   //> resA2  : Double#1639 = 24.0
  
  val res011 = List.tail(l1)                      //> res011  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Con
                                                  //| s(2,Cons(3,Cons(4,Nil)))
  //List.tail(List()) // correctly throws error
  List.setHead("fee", List("ho", "fi", "fo"))     //> res3: books#35.funproginscala#17381.ch3#17393.List#17412[String#264] = Cons(
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
  
  val res6a = List.dropWhile(l2, (x:String) => x.length < 4)
                                                  //> res6a  : books#35.funproginscala#17381.ch3#17393.List#17412[String#264] = C
                                                  //| ons(apple,Cons(banana,Cons(app,Nil)))
  // curried
  val res6b = List.dropWhileAlt(l2) (x => x.length < 4)
                                                  //> res6b  : books#35.funproginscala#17381.ch3#17393.List#17412[String#264] = C
                                                  //| ons(apple,Cons(banana,Cons(app,Nil)))
  val res7 = List.dropWhile(l2, (x:String) => x.startsWith("a"))
                                                  //> res7  : books#35.funproginscala#17381.ch3#17393.List#17412[String#264] = Co
                                                  //| ns(banana,Cons(app,Nil))
  val res8 = List.append(l1, l3)                  //> res8  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons
                                                  //| (1,Cons(2,Cons(3,Cons(4,Cons(5,Cons(6,Cons(7,Nil)))))))
  val res9 = List.init(l1)                        //> res9  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Cons
                                                  //| (1,Cons(2,Cons(3,Nil)))
  val res10 = List.init(List(1))                  //> res10  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Con
                                                  //| s(1,Nil)
  //val res11 = List.init(List()) // correctly throws error
  val res12 = List.init(List(1,2))                //> res12  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Con
                                                  //| s(1,Nil)
  
  val res13 = List.initAlt(l1)                    //> res13  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Con
                                                  //| s(1,Cons(2,Cons(3,Nil)))
  val res14 = List.initAlt(List(1))               //> res14  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Con
                                                  //| s(1,Nil)
  val res15 = List.initAlt(List(1,2))             //> res15  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Con
                                                  //| s(1,Nil)
  val res16 = foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_))
                                                  //> res16  : books#35.funproginscala#17381.ch3#17393.List#17412[Int#1123] = Con
                                                  //| s(1,Cons(2,Cons(3,Nil)))
  val res17 = List.length(l2)                     //> res17  : Int#1123 = 4
  val res18 = List.length(l5)                     //> res18  : Int#1123 = 5
  '''                                             //> res4: Char#1783('\'') = '
}