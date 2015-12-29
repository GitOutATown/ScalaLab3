package books.funreactdomainmodels.ch3

object AccountClient_2c {
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
                                                  //| ccess(CheckingAccount(STUB_ID,c1,Thu Dec 03 13:47:02 PST 2015,None,Balance(0
                                                  //| .0)))
  
  val savingsAcct1 = savingsAccount(custSucc, Calendar.getInstance().getTime())
                                                  //> savingsAcct1  : scala.util.Try[books.funreactdomainmodels.ch3.Account] = Suc
                                                  //| cess(SavingsAccount(STUB_ID,c1,Thu Dec 03 13:47:02 PST 2015,None,0.0,Balance
                                                  //| (0.0)))
  val transferal = (checkingAcct1, savingsAcct1) match {
    case (Success(from), Success(to)) => {
      for {
        from <- credit(from, 1000)
        (from, to) <- transfer(from, to, 600)
      } yield {
        println(from.balance.amount)
        println(to.balance.amount)
        (from, to)
      }
    }
    case _ => Failure(new Exception("Account creation failed."))
  }                                               //> 400.0
                                                  //| 600.0
                                                  //| transferal  : scala.util.Try[(books.funreactdomainmodels.ch3.Account, books.
                                                  //| funreactdomainmodels.ch3.Account)] = Success((CheckingAccount(STUB_ID,c1,Thu
                                                  //|  Dec 03 13:47:02 PST 2015,None,Balance(400.0)),SavingsAccount(STUB_ID,c1,Thu
                                                  //|  Dec 03 13:47:02 PST 2015,None,0.0,Balance(600.0))))
}