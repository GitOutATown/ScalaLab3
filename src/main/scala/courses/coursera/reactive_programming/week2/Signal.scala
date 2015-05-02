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

  /*
   * A Signal's current value can change when:
   * ~ somebody calls an update operation on a Var
   * ~~~ ex: balance() = b + amount
   * ~ or, the value of a dependent Signal changes
   * ~~~ ex: val inDollars = Signal(acctsTotal() * xchange()); xchange() = 250.00
   */
  protected def computeValue(): Unit = {
    println("In computeValue TOP")
    
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
    println("In computeValue, newValue: " + newValue)
    /* 
     * Odersky: Disable the following "optimization" for the assignment, because we
     * want to be able to track the actual dependency graph in the tests.
     */
    //if (myValue != newValue) {
      myValue = newValue // transformation
      val obs = observers 
      /* 
       * observers is var of Set() of Signal[_]. Observers are recorded
       * by the apply method which is used to get the Signal value, i.e.: 
       * observers += caller.value
       * Here in computeValue (called by update or from another Signal's 
       * computeValue function) the Signal value has been
       * changed and so all previously observing Signals are re-evaluated
       * and the observers set is cleared. Re-evaluation (computeValue) will
       * re-enter a calling Signal 'caller' in observers, as long as the 
       * caller's value still depends on this Signal.
       * 
       * But I am still having some difficulty clearly reading how this is 
       * done in this definition. I understand that there is a broadcasting 
       * interplay between observed and observers (actually, I am now 
       * realizing that my understanding of just exactly what an observer is 
       * may not be clear. Is it a Signal? Or is it the DynamicVariable thread 
       * stack?), and there is a wiping clean of both, but I'm not
       * seeing how the dependencies are being re-established or re-affirmed.
       * 
       * My best intuition right now is that the wiping clean follows the
       * notification (i.e. update), so the notification has happened and
       * all dependent Signals are updated. But the dependecies are erased 
       * and the next time the observer wants/calls for this Signal it will 
       * get re-established in the apply function. So there is a 
       * binary call and notification pattern. The response list is just a 
       * one-time relationship and needs to be re-established on every value 
       * call, i.e. apply)
       */
      observers = Set()
      println("~~In computeValue, calling computeValue on all observers")
      /* 
       * Generalized propagation.
       * Odersky says that this will re-add the observers into the observer
       * Set. But I don't see it happening here (it's the same function).
       * My intuition is still what I wrote in my comments above.
       */
      obs.foreach(_.computeValue()) 
    //}
  } // end computeValue

  protected def update(expr: => T): Unit = {
    println("~~In update TOP")
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
   * Odersky: The parameterless class version of apply gives you the current 
   * value of the Signal. Some examples from BankAccount2:
   * balance() calls class Signal def apply
   * The caller is added to the list of observers (which are notified when
   * the Signal value changes via update/computeValue)
   * (Note the object version of apply takes an expr argument and creates an 
   * instance of class Signal. Var(0) calls object Var def apply)
   */
  def apply() = {
    observers += caller.value // callers are observers
    println("~~In Signal apply observers.size: " + observers.size)
    // The observers of a Signal may not contain the Signal itself.
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
// A Var is a Signal that can be updated by the client program.
// The difference is that in Signal, update is protected.
class Var[T](expr: => T) extends Signal[T](expr) {
  //println("In Var constructor, expr: " + expr)
  override def update(expr: => T): Unit = super.update(expr) // Note that without super, update throws a stack overflow error
}

/* 
 * Odersky: The parameterless class version of apply gives you the current 
 * value of the Signal. The object version of apply takes an expr
 * argument and creates an instance of class Signal.
 */

/* 
 * A Var is a Signal that can be updated by the client program.
 * I think the sequence goes like this: Var.apply constructs a new instance of class
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

object NoSignal extends Signal[Nothing](???) { // ??? is valid here!
  override def computeValue() = ()
}

object Signal {
  val caller = new DynamicVariable[Signal[_]](NoSignal)
  def apply[T](expr: => T) = new Signal(expr)
}
