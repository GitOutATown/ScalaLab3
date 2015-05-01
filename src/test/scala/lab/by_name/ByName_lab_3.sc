package lab.by_name

object ByName_lab_3 {

	def func(x: => Boolean)(command: => Unit) {
	
	}                                         //> func: (x: => Boolean)(command: => Unit)Unit
	
	def equalsZero(x: Int) = true             //> equalsZero: (x: Int)Boolean
	def command = {                           //> command: => Unit
		
		()
	}
	
	func(equalsZero(3))(command)
	
	'''                                       //> res0: Char('\'') = '
}