package lab.by_name

object ByName_lab_1 {

	def WHILE(condition: => Boolean)(command: => Unit): Unit = {
		if(condition) {
			command
			WHILE(condition)(command)
		}
		else ()
	}                                         //> WHILE: (condition: => Boolean)(command: => Unit)Unit
	
	def cond(exp: Int): Boolean = {
		exp != 0
	}                                         //> cond: (exp: Int)Boolean
	
	def comd(base: Int, exp: Int): Unit = {
		
	}                                         //> comd: (base: Int, exp: Int)Unit
	//WHILE()()
	'''                                       //> res0: Char('\'') = '
}