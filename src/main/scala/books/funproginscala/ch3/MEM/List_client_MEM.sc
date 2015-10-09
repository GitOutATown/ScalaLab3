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
  
  val l6 = List("Zebra", "Zygote")                //> l6  : books.funproginscala.ch3.MEM.List[String] = Cons(Zebra,Cons(Zygote,Nil
                                                  //| ))
  val res01 = sum(l1)                             //> res01  : Int = 10
  val res02 = sumAlt1(l1)                         //> res02  : Int = 10
  
  val res04 = product(l4)                         //> res04  : Double = 24.0
  val resA4 = productAlt0(l4)                     //> resA4  : Double = 24.0
  //productAlt0(Nil) // correctly throws error
  val resB4 = productTR(l4)                       //> resB4  : Double = 24.0
  val resB5 = productTR(l5)                       //> resB5  : Double = 0.0
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
  val dwCur1 = dropWhileCur(l2)_                  //> dwCur1  : (String => Boolean) => books.funproginscala.ch3.MEM.List[String] =
                                                  //|  <function1>
  val res6c = dwCur1(x => x.length < 4)           //> res6c  : books.funproginscala.ch3.MEM.List[String] = Cons(apple,Cons(banana,
                                                  //| Cons(app,Nil)))
  def strLen4(x:String) = x.length < 4            //> strLen4: (x: String)Boolean
  val dwCurAlt = dropWhileCurAlt(strLen4)_        //> dwCurAlt  : books.funproginscala.ch3.MEM.List[String] => books.funproginscal
                                                  //| a.ch3.MEM.List[String] = <function1>
  val res6d = dwCurAlt(l2)                        //> res6d  : books.funproginscala.ch3.MEM.List[String] = Cons(apple,Cons(banana
                                                  //| ,Cons(app,Nil)))
  
  val dwCurAlt2 = dropWhileCurAlt((x:String) => x.length < 4)_
                                                  //> dwCurAlt2  : books.funproginscala.ch3.MEM.List[String] => books.funproginsc
                                                  //| ala.ch3.MEM.List[String] = <function1>
  
  val res6e = dwCurAlt2(l2)                       //> res6e  : books.funproginscala.ch3.MEM.List[String] = Cons(apple,Cons(banana
                                                  //| ,Cons(app,Nil)))
    
  val res9 = init(l1)                             //> res9  : books.funproginscala.ch3.MEM.List[Int] = Cons(1,Cons(2,Cons(3,Nil))
                                                  //| )
  val res10 = init(List(1))                       //> res10  : books.funproginscala.ch3.MEM.List[Int] = Nil
  //val res11 = init(List()) // correctly throws error
  val res12 = init(List(1,2))                     //> res12  : books.funproginscala.ch3.MEM.List[Int] = Cons(1,Nil)
  
  setHead("fee", List("foo", "fi", "fo", "fum"))  //> res0: books.funproginscala.ch3.MEM.List[String] = Cons(fee,Cons(fi,Cons(fo,
                                                  //| Cons(fum,Nil))))
  val res13 = sumAlt2(l1)                         //> res13  : Int = 10
  
  val res14 = sumAlt3(l1)                         //> res14  : Int = 10
  
  val res15 = prodAlt1(l4)                        //> res15  : Double = 24.0
  
  val res16 = prodAlt1(l5)                        //> res16  : Double = 0.0
  
  val res17 = prodAlt2(l4)                        //> res17  : Double = 24.0
  
  val res18 = append(l2, l6)                      //> res18  : books.funproginscala.ch3.MEM.List[String] = Cons(ape,Cons(apple,Co
                                                  //| ns(banana,Cons(app,Cons(Zebra,Cons(Zygote,Nil))))))
  
  val res19 = appendViaFR(l2, l6)                 //> res19  : books.funproginscala.ch3.MEM.List[String] = Cons(app,Cons(banana,C
                                                  //| ons(apple,Cons(ape,Cons(Zebra,Cons(Zygote,Nil))))))
  val res20 = appendViaFR(List(), l6)             //> res20  : books.funproginscala.ch3.MEM.List[String] = Cons(Zebra,Cons(Zygote
                                                  //| ,Nil))
  '''                                             //> res1: Char('\'') = '
}
/*



*/