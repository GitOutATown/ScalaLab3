package lab.composition

object fun_comp_1 {

	// Curryable
	def f1(a: Int)(b: Int): Int = {
		a + b
	}                                         //> f1: (a: Int)(b: Int)Int
	
	def f2(a: Int, b: Int): Int = {
		a + b
	}                                         //> f2: (a: Int, b: Int)Int
	
	val addTo3 = f1(3)_                       //> addTo3  : Int => Int = <function1>
	addTo3(2)                                 //> res0: Int = 5
	
	// val addTo4 = f2(4)_ // Not curryable
}