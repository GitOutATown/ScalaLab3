package lab.math.probability.ross.combinatorial_analysis

object Combinatorics {
	
  // factorial, recursive
  // Naive implementation. 
  // For large numbers see http://en.wikipedia.org/wiki/Binomial_coefficient#Binomial_coefficient_in_programming_languages
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
  
  	// recursive
    // See p. 90 Schaum Discrete Mathematics
    def binomialCoeficients(n: Int, r: Int): Double = {
        def inner(n: Int, r: Int, n_acc: Int, r_acc: Int): Double = {
	        if (r >= 1) {
	            val new_n_acc = n_acc * n
	            val new_r_acc = r_acc * r
	            inner(n-1, r-1, new_n_acc, new_r_acc)
	        }
	        
	        else {
	            n_acc.toDouble / r_acc.toDouble
	        }
        }
        inner(n, r, 1, 1)
    } // end binomialCoeficients
}



