package lab.traits

trait Foo {
	def f = "bar"
}

object traits_lab_1 extends Foo {
	
	f                                         //> res0: String = bar
	
	'''                                       //> res1: Char('\'') = '
}