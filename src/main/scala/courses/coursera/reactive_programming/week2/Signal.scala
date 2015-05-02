package courses.coursera.reactive_programming.week2

import scala.util.DynamicVariable

class Signal[T](expr: => T) {
  import Signal._
  private var myExpr: () => T = _
  private var myValue: T = _
  private var observers: Set[Signal[_]] = Set()
  private var observed: List[Signal[_]] = Nil
  
  println("In Signal constructor")
  
  update(expr)

  protected def computeValue(): Unit = {
    //println("In computeValue TOP")
    
    for (sig <- observed) {// List[Signal]
      //println("In computeValue, sig: " + sig)
      sig.observers -= this // Set[Signal[_]]
    }
    
    observed = Nil
    
    /* 
     * 'this', may I remind you, is a Signal.
     * caller is a DynamicVariable that is doing localThread magic. 
     */
    val newValue = caller.withValue(this)(myExpr()) // T
    //println("In computeValue, newValue: " + newValue)
    /* 
     * Odersky: Disable the following "optimization" for the assignment, because we
     * want to be able to track the actual dependency graph in the tests.
     */
    //if (myValue != newValue) {
      myValue = newValue // transformation
      val obs = observers 
      /* 
       * observers is var of Set() of Signal[_] , but how are the observers 
       * being re-populated? I believe it is by the apply method, i.e.: 
       * observers += caller.value
       * So then where/how is apply being invoked?
       */
      observers = Set()
      obs.foreach(_.computeValue()) // generalized propagation
    //}
  } // end computeValue

  protected def update(expr: => T): Unit = {
    //println("In update TOP")
    /* 
     * The expression is stored for further (consistent, uniform, repeatable) 
     * application (i.e. value production). 
     * This is a def (function) that seems to have a body, but no (empty) 
     * input parameters. The return type is Unit. So it is just an executable
     * body with no input nor output. I have commented elsewhere in this file
     * about how I think this works (i.e. it is just providing behavior that
     * that interacts with fields external to itself (within the enclosing 
     * Signal encapsulation). More specifically, it is used by computeValue 
     * to do what that name implies.
     * See: val newValue = caller.withValue(this)(myExpr()) // T
     */
    myExpr = () => expr 
    /* 
     * computeValue carries out the important task of binding the newValue
     * to all of the observers. 
     * */
    computeValue()
  }

  /*
   * How/where/when is this being invoked? To answer that I need to 
   * trace/establish a more complete and integrated picture of program
   * flow.
   * Ok, I've done that. Here are some examples from BankAccount2:
   * Var(0) calls object Var def apply
   * balance() calls class Signal def apply
   * Odersky: The parameterless class version of apply gives you the current 
   * value of the Signal. The object version of apply takes an expr
   * argument and creates an instance of class Signal.
   */
  def apply() = {
    observers += caller.value // callers are observers
    println("~~In Signal apply observers.size: " + observers.size)
    assert(!caller.value.observers.contains(this), "cyclic signal definition")
    caller.value.observed ::= this // this is observed
    println("~~In Signal apply, caller.value.observed.size: " + caller.value.observed.size)
    //println("~~In Signal apply, observed: " + observed)
    println("~~In Signal apply, myValue: " + myValue)
    myValue
  }
} // end class Signal[T](expr: => T)

// Var is an extention of Signal.
// Odersky: Signal is assumed to be a Var Signal
class Var[T](expr: => T) extends Signal[T](expr) {
  //println("In Var constructor, expr: " + expr)
  override def update(expr: => T): Unit = super.update(expr) // Note that without super, update throws a stack overflow error
}

/* 
 * Odersky: The parameterless class version of apply gives you the current 
 * value of the Signal. The object version of apply takes an expr
 * argument and creates an instance of class Signal.
 */

/* I think the sequence goes like this: Var.apply constructs a new instance of class
 * Var, which in turn calls super.update(expr) on class Signal. In true functional practice
 * The expresion remains integrally linked with the resulting (consequential)
 * value it produces. super.update then calls computeValue, which involves
 * caller.withValue (DynamicVariable) using the passed in expression to compute 
 * the value--but there is some necessary thread magic, which I don't quite 
 * understand the purpose of yet (but I'd like to! And I will!) to compute 
 * the value, which is then further applied in a general propagation on all 
 * registered observers (and their observers) (cascading broadcasted recursion).
 */
object Var {
  def apply[T](expr: => T) = new Var(expr) // new Var is of class Var
}

object NoSignal extends Signal[Nothing](???) {
  override def computeValue() = ()
}

object Signal {
  val caller = new DynamicVariable[Signal[_]](NoSignal)
  def apply[T](expr: => T) = new Signal(expr)
}
