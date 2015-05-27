package courses.coursera.reactive_programming.week2

object scratchpad {

  class Signal[T](expr: => T) {

    private var myExpr: () => T = _
    
    myExpr = () => expr
    
    println(myExpr)
    
  } // end class Signal
  
  def f = (x: Int) => x + 1                       //> f: => Int => Int
  
  val sig1 = new Signal(f)                        //> <function0>
                                                  //| sig1  : courses.coursera.reactive_programming.week2.scratchpad.Signal[Int =>
                                                  //|  Int] = courses.coursera.reactive_programming.week2.scratchpad$Signal@1dcc04
                                                  //| 2f

  '''                                             //> res0: Char('\'') = '
}