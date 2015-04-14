package courses.coursera.reactive_programming.week1

object JsonRepresentation_1 {
	
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
                                                  //| 1.JSON)String
	
	// ------------------------ //
	
	val data = JObj(Map(
		"firstName" -> JStr("John"),
		"lastName" -> JStr("Smith"),
		"address" -> JObj(Map(
			"streetAddress" -> JStr("128 Maple Ln."),
			"city" -> JStr("Detroit"),
			"state" -> JStr("MI"),
			"postal" -> JStr("55320")
		)),
		"phoneNumbers" -> JSeq(List(
			JObj(Map("type" -> JStr("home"), "number" -> JStr("408-231-7863"))),
			JObj(Map("type" -> JStr("work"), "number" -> JStr("415-333-4567")))
		))
	))                                        //> data  : courses.coursera.reactive_programming.week1.JsonRepresentation_1.JO
                                                  //| bj = JObj(Map(firstName -> JStr(John), lastName -> JStr(Smith), address -> 
                                                  //| JObj(Map(streetAddress -> JStr(128 Maple Ln.), city -> JStr(Detroit), state
                                                  //|  -> JStr(MI), postal -> JStr(55320))), phoneNumbers -> JSeq(List(JObj(Map(t
                                                  //| ype -> JStr(home), number -> JStr(408-231-7863))), JObj(Map(type -> JStr(wo
                                                  //| rk), number -> JStr(415-333-4567)))))))
	
	show(data)                                //> res0: String = {"firstName": "John", "lastName": "Smith", "address": {"stre
                                                  //| etAddress": "128 Maple Ln.", "city": "Detroit", "state": "MI", "postal": "5
                                                  //| 5320"}, "phoneNumbers": [{"type": "home", "number": "408-231-7863"}, {"type
                                                  //| ": "work", "number": "415-333-4567"}]}
}