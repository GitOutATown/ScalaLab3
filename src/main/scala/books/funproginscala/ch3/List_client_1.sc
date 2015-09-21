package books.funproginscala.ch3

object List_client_1 {
  import books.funproginscala.ch3.List._
  
  val l1 = List(1,2,3,4)                          //> l1  : books.funproginscala.ch3.List[Int] = Cons(1,Cons(2,Cons(3,Cons(4,Nil))
                                                  //| ))
  val l2 = List("ape", "apple", "banana", "app")  //> l2  : books.funproginscala.ch3.List[String] = Cons(ape,Cons(apple,Cons(banan
                                                  //| a,Cons(app,Nil))))
  val l3 = List(5, 6, 7)                          //> l3  : books.funproginscala.ch3.List[Int] = Cons(5,Cons(6,Cons(7,Nil)))
 
  val l4 = List(1d,2,3,4)                         //> l4  : books.funproginscala.ch3.List[Double] = Cons(1.0,Cons(2.0,Cons(3.0,Con
                                                  //| s(4.0,Nil))))
  
  val l5 = Cons(0d, l4)                           //> l5  : books.funproginscala.ch3.Cons[Double] = Cons(0.0,Cons(1.0,Cons(2.0,Con
                                                  //| s(3.0,Cons(4.0,Nil)))))
  val res01 = List.sum(l1)                        //> res01  : Int = 10
  val res02 = List.sumAlt1(l1)                    //> res02  : Int = 10
  val res03 = List.sumAlt2(l1)                    //> res03  : Int = 10
  val resA3 = List.sumAlt3(l1)                    //> resA3  : Int = 10
  val resA4 = List.sumAlt4(l1)                    //> resA4  : Int = 10
  val resA5 = List.sumAlt5(l1)                    //> resA5  : Int = 10
  
  val res04 = List.product(l4)                    //> res04  : Double = 24.0
  val res05 = List.prodAlt1(l4)                   //> res05  : Double = 24.0
  val res06 = List.prodAlt1(Nil)                  //> res06  : Double = 1.0
  val res07 = List.prodAlt1(l5)                   //> res07  : Double = 0.0
  val res08 = List.prodAlt2(l5)                   //> res08  : Double = 0.0
  val res09 = List.prodAlt2(l4)                   //> res09  : Double = 24.0
  val resA1 = List.prodAlt3(l4)                   //> resA1  : Double = 24.0
  val resA2 = List.prodAlt4(l4)                   //> resA2  : Double = 24.0
  
  val res011 = List.tail(l1)                      //> res011  : books.funproginscala.ch3.List[Int] = Cons(2,Cons(3,Cons(4,Nil)))
  //List.tail(List()) // correctly throws error
  List.setHead("fee", List("foo", "fi", "fo", "fum"))
                                                  //> res0: books.funproginscala.ch3.List[String] = Cons(fee,Cons(fi,Cons(fo,Cons(
                                                  //| fum,Nil))))
  //List.setHead("fee", List()) // correctly throws error
  val res0 = List.drop(l1, 0)                     //> res0  : books.funproginscala.ch3.List[Int] = Cons(1,Cons(2,Cons(3,Cons(4,Nil
                                                  //| ))))
  
  val res1 = List.drop(l1, 1)                     //> res1  : books.funproginscala.ch3.List[Int] = Cons(2,Cons(3,Cons(4,Nil)))
  val res2 = List.drop(l1, 2)                     //> res2  : books.funproginscala.ch3.List[Int] = Cons(3,Cons(4,Nil))
  val res3 = List.drop(l1, 3)                     //> res3  : books.funproginscala.ch3.List[Int] = Cons(4,Nil)
  val res4 = List.drop(l1, 4)                     //> res4  : books.funproginscala.ch3.List[Int] = Nil
 
  val res5 = List.drop(l1, 5)                     //> res5  : books.funproginscala.ch3.List[Int] = Nil
  
  val res6a = List.dropWhile(l2, (x:String) => x.length < 4)
                                                  //> res6a  : books.funproginscala.ch3.List[String] = Cons(apple,Cons(banana,Con
                                                  //| s(app,Nil)))
  // curried
  val res6b = List.dropWhileAlt(l2) (x => x.length < 4)
                                                  //> res6b  : books.funproginscala.ch3.List[String] = Cons(apple,Cons(banana,Con
                                                  //| s(app,Nil)))
  val res7 = List.dropWhile(l2, (x:String) => x.startsWith("a"))
                                                  //> res7  : books.funproginscala.ch3.List[String] = Cons(banana,Cons(app,Nil))
  val res8 = List.append(l1, l3)                  //> res8  : books.funproginscala.ch3.List[Int] = Cons(1,Cons(2,Cons(3,Cons(4,Co
                                                  //| ns(5,Cons(6,Cons(7,Nil)))))))
  val res9 = List.init(l1)                        //> res9  : books.funproginscala.ch3.List[Int] = Cons(1,Cons(2,Cons(3,Nil)))
  val res10 = List.init(List(1))                  //> res10  : books.funproginscala.ch3.List[Int] = Nil
  //val res11 = List.init(List()) // correctly throws error
  val res12 = List.init(List(1,2))                //> res12  : books.funproginscala.ch3.List[Int] = Cons(1,Nil)
  
  val res13 = List.initAlt(l1)                    //> res13  : books.funproginscala.ch3.List[Int] = Cons(1,Cons(2,Cons(3,Nil)))
  val res14 = List.initAlt(List(1))               //> res14  : books.funproginscala.ch3.List[Int] = Nil
  val res15 = List.initAlt(List(1,2))             //> res15  : books.funproginscala.ch3.List[Int] = Cons(1,Nil)
  val res16 = foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_))
                                                  //> res16  : books.funproginscala.ch3.List[Int] = Cons(1,Cons(2,Cons(3,Nil)))
  val res17 = List.length(l2)                     //> res17  : Int = 4
  val res18 = List.length(l5)                     //> res18  : Int = 5
  
  val res19 = List.lengthFL(l2)                   //> res19  : Int = 4
  val res20 = List.lengthFL(l5)                   //> res20  : Int = 5
  
  val res21 = List.reverse(l5)                    //> res21  : books.funproginscala.ch3.List[Double] = Cons(4.0,Cons(3.0,Cons(2.0
                                                  //| ,Cons(1.0,Cons(0.0,Nil)))))
  val res22 = List.reverse(l2)                    //> res22  : books.funproginscala.ch3.List[String] = Cons(app,Cons(banana,Cons(
                                                  //| apple,Cons(ape,Nil))))
  
  val res23 = List.reverseFR(l5)                  //> res23  : books.funproginscala.ch3.List[Double] = Cons(4.0,Cons(3.0,Cons(2.0
                                                  //| ,Cons(1.0,Cons(0.0,Nil)))))
  //NOT WORKING CORRECTLY
  val res24 = List.reverseFLViaFR(l5)             //> res24  : books.funproginscala.ch3.List[Double] = Cons(0.0,Cons(1.0,Cons(2.0
                                                  //| ,Cons(3.0,Cons(4.0,Nil)))))
  // Interesting! This does work, but the FR is not TR.
  // That's the difference from res24 = reverseFLViaFR above,
  // where the FR is TR and it doesn't work!
  val res25 = List.reverseFLViaFR2(l5)            //> res25  : books.funproginscala.ch3.List[Double] = Cons(4.0,Cons(3.0,Cons(2.0
                                                  //| ,Cons(1.0,Cons(0.0,Nil)))))
  '''                                             //> res1: Char('\'') = '
}
/*






*/