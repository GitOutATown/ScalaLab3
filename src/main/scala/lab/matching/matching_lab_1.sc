package lab.matching

object matching_lab_1 {

	val myMap = Map("a" -> 42, "b" -> 43, "h" -> 56) //> myMap  : scala.collection.immutable.Map[String,Int] = Map(a -> 42, b -> 43)
	
	def getMapValue(s: String): String = {
	  myMap get s match {
	    case Some(v) => "Value found: " + v
	    case None => "No value found"
	  }
	}                                         //> getMapValue: (s: String)String
	
	getMapValue("a")                          //> res0: String = Value found: 42
	getMapValue("c")                          //> res1: String = No value found
	
	def getMapValue2(s: String): String =
  		myMap.get(s).map("Value found: " + _)
  		.getOrElse("No value found")      //> getMapValue2: (s: String)String
	
	getMapValue2("b")                         //> res2: String = Value found: 43
	getMapValue("e")                          //> res3: String = No value found
	
	val pairs: List[(Char, Int)] = ('a', 2) :: ('b', 3) :: Nil
                                                  //> pairs  : List[(Char, Int)] = List((a,2), (b,3))
	pairs map { case (ch, i) => ch }          //> res4: List[Char] = List(a, b)
	
	pairs map { pair =>
		println("pair: " + pair)
		pair match { case (ch, i) => ch } //> pair: (a,2)
                                                  //| pair: (b,3)
                                                  //| res5: List[Char] = List(a, b)
	}
	
	
	
	'''                                       //> res6: Char('\'') = '
}