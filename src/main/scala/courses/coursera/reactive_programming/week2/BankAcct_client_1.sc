package courses.coursera.reactive_programming.week2
 
object BankAcct_client_1 {
	
	val acct1 = new BankAccount               //> acct1  : courses.coursera.reactive_programming.week2.BankAccount = courses.c
                                                  //| oursera.reactive_programming.week2.BankAccount@4f614932
	acct1 deposit 50
	acct1 withdraw 20                         //> res0: Int = 30
	acct1 withdraw 10                         //> res1: Int = 20
	// acct1 withdraw 25 // Insificient funds
	
	// ---------------------------- //
	
	def consolidated(accts: List[BankAccount2]): Signal[Int] =
		Signal(accts.map(_.balance()).sum)//> consolidated: (accts: List[courses.coursera.reactive_programming.week2.BankA
                                                  //| ccount2])courses.coursera.reactive_programming.week2.Signal[Int]
	
	val acct2 = new BankAccount2              //> acct2  : courses.coursera.reactive_programming.week2.BankAccount2 = courses.
                                                  //| coursera.reactive_programming.week2.BankAccount2@7f2b86b2
	val acct3 = new BankAccount2              //> acct3  : courses.coursera.reactive_programming.week2.BankAccount2 = courses.
                                                  //| coursera.reactive_programming.week2.BankAccount2@2985158
  val acctsTotal = consolidated(List(acct2, acct3))
                                                  //> ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .Signal@6bae60c5)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Var@1bb8c5bc)
                                                  //| ~~In Signal apply, myValue: 0
                                                  //| ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .Signal@6bae60c5)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Var@7fbdc7db, courses.coursera.reactive_programming.week2.Var
                                                  //| @1bb8c5bc)
                                                  //| ~~In Signal apply, myValue: 0
                                                  //| acctsTotal  : courses.coursera.reactive_programming.week2.Signal[Int] = cour
                                                  //| ses.coursera.reactive_programming.week2.Signal@6bae60c5
  acctsTotal()                                    //> ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .NoSignal$@7d5e8834)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Signal@6bae60c5)
                                                  //| ~~In Signal apply, myValue: 0
                                                  //| res2: Int = 0
	
	acct2 deposit 50                          //> ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .Signal@6bae60c5, courses.coursera.reactive_programming.week2.NoSignal$@7d5e
                                                  //| 8834)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Var@1bb8c5bc, courses.coursera.reactive_programming.week2.Sig
                                                  //| nal@6bae60c5)
                                                  //| ~~In Signal apply, myValue: 0
                                                  //| ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .Signal@6bae60c5)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Var@1bb8c5bc)
                                                  //| ~~In Signal apply, myValue: 50
                                                  //| ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .Signal@6bae60c5)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Var@7fbdc7db, courses.coursera.reactive_programming.week2.Var
                                                  //| @1bb8c5bc)
                                                  //| ~~In Signal apply, myValue: 0
  acctsTotal()                                    //> ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .NoSignal$@7d5e8834)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Signal@6bae60c5, courses.coursera.reactive_programming.week2.
                                                  //| Var@1bb8c5bc, courses.coursera.reactive_programming.week2.Signal@6bae60c5)
                                                  //| ~~In Signal apply, myValue: 50
                                                  //| res3: Int = 50
	acct2 withdraw 20                         //> ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .Signal@6bae60c5, courses.coursera.reactive_programming.week2.NoSignal$@7d5e
                                                  //| 8834)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Var@1bb8c5bc, courses.coursera.reactive_programming.week2.Sig
                                                  //| nal@6bae60c5, courses.coursera.reactive_programming.week2.Var@1bb8c5bc, cour
                                                  //| ses.coursera.reactive_programming.week2.Signal@6bae60c5)
                                                  //| ~~In Signal apply, myValue: 50
                                                  //| ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .Signal@6bae60c5, courses.coursera.reactive_programming.week2.NoSignal$@7d5e
                                                  //| 8834)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Var@1bb8c5bc, courses.coursera.reactive_programming.week2.Var
                                                  //| @1bb8c5bc, courses.coursera.reactive_programming.week2.Signal@6bae60c5, cour
                                                  //| ses.coursera.reactive_programming.week2.Var@1bb8c5bc, courses.coursera
                                                  //| Output exceeds cutoff limit.
  acct3 deposit 100                               //> ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .Signal@6bae60c5, courses.coursera.reactive_programming.week2.NoSignal$@7d5e
                                                  //| 8834)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Var@7fbdc7db, courses.coursera.reactive_programming.week2.Var
                                                  //| @1bb8c5bc, courses.coursera.reactive_programming.week2.Var@1bb8c5bc, courses
                                                  //| .coursera.reactive_programming.week2.Var@1bb8c5bc, courses.coursera.reactive
                                                  //| _programming.week2.Signal@6bae60c5, courses.coursera.reactive_programming.we
                                                  //| ek2.Var@1bb8c5bc, courses.coursera.reactive_programming.week2.Signal@6bae60c
                                                  //| 5)
                                                  //| ~~In Signal apply, myValue: 0
                                                  //| ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .NoSignal$@7d5e8834, courses.coursera.reactive_programming.week2.Signal@6bae
                                                  //| 60c5)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Var@1bb8c5bc)
                                                  //| ~~In Signal
                                                  //| Output exceeds cutoff limit.
  acctsTotal()                                    //> ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .NoSignal$@7d5e8834)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Signal@6bae60c5, courses.coursera.reactive_programming.week2.
                                                  //| Var@7fbdc7db, courses.coursera.reactive_programming.week2.Var@1bb8c5bc, cour
                                                  //| ses.coursera.reactive_programming.week2.Var@1bb8c5bc, courses.coursera.react
                                                  //| ive_programming.week2.Var@1bb8c5bc, courses.coursera.reactive_programming.we
                                                  //| ek2.Signal@6bae60c5, courses.coursera.reactive_programming.week2.Var@1bb8c5b
                                                  //| c, courses.coursera.reactive_programming.week2.Signal@6bae60c5)
                                                  //| ~~In Signal apply, myValue: 130
                                                  //| res5: Int = 130
  val xchange = Signal(246.00)                    //> xchange  : courses.coursera.reactive_programming.week2.Signal[Double] = cour
                                                  //| ses.coursera.reactive_programming.week2.Signal@713a4e73
  val inDollars = Signal(acctsTotal() * xchange())//> ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .NoSignal$@7d5e8834, courses.coursera.reactive_programming.week2.Signal@87bd
                                                  //| 5a0)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Signal@6bae60c5)
                                                  //| ~~In Signal apply, myValue: 130
                                                  //| ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .Signal@87bd5a0)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Signal@713a4e73, courses.coursera.reactive_programming.week2.
                                                  //| Signal@6bae60c5)
                                                  //| ~~In Signal apply, myValue: 246.0
                                                  //| inDollars  : courses.coursera.reactive_programming.week2.Signal[Double] = co
                                                  //| urses.coursera.reactive_programming.week2.Signal@87bd5a0
  inDollars()                                     //> ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .NoSignal$@7d5e8834)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Signal@87bd5a0, courses.coursera.reactive_programming.week2.S
                                                  //| ignal@6bae60c5, courses.coursera.reactive_programming.week2.Var@7fbdc7db, co
                                                  //| urses.coursera.reactive_programming.week2.Var@1bb8c5bc, courses.coursera.rea
                                                  //| ctive_programming.week2.Var@1bb8c5bc, courses.coursera.reactive_programming.
                                                  //| week2.Var@1bb8c5bc, courses.coursera.reactive_programming.week2.Signal@6bae6
                                                  //| 0c5, courses.coursera.reactive_programming.week2.Var@1bb8c5bc, courses.cours
                                                  //| era.reactive_programming.week2.Signal@6bae60c5)
                                                  //| ~~In Signal apply, myValue: 31980.0
                                                  //| res6: Double = 31980.0
  acct3 withdraw 40                               //> ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .Signal@6bae60c5, courses.coursera.reactive_programming.week2.NoSignal$@7d5e
                                                  //| 8834)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Var@7fbdc7db, courses.coursera.reactive_programming.week2.Sig
                                                  //| nal@87bd5a0, courses.coursera.reactive_programming.week2.Signal@6bae60c5, co
                                                  //| urses.coursera.reactive_programming.week2.Var@7fbdc7db, courses.coursera.rea
                                                  //| ctive_programming.week2.Var@1bb8c5bc, courses.coursera.reactive_programming.
                                                  //| week2.Var@1bb8c5bc, courses.coursera.reactive_programming.week2.Var@1bb8c5bc
                                                  //| , courses.coursera.reactive_programming.week2.Signal@6bae60c5, courses.cours
                                                  //| era.reactive_programming.week2.Var@1bb8c5bc, courses.coursera.reactive_progr
                                                  //| amming.week2.Signal@6bae60c5)
                                                  //| ~~In Signal apply, myValue: 100
                                                  //| ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .Signal@6bae60c5, courses
                                                  //| Output exceeds cutoff limit.
  
  inDollars()                                     //> ~~In Signal apply observers: Set(courses.coursera.reactive_programming.week2
                                                  //| .NoSignal$@7d5e8834)
                                                  //| ~~In Signal apply, caller.value.observed: List(courses.coursera.reactive_pro
                                                  //| gramming.week2.Signal@87bd5a0, courses.coursera.reactive_programming.week2.V
                                                  //| ar@7fbdc7db, courses.coursera.reactive_programming.week2.Var@7fbdc7db, cours
                                                  //| es.coursera.reactive_programming.week2.Var@7fbdc7db, courses.coursera.reacti
                                                  //| ve_programming.week2.Signal@87bd5a0, courses.coursera.reactive_programming.w
                                                  //| eek2.Signal@6bae60c5, courses.coursera.reactive_programming.week2.Var@7fbdc7
                                                  //| db, courses.coursera.reactive_programming.week2.Var@1bb8c5bc, courses.course
                                                  //| ra.reactive_programming.week2.Var@1bb8c5bc, courses.coursera.reactive_progra
                                                  //| mming.week2.Var@1bb8c5bc, courses.coursera.reactive_programming.week2.Signal
                                                  //| @6bae60c5, courses.coursera.reactive_programming.week2.Var@1bb8c5bc, courses
                                                  //| .coursera.reactive_programming.week2.Signal@6bae60c5)
                                                  //| ~~In Signal apply, myV
                                                  //| Output exceeds cutoff limit.

}
/*









*/