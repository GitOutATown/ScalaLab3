package courses.coursera.reactive_programming.week3

object run_lab_1 {

  case class Bar(name: String)
  class Baz {
    def fee:Foo = new Foo(42)
  }
  class Foo(meaning: Int)
  
  def run()(f: Foo => Bar): Baz = {
    val baz = new Baz
    f(baz.fee)
    baz
  }                                               //> run: ()(f: courses.coursera.reactive_programming.week3.run_lab_1.Foo => cour
                                                  //| ses.coursera.reactive_programming.week3.run_lab_1.Bar)courses.coursera.react
                                                  //| ive_programming.week3.run_lab_1.Baz

  val baz = run() {
    foo => Bar("Bob")
  }                                               //> baz  : courses.coursera.reactive_programming.week3.run_lab_1.Baz = courses.c
                                                  //| oursera.reactive_programming.week3.run_lab_1$Baz@1804686d
  baz.fee                                         //> res0: courses.coursera.reactive_programming.week3.run_lab_1.Foo = courses.co
                                                  //| ursera.reactive_programming.week3.run_lab_1$Foo@4963d86c
    

  '''                                             //> res1: Char('\'') = '
}