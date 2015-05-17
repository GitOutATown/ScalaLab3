package lab.concurrency

object function_param_lab_1 {

  // ----- Example 1 ----- //
  
  class Foo()
  class Bar()
  
  def func1(f: Foo => Int) {}                     //> func1: (f: lab.concurrency.function_param_lab_1.Foo => Int)Unit
  def func2(f: Bar => Int) {}                     //> func2: (f: lab.concurrency.function_param_lab_1.Bar => Int)Unit
  
  func1(x => 3) // x is recognized as type Foo by ScalaIDE (eg: hover)
  func2(x => 3) // x is recognized as type Bar by ScalaIDE (eg: hover)
  
  // Error scenarios
  // func1(x => Int) // error: found type Int, requires Int
  // func1(new Foo => 3) // error: param is not a function
  // func1(3) // required: Foo => Int
  // etc.
    
  // ----- Example 2 ----- //
  
  def func3(f: Foo) {}                            //> func3: (f: lab.concurrency.function_param_lab_1.Foo)Unit
  // func3(x) // not found: value y
  
  // ----- Commentary ----- //
  
  /* This had been blowing my mind for a while since encountering
   * it in Odersky's Reactive course assignment involving cancellable Futures.
   * In fact, it was one of the reasons I dropped out from the course in order
   * to do more studying on my own. I have been studying Aleksandar Prokopec's
   * Learning Scala Concurrency book (chapter 4 on Futures and Promises) and
   * encountered it again in his version of cancellable Futures (similar
   * principles, but differnt implementation).
   * I won't go into the particularities of that whole pattern here (saving
   * that for a more developed treatment in a further blog post). Instead I
   * want to just simply recognize something about Scala's abilty infer
   * function parameter types when the function parameter is itself an anonymus
   * function (Example 1). By contrast, Scala does not infer the type of a
   * prameter to a function when that parameter itself is not a function as in
   * Example 2.
   */
}