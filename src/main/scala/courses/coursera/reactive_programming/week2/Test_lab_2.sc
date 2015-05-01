package courses.coursera.reactive_programming.week2

object Test_lab_2 {

	val num1 = Var(1)                         //> num1  : courses.coursera.reactive_programming.week2.Var[Int] = courses.course
                                                  //| ra.reactive_programming.week2.Var@2a93f40f
  	val twice1 = Signal(num1() * 2)           //> twice1  : courses.coursera.reactive_programming.week2.Signal[Int] = courses.
                                                  //| coursera.reactive_programming.week2.Signal@58220e8b
  	twice1()                                  //> res0: Int = 2
  	num1() = 2
  	twice1()                                  //> res1: Int = 4
  	
  	// --------------------- //
  	
  	var num2 = Var(1)                         //> num2  : courses.coursera.reactive_programming.week2.Var[Int] = courses.cours
                                                  //| era.reactive_programming.week2.Var@999c305
  	val twice2 = Signal(num2() * 2)           //> twice2  : courses.coursera.reactive_programming.week2.Signal[Int] = courses.
                                                  //| coursera.reactive_programming.week2.Signal@4231c44c
  	twice2()                                  //> res2: Int = 2
  	num2 = Var(2)
  twice2()                                        //> res3: Int = 2
	
	
	'''                                       //> res4: Char('\'') = '
}