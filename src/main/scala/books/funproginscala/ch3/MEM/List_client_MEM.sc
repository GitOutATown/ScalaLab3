package books.funproginscala.ch3.MEM

object List_client_MEM {

  import books.funproginscala.ch3.MEM.List._
  
  import books.funproginscala.ch3.List._
  
  val l1 = List(1,2,3,4)                          //> l1  : books.funproginscala.ch3.MEM.List[Int] = Cons(1,Cons(2,Cons(3,Cons(4,N
                                                  //| il))))
  val l2 = List("ape", "apple", "banana", "app")  //> l2  : books.funproginscala.ch3.MEM.List[String] = Cons(ape,Cons(apple,Cons(b
                                                  //| anana,Cons(app,Nil))))
  val l3 = List(5, 6, 7)                          //> l3  : books.funproginscala.ch3.MEM.List[Int] = Cons(5,Cons(6,Cons(7,Nil)))
 
  val l4 = List(1d,2,3,4)                         //> l4  : books.funproginscala.ch3.MEM.List[Double] = Cons(1.0,Cons(2.0,Cons(3.0
                                                  //| ,Cons(4.0,Nil))))
  
  val l5 = Cons(0d, l4)                           //> l5  : books.funproginscala.ch3.MEM.Cons[Double] = Cons(0.0,Cons(1.0,Cons(2.0
                                                  //| ,Cons(3.0,Cons(4.0,Nil)))))
  val res01 = List.sum(l1)                        //> res01  : Int = 10
  val res02 = List.sumAlt1(l1)                    //> res02  : Int = 10
  
  val res04 = List.product(l4)                    //> res04  : Double = 24.0
  val resA4 = List.productAlt0(l4)                //> resA4  : Double = 24.0
  //List.productAlt0(Nil) // correctly throws error
  val resB4 = List.productTR(l4)                  //> resB4  : Double = 24.0
  //List.productTR(Nil) // correctly throws error
  
  val res011 = List.tail(l1)                      //> res011  : books.funproginscala.ch3.MEM.List[Int] = Cons(2,Cons(3,Cons(4,Nil)
                                                  //| ))
  
  val res1 = List.drop(l1, 1)                     //> res1  : books.funproginscala.ch3.MEM.List[Int] = Cons(2,Cons(3,Cons(4,Nil)))
                                                  //| 
  val res2 = List.drop(l1, 2)                     //> res2  : books.funproginscala.ch3.MEM.List[Int] = Cons(3,Cons(4,Nil))
  val res3 = List.drop(l1, 3)                     //> res3  : books.funproginscala.ch3.MEM.List[Int] = Cons(4,Nil)
  val res4 = List.drop(l1, 4)                     //> res4  : books.funproginscala.ch3.MEM.List[Int] = Nil
 
  val res5 = List.drop(l1, 5)                     //> res5  : books.funproginscala.ch3.MEM.List[Int] = Nil
  
  val res6a = List.dropWhile(l2, (x:String) => x.length < 4)
                                                  //> res6a  : books.funproginscala.ch3.MEM.List[String] = Cons(apple,Cons(banana,
                                                  //| Cons(app,Nil)))
  val res6b = List.dropWhileCur(l2) (x => x.length < 4)
                                                  //> res6b  : books.funproginscala.ch3.MEM.List[String] = Cons(apple,Cons(banana,
                                                  //| Cons(app,Nil)))
  val res9 = List.init(l1)                        //> res9  : books.funproginscala.ch3.MEM.List[Int] = Cons(1,Cons(2,Cons(3,Nil)))
                                                  //| 
  val res10 = List.init(List(1))                  //> res10  : books.funproginscala.ch3.MEM.List[Int] = Nil
  //val res11 = List.init(List()) // correctly throws error
  val res12 = List.init(List(1,2))                //> res12  : books.funproginscala.ch3.MEM.List[Int] = Cons(1,Nil)
  
  '''                                             //> res0: Char('\'') = '
}
/*






*/