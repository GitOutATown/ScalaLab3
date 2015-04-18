package lab.collections

object for_comprehension_lab_1 {

	// list all combinations of numbers x and y where x is drawn from
	// 1 to M and y is drawn from 1 to N
	
	val M = 5                                 //> M  : Int = 5
	val N = 15                                //> N  : Int = 15
	
	for {
		x <- 1 to M // flatMap
		y <- 11 to N // map
	} yield (x,y)                             //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,11), (1,
                                                  //| 12), (1,13), (1,14), (1,15), (2,11), (2,12), (2,13), (2,14), (2,15), (3,11),
                                                  //|  (3,12), (3,13), (3,14), (3,15), (4,11), (4,12), (4,13), (4,14), (4,15), (5,
                                                  //| 11), (5,12), (5,13), (5,14), (5,15))
	  
	//is equivalent to
	
	(1 to M) flatMap (x => (11 to N) map (y => (x, y)))
                                                  //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,11), (1,
                                                  //| 12), (1,13), (1,14), (1,15), (2,11), (2,12), (2,13), (2,14), (2,15), (3,11),
                                                  //|  (3,12), (3,13), (3,14), (3,15), (4,11), (4,12), (4,13), (4,14), (4,15), (5,
                                                  //| 11), (5,12), (5,13), (5,14), (5,15))
	
	// ------------------------ //
	
	val e1 = List(1,2,3,4)                    //> e1  : List[Int] = List(1, 2, 3, 4)
	
  for (x <- e1) yield ( x * 2)                    //> res2: List[Int] = List(2, 4, 6, 8)
  
  // is translated to
  
  e1.map(x => x * 2)                              //> res3: List[Int] = List(2, 4, 6, 8)
  
  // ----------------------- //
  
  for (x <- e1 if x % 2 == 0) yield x + 1         //> res4: List[Int] = List(3, 5)
  
  // is translated to
  
  for (x <- e1.filter(x => x % 2 == 0)) yield x + 1
                                                  //> res5: List[Int] = List(3, 5)
  
  // But, really, check this. The filtering could not be done on the generator.
  
  for{
  		m <- 11 to 15 // flatMap
  		n <- 1 to 5 // map
  		if m % n == 0
  } yield n                                       //> res6: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 1, 2, 3, 4, 1, 
                                                  //| 1, 2, 1, 3, 5)
  
  // And the above could be translated to
  
  (11 to 15).flatMap(m =>
  		for (
  			n <- 1 to 5
  			if m % n == 0
  		) yield n
  	)                                         //> res7: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 1, 2, 3, 4, 1, 
                                                  //| 1, 2, 1, 3, 5)
  	
  // And is also equivalent to
	
	(11 to 15).flatMap(m =>
		(1 to 5).filter(n =>
		m % n == 0)).map(n => n)          //> res8: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 1, 2, 3, 4, 1,
                                                  //|  1, 2, 1, 3, 5)

}
/*














*/