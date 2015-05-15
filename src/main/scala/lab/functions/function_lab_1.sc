package lab.functions

object function_lab_1 {

	def foo = 1                               //> foo: => Int
	
	// I'm not able to detect any behavioral difference between bar1 and bar2
	def bar1(f: => Int) = f                   //> bar1: (f: => Int)Int
	def bar2(f: Int) = f                      //> bar2: (f: Int)Int
	
	bar1(foo)                                 //> res0: Int = 1
	bar2(foo)                                 //> res1: Int = 1
	bar2(1)                                   //> res2: Int = 1
	bar1(1)                                   //> res3: Int = 1
	
	def func1(in1: Int)(in2:Int) = {
    in1 + in2
	}                                         //> func1: (in1: Int)(in2: Int)Int
	val partFunc1 = func1(3)_                 //> partFunc1  : Int => Int = <function1>
	
	bar2(partFunc1(2))                        //> res4: Int = 5
	bar1(partFunc1(2))                        //> res5: Int = 5
	//bar1(partFunc1) // type mismatch;  found   : Int => Int  required: Int
	
	def func2 = (x: Int) => x                 //> func2: => Int => Int
	bar1(func2(2))                            //> res6: Int = 2
	'''                                       //> res7: Char('\'') = '
}