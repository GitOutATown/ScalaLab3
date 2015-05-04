package lab.functions

object function_lab_1 {

	def foo = 1                               //> foo: => Int
	
	def bar1(f: => Int) = f                   //> bar1: (f: => Int)Int
	
	def bar2(f: Int) = f                      //> bar2: (f: Int)Int
	
	bar1(foo)                                 //> res0: Int = 1
	bar2(foo)                                 //> res1: Int = 1
	
	'''                                       //> res2: Char('\'') = '
}