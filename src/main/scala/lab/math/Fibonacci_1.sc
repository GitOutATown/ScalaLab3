package lab.math

object Fibonacci_1 {
	
	// fib value: 0,1,1,2,3,5,8,13,21,34,...
	// index:     0,1,2,3,4,5,6,7 ,8, 9 ,...
	/* Uses recursion, but not on the stack (i.e. tail recursion).
	 * Why it matters: fib(500) with stack recursion hangs on my
	 * Macbook with 16 gig memory. This non-stack version returns
	 * fib(500) instantly.
	 */
	def fib(n: Int): Int = {
		def inter(index: Int, fibValPrev: Int, fibVal: Int): Int = {
			if(index <= n) inter(index+1, fibVal, fibValPrev + fibVal)
			else fibVal
		}
		if(n == 0) 0
		else if(n == 1) 1
		else inter(2, 0, 1)
	}                                         //> fib: (n: Int)Int
	
	fib(0)                                    //> res0: Int = 0
	fib(1)                                    //> res1: Int = 1
	fib(2)                                    //> res2: Int = 1
  fib(3)                                          //> res3: Int = 2
  fib(4)                                          //> res4: Int = 3
  fib(5)                                          //> res5: Int = 5
	fib(6)                                    //> res6: Int = 8
	fib(7)                                    //> res7: Int = 13
	fib(25)                                   //> res8: Int = 75025
	fib(500)                                  //> res9: Int = 315178285
}