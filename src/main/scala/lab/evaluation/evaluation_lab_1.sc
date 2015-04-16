package lab.evaluation

object evaluation_lab_1 {
	val res = 1 == 3                          //> res  : Boolean = false
	
	// Call by value: evaluates the function arguments before calling the function
	// Call by name: evaluates the function first, and then evaluates the arguments if need be
	
	val ex1: Int = {
		println("I'm only evaluated once when I'm first initiated")
		1
	}                                         //> I'm only evaluated once when I'm first initiated
                                                  //| ex1  : Int = 1
	ex1                                       //> res0: Int = 1
	ex1                                       //> res1: Int = 1
	
	def ex2: Int = {
		println("I'm evaluated everytime I'm called, but non when I'm declared.")
		2
	}                                         //> ex2: => Int
	
	ex2                                       //> I'm evaluated everytime I'm called, but non when I'm declared.
                                                  //| res2: Int = 2
  ex2                                             //> I'm evaluated everytime I'm called, but non when I'm declared.
                                                  //| res3: Int = 2
  
  def square1(x: Double) = {
  		println("square1 TOP")
  		val res = x * x
  		println("square1 res: " + res)
  		res
  }                                               //> square1: (x: Double)Double
  
  square1(3)                                      //> square1 TOP
                                                  //| square1 res: 9.0
                                                  //| res4: Double = 9.0
  
  def square2(x: => Double) = {
  		println("square2 TOP")
  		val res = x
  		println("square2 res: " + res)
  		res
  }                                               //> square2: (x: => Double)Double
  
  square2(square1(3))                             //> square2 TOP
                                                  //| square1 TOP
                                                  //| square1 res: 9.0
                                                  //| square2 res: 9.0
                                                  //| res5: Double = 9.0
  
  def funcMulti(bindings: Int*) = {
  		bindings.sum
  }                                               //> funcMulti: (bindings: Int*)Int
  
  funcMulti(1,2,3,4)                              //> res6: Int = 10
}