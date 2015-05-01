package courses.coursera.reactive_programming.week2

object Test_lab_1 extends App {

	def huh = () => 3
	val v = new Var(huh())
  	println("v: " + v())
  	
  	val foo = Var(3)
  	println("foo: " + foo())
  	
  	// ------------------------- //
  	
  	val num = Var(1)
  	val twice = Signal(num() * 2)
  	twice()
  	num() = 2
  	twice()
}