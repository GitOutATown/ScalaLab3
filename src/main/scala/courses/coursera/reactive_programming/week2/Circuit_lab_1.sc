package courses.coursera.reactive_programming.week2

object Circuit_lab_1 {
	
	// !
	def inverter(in: Boolean) = !in           //> inverter: (in: Boolean)Boolean
	// &&
	def andGate(in1: Boolean, in2: Boolean) = in1 && in2
                                                  //> andGate: (in1: Boolean, in2: Boolean)Boolean
  // ||
  def orGate(in1: Boolean, in2: Boolean) = in1 || in2
                                                  //> orGate: (in1: Boolean, in2: Boolean)Boolean
  // a != b // i.e. result is true whenever a and b are not equal.
  def f(a: Boolean, b: Boolean) = {
  		val d = inverter(a)
  		val e = inverter(b)
  		val f = andGate(a, e)
  		val g = andGate(b, d)
  		val c = orGate(f, g)
  		c
  }                                               //> f: (a: Boolean, b: Boolean)Boolean
  
  // ----------------------- //
  
  val c1 = f(true, true)                          //> c1  : Boolean = false
  val c2 = f(true, false)                         //> c2  : Boolean = true
  val c3 = f(false, false)                        //> c3  : Boolean = false
  val c4 = f(false, true)                         //> c4  : Boolean = true
}
/*



*/