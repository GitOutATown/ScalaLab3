package typesystem.parameterization

object Parameterization_lab_1 {

	'a'.toInt                                 //> res0: Int = 97
	
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
	
	val stack = new Stack[Int]                //> stack  : typesystem.parameterization.Parameterization_lab_1.Stack[Int] = Lis
                                                  //| t()
	stack push(1)
	stack push('a') // implicit conversion
	stack push(3)
	stack push(4)
	stack.peek                                //> res1: Option[Int] = Some(4)
	stack                                     //> res2: typesystem.parameterization.Parameterization_lab_1.Stack[Int] = List(4
                                                  //| , 3, 97, 1)
	stack.pop
	stack                                     //> res3: typesystem.parameterization.Parameterization_lab_1.Stack[Int] = List(3
                                                  //| , 97, 1)
	stack.top                                 //> res4: Int = 3
	if (stack.peek.isDefined) stack.top       //> res5: AnyVal = 97
	stack.top                                 //> res6: Int = 1
	//stack.top // NoSuchElementException
	if(stack.peek.isDefined) stack.top        //> res7: AnyVal = ()
}
/*




*/