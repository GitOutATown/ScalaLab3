package courses.coursera.reactive_programming.week1

object FunctionParameterization_1 {

	val f1: String => String = {
		case "ping" => "pong"
		case _ => "Blaaargh!"
	}                                         //> f1  : String => String = <function1>
	
	f1("ping")                                //> res0: String = pong
	//f1("huh").isDefined
	
	val f2: PartialFunction[String, String] = {case "ping" => "pong"}
                                                  //> f2  : PartialFunction[String,String] = <function1>
	
	f2.isDefinedAt("ping")                    //> res1: Boolean = true
	f2.isDefinedAt("huh")                     //> res2: Boolean = false
	
	val f3: PartialFunction[List[Int], String] = {
		case Nil => "one"
		case x :: y :: rest => "two"
	}                                         //> f3  : PartialFunction[List[Int],String] = <function1>
	
	f3.isDefinedAt(List())                    //> res3: Boolean = true
	f3.isDefinedAt(List(1))                   //> res4: Boolean = false
	f3.isDefinedAt(List(1,2))                 //> res5: Boolean = true
	f3.isDefinedAt(List(1,2,3))               //> res6: Boolean = true
	f3.isDefinedAt(List(1,2,3,4))             //> res7: Boolean = true
	
	val f4: PartialFunction[List[Int], String] = {
		case Nil => "<1> Nil"
		case x :: y :: rest => "<2> " + x + "::" + y + "::" + rest
		case x :: xs => "<3> " + x + "::" + xs
	}                                         //> f4  : PartialFunction[List[Int],String] = <function1>
	
	f4(List())                                //> res8: String = <1> Nil
	f4(List(1,2,3,4))                         //> res9: String = <2> 1::2::List(3, 4)
	f4(List(1,2))                             //> res10: String = <2> 1::2::List()
	f4(List(1))                               //> res11: String = <3> 1::List()
}
/*



*/