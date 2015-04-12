package lab.math

object fibonacci_2 {
	def fib(n: Int): Int = if (n<=1) n else fib(n-1) + fib(n-2)
                                                  //> fib: (n: Int)Int
  fib(6)                                          //> res0: Int = 8
  // fib(500) // Hangs. See fibonacci_1 using tail recursion
}