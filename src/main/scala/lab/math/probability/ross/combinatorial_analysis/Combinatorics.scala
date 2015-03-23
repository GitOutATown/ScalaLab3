package lab.math.probability.ross.combinatorial_analysis

object Combinatorics {
	
  def fac(n: Int): Int = {
	    if (n < 0) throw new IllegalArgumentException("Input must be greater than 0")
	    val orig = n // diagnostic
	    def recurse(n: Int, prod: Int): Int = {
	        if (n <= 1) {
	            println("fac(" + orig + "): " + prod)
	            prod // return result
	        }
	        else recurse(n-1, n*prod) // tail recursion
	    }
	    recurse(n, 1)
	}
}