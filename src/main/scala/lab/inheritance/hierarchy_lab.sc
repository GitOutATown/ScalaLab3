package lab.inheritance

object hierarchy_lab {

	abstract class TopLevel {     // abstract class
	  def method1(x: Int): Int   // abstract method
	  def method2(x: Int): Int = { x }
	}
	
	object MyObject extends TopLevel {
		def method1(x: Int): Int = {
			x
		}
	}
	
	object MyObject2 extends TopLevel {
		def method1(x: Int): Int = {
			x
		}
	}
	
	MyObject.method1(3)                       //> res0: Int = 3
	MyObject2.method1(4)                      //> res1: Int = 4
}