package lab.collections

object Map_lab_1 {

	val myMap = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> myMap  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -> 5, X -
                                                  //| > 10)
	myMap("I")                                //> res0: Int = 1
	// myMap("A")      // => java.util.NoSuchElementException
	myMap get "A"                             //> res1: Option[Int] = None
	myMap get "I"                             //> res2: Option[Int] = Some(1)
	if(myMap get "A" isDefined) myMap get "A" //> res3: Any = ()
	val myMap2 = myMap updated("V", 15)       //> myMap2  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -> 15, 
                                                  //| X -> 10)
	val myMap3 = myMap2 updated("R", 42)      //> myMap3  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -> 15, 
                                                  //| X -> 10, R -> 42)
	// filter out member
	for{
		(k, v) <- myMap
		if k != "V"
	} yield (k -> v)                          //> res4: scala.collection.immutable.Map[String,Int] = Map(I -> 1, X -> 10)
	
	'''                                       //> res5: Char('\'') = '
}