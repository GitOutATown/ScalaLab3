package courses.coursera.reactive_programming.week1
import math._
object priority_queue_lab_1 {

	def log2(x: Double) = log(x)/log(2)       //> log2: (x: Double)Double
	
	// A binomial queue of size n contains at most log2(n + 1)c trees.
	// Optimal Purely Functional Priority Queues.pdf
	
	// The binary representation of 21 is 10101, and the binomial queue
	// contains trees of ranks 0, 2, and 4 (of sizes 1, 4, and 16, respectively).
	floor(log2(21 + 1))                       //> res0: Double = 4.0
	
}