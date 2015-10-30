package lab.types.caseclass

object CaseClass1 extends App {

    abstract class Term
    case class Var(name: String) extends Term
    case class Fun(arg: String, body: Term) extends Term
    case class App(f: Term, v: Term) extends Term
    
    val t1: Term = Var("t1")
    val t2: Term = Fun("t2", t1)
    val t3: Term = App(t1, t2)
    
    val list = List(t1, t2, t3)
    
    list foreach { _ match {
        case t: Var => {
            val varAltName = t.copy(name = t.name + "Alt")
            println("Got Var, new name is " + varAltName.name)
        }
        case t: Fun => println("Got Fun")
        case t: App => println("Got App")
        case t: Term => println("Got Term")
    }}
         
}