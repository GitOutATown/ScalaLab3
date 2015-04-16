package courses.coursera.reactive_programming.week1

object JsonRepresentation_2 {
	// Recursive structure (i.e. JSeq, JObj)
	abstract class JSON
	case class JSeq(elems: List[JSON]) extends JSON
	case class JObj(bindings: Map[String, JSON]) extends JSON
	case class JNum(num: Double) extends JSON
	case class JStr(str: String) extends JSON
	case class JBool(b: Boolean) extends JSON
	case class JNull extends JSON
	
	// ------------------------ //
	
	// Recursive function for processing JSON values
	def show(json: JSON): String = json match {
		case JSeq(elems) => "[" + (elems map show mkString ", ") + "]"
		case JObj(bindings) =>
			val assocs = bindings map {
				case (key, value) => '\"' + key + "\": " + show(value)
			}
			"{" + (assocs mkString ", ") + "}"
		case JStr(str) => '\"' + str + '\"'
		case JNum(num) => num.toString
		case JBool(b) => b.toString
		case JNull() => "null"
	}                                         //> show: (json: courses.coursera.reactive_programming.week1.JsonRepresentation_
                                                  //| 2.JSON)String
	
	// -------------------------- //
	
	val heteroSeq = JSeq(List(
		JNum(55),
		JStr("huh"),
		JBool(true),
		JObj(Map("foo" -> JStr("bar")))
	))                                        //> heteroSeq  : courses.coursera.reactive_programming.week1.JsonRepresentation
                                                  //| _2.JSeq = JSeq(List(JNum(55.0), JStr(huh), JBool(true), JObj(Map(foo -> JSt
                                                  //| r(bar)))))
  show(heteroSeq)                                 //> res0: String = [55.0, "huh", true, {"foo": "bar"}]
}