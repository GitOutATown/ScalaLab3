package lab.typesystem.parameterization

class Stack[T] {
	var elems: List[T] = Nil
	def push(x: T) { elems = x :: elems }
	def peek: Option[T] = {
		elems match {
			case Nil => None
			case x :: xs => Some(x)
		}
	}
	def pop() { elems = elems.tail }
	def top(): T = {
		val x = elems.head
		pop
		x
	}
	override def toString = s"$elems"
}