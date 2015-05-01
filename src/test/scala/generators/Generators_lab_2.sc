package generators

object Generators_lab_2 {
	
	val list1 = List(1,2,3)                   //> list1  : List[Int] = List(1, 2, 3)
  val list2 = List('a', 'b', 'c')                 //> list2  : List[Char] = List(a, b, c)
  
  // --------------------- //
  
  for { // map
    n <- list1 // map
  } yield n                                       //> res0: List[Int] = List(1, 2, 3)
  
  // same as
  list1.map(n => n)                               //> res1: List[Int] = List(1, 2, 3)
  
  // compare with
  for( // foreach
      i <- list1 // foreach
  ) println(i)                                    //> 1
                                                  //| 2
                                                  //| 3
  // --------------------- //
  
  for { // flatMap
    num <- list1 // flatMap
    alpha <- list2 // map
  } yield (num, alpha)                            //> res2: List[(Int, Char)] = List((1,a), (1,b), (1,c), (2,a), (2,b), (2,c), (3,
                                                  //| a), (3,b), (3,c))
  // same as
  list1.flatMap(num => list2.map(alpha => (num, alpha)))
                                                  //> res3: List[(Int, Char)] = List((1,a), (1,b), (1,c), (2,a), (2,b), (2,c), (3,
                                                  //| a), (3,b), (3,c))
  // compare with
  list1.map(num => list2.map(alpha => (num, alpha)))
                                                  //> res4: List[List[(Int, Char)]] = List(List((1,a), (1,b), (1,c)), List((2,a), 
                                                  //| (2,b), (2,c)), List((3,a), (3,b), (3,c)))
  
  
  
}
/*






*/