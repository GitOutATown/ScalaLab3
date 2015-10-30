package books.funreactdomainmodels.ch3

object AccountClient_2b {
  import Customer._
  import AccountEntities._
  import Account._
  import java.util.Date
  import java.util.Calendar
  import scala.util.{Try, Success, Failure}

  val custSucc = getSuccessCustomer               //> custSucc  : books.funreactdomainmodels.ch3.Customer = Customer(c1,Sally Succ
                                                  //| ess,Address())
  val checkingAcct1 = checkingAccount(custSucc, Calendar.getInstance().getTime())
                                                  //> checkingAcct1  : scala.util.Try[books.funreactdomainmodels.ch3.Account] = Su
                                                  //| ccess(CheckingAccount(STUB_ID,c1,Thu Oct 29 20:38:27 PDT 2015,None,Balance(0
                                                  //| .0)))
  
  val savingsAcct1 = checkingAccount(custSucc, Calendar.getInstance().getTime())
                                                  //> savingsAcct1  : scala.util.Try[books.funreactdomainmodels.ch3.Account] = Suc
                                                  //| cess(CheckingAccount(STUB_ID,c1,Thu Oct 29 20:38:27 PDT 2015,None,Balance(0.
                                                  //| 0)))
  (checkingAcct1, savingsAcct1) match {
    case (Success(from), Success(to)) => {
      credit(from, 1000)
        .flatMap(from => transfer(from, to, 600))
        .map(tup => {
          println(tup._1.balance.amount)
          println(tup._2.balance.amount)
        })
    }
    case _ => Failure(new Exception("Transfer failed"))
  }                                               //> 400.0
                                                  //| 600.0
                                                  //| res0: scala.util.Try[Unit] = Success(())
}