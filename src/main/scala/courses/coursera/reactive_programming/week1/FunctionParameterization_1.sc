package courses.coursera.reactive_programming.week1

object FunctionParameterization_1 {

	val f1: String => String = {
		case "ping" => "pong"
		case _ => "Blaaargh!"
	}                                         //> f1  : String => String = <function1>
	
	f1("ping")                                //> res0: String = pong
	f1("pong")                                //> res1: String = Blaaargh!
	//f1("huh").isDefined // isDefined not a member of String. Belongs to PartialFunction.
	
	val f2: PartialFunction[String, String] = { case "ping" => "pong" }
                                                  //> f2  : PartialFunction[String,String] = <function1>
	if(f2.isDefinedAt("ping")) f2("ping")     //> res2: Any = pong
	// f2("pong") // MatchError
	if(f2.isDefinedAt("huh")) f2("huh")       //> res3: Any = ()
	
	val f3: PartialFunction[List[Int], String] = {
		case Nil => "one"
		case x :: y :: rest => "two"
	}                                         //> f3  : PartialFunction[List[Int],String] = <function1>
	
	f3.isDefinedAt(List())                    //> res4: Boolean = true
	f3.isDefinedAt(List(1))                   //> res5: Boolean = false
	f3.isDefinedAt(List(1,2))                 //> res6: Boolean = true
	f3.isDefinedAt(List(1,2,3))               //> res7: Boolean = true
	f3.isDefinedAt(List(1,2,3,4))             //> res8: Boolean = true
	
	val f4: PartialFunction[List[Int], String] = {
		case Nil => "<1> Nil"
		case x :: y :: rest => "<3> " + x + "::" + y + "::" + rest
		case x :: xs => "<2> " + x + "::" + xs
	}                                         //> f4  : PartialFunction[List[Int],String] = <function1>
	
	f4(List())                                //> res9: String = <1> Nil
	f4(List(1))                               //> res10: String = <2> 1::List()
	f4(List(1,2))                             //> res11: String = <3> 1::2::List()
	f4(List(1,2,3))                           //> res12: String = <3> 1::2::List(3)
	f4(List(1,2,3,4))                         //> res13: String = <3> 1::2::List(3, 4)
}
/*



*/