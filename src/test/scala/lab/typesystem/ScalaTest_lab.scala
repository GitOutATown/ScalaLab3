package lab.typesystem

import org.scalatest._
import lab.typesystem.parameterization.Stack

object ScalaTest_lab extends FlatSpec with Matchers {
  
	"A Stack" should "pop values in last-in-first-out order" in {
		val stack = new Stack[Int]
		stack.push(1)
		stack.push(2)
		stack.top should be (2)
		stack.top should be (1)
	}
	
	it should "throw NoSuchElementException if an empty stack is popped" in {
	    val emptyStack = new Stack[Int]
	    a [NoSuchElementException] should be thrownBy {
	    		emptyStack.pop()
	    } 
	}
	
	it should "return None if an empty stack is peeked" in {
		val emptyStack = new Stack[Int]
		emptyStack.peek should be (None)
	}
	
}