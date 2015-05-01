package lab.by_name

object ByName_lab_2 {

	/* http://stackoverflow.com/questions/13337338/call-by-name-vs-call-by-value-in-scala-clarification-needed
	 * Call-by-value functions compute the passed-in expression's value
	 * before calling the function, thus the same value is accessed every
	 * time. However, call-by-name functions recompute the passed-in
	 * expression's value every time it is accessed.
	 * RW: I read a comment that said "call by name" should be called
	 * "call by reference" and I would agree that it's more accurate.
	 */

	def something = {
		println("In something")
		1
	}                                         //> something: => Int
	
	def callByValue(x: Int) = {
		println("x1: " + x)
		println("x2: " + x)
	}                                         //> callByValue: (x: Int)Unit
	
	def callByName(x: => Int) = {
		println("x1: " + x)
		println("x2: " + x)
	}                                         //> callByName: (x: => Int)Unit
	
	callByValue(something)                    //> In something
                                                  //| x1: 1
                                                  //| x2: 1
	callByName(something)                     //> In something
                                                  //| x1: 1
                                                  //| In something
                                                  //| x2: 1
	
	'''                                       //> res0: Char('\'') = '
}