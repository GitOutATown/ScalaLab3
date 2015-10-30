package lab.types.caseclass

object CaseClass1 extends App {

    abstract class Term
    case class Var(name: String) extends Term
    case class Fun(arg: String, body: Term) extends Term
    case class App(f: Term, v: Term) extends Term
    
    val t1: Term = Var("t1")
    val t2: Term = Fun("t2", t1)
    val t3: Term = App(t1, t2)
    val t4: Term = Var("t4")
    
    val list1 = List(t1, t2, t3)
    println("list1:")
    list1 foreach println
    
    val list2 = list1 map altTerm
    println("\nlist2:")
    list2 foreach println
    
    def altTerm(t: Term): Term = t match {
        case t: Var => {
            val varAltName = t.copy(name = t.name + "Alt")
            //println("Got Var, new name is " + varAltName.name)
            varAltName
        }
        case t: Fun => {
            val funAltBody = t.copy(body = t3)
            //println("Got Fun, new body is " + funAltBody.body)
            funAltBody
        }
        case t: App => {
            //println("Got App, v is " + t.v)
            t // no mod
        }
    }
    
    /* 
    list foreach { _ match {
        case t: Var => {
            val varAltName = t.copy(name = t.name + "Alt")
            println("Got Var, new name is " + varAltName.name)
        }
        case t: Fun => {
            val funAltBody = t.copy(body = t3)
            println("Got Fun, new body is " + funAltBody.body)
        }
        case t: App => {
            println("Got App, v is " + t.v)
        }
    }}
    */
}