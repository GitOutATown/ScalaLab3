package books.funproginscala.ch3.MEM

object List_client_MEM {

  import books.funproginscala.ch3.MEM.List._
    
  val l1 = List(1,2,3,4)                          //> l1  : books.funproginscala.ch3.MEM.List[Int] = Cons(1,Cons(2,Cons(3,Cons(4,N
                                                  //| il))))
  val l2 = List("ape", "apple", "banana", "app")  //> l2  : books.funproginscala.ch3.MEM.List[String] = Cons(ape,Cons(apple,Cons(b
                                                  //| anana,Cons(app,Nil))))
  val l3 = List(5, 6, 7)                          //> l3  : books.funproginscala.ch3.MEM.List[Int] = Cons(5,Cons(6,Cons(7,Nil)))
 
  val l4 = List(1d,2,3,4)                         //> l4  : books.funproginscala.ch3.MEM.List[Double] = Cons(1.0,Cons(2.0,Cons(3.0
                                                  //| ,Cons(4.0,Nil))))
  
  val l5 = Cons(0d, l4)                           //> l5  : books.funproginscala.ch3.MEM.Cons[Double] = Cons(0.0,Cons(1.0,Cons(2.0
                                                  //| ,Cons(3.0,Cons(4.0,Nil)))))
  val res01 = sum(l1)                             //> res01  : Int = 10
  val res02 = sumAlt1(l1)                         //> res02  : Int = 10
  
  val res04 = product(l4)                         //> res04  : Double = 24.0
  val resA4 = productAlt0(l4)                     //> resA4  : Double = 24.0
  //productAlt0(Nil) // correctly throws error
  val resB4 = productTR(l4)                       //> resB4  : Double = 24.0
  //productTR(Nil) // correctly throws error
  
  val res011 = tail(l1)                           //> res011  : books.funproginscala.ch3.MEM.List[Int] = Cons(2,Cons(3,Cons(4,Nil)
                                                  //| ))
  
  val res1 = drop(l1, 1)                          //> res1  : books.funproginscala.ch3.MEM.List[Int] = Cons(2,Cons(3,Cons(4,Nil)))
                                                  //| 
  val res2 = drop(l1, 2)                          //> res2  : books.funproginscala.ch3.MEM.List[Int] = Cons(3,Cons(4,Nil))
  val res3 = drop(l1, 3)                          //> res3  : books.funproginscala.ch3.MEM.List[Int] = Cons(4,Nil)
  val res4 = drop(l1, 4)                          //> res4  : books.funproginscala.ch3.MEM.List[Int] = Nil
 
  val res5 = drop(l1, 5)                          //> res5  : books.funproginscala.ch3.MEM.List[Int] = Nil
  
  val res6a = dropWhile(l2, (x:String) => x.length < 4)
                                                  //> res6a  : books.funproginscala.ch3.MEM.List[String] = Cons(apple,Cons(banana,
                                                  //| Cons(app,Nil)))
  val res6b = dropWhileCur(l2) (x => x.length < 4)//> res6b  : books.funproginscala.ch3.MEM.List[String] = Cons(apple,Cons(banana,
                                                  //| Cons(app,Nil)))
  val res9 = init(l1)                             //> res9  : books.funproginscala.ch3.MEM.List[Int] = Cons(1,Cons(2,Cons(3,Nil)))
                                                  //| 
  val res10 = init(List(1))                       //> res10  : books.funproginscala.ch3.MEM.List[Int] = Nil
  //val res11 = init(List()) // correctly throws error
  val res12 = init(List(1,2))                     //> res12  : books.funproginscala.ch3.MEM.List[Int] = Cons(1,Nil)
  
  setHead("fee", List("foo", "fi", "fo", "fum"))  //> res0: books.funproginscala.ch3.MEM.List[String] = Cons(fee,Cons(fi,Cons(fo,C
                                                  //| ons(fum,Nil))))
  val res13 = sumAlt2(l1)                         //> res13  : Int = 10
  
  val res14 = sumAlt3(l1)                         //> res14  : Int = 10
  
  val res15 = prodAlt2(l4)                        //> res15  : Double = 24.0
  
  '''                                             //> res1: Char('\'') = '
}
/*




*/