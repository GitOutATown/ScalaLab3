package books.funreactdomainmodels.ch3

object AccountClient_2 {
  import Customer._
  import AccountEntities._
  import Account._
  import java.util.Date
  import java.util.Calendar
  import scala.util.{Try, Success, Failure}

  val custSucc = getSuccessCustomer               //> custSucc  : books.funreactdomainmodels.ch3.Customer = Customer(c1,Sally Succ
                                                  //| ess,Address())
  val custFail = getFailCustomer                  //> custFail  : books.funreactdomainmodels.ch3.Customer = Customer(c2,Frank Fail
                                                  //| ure,Address())
  
  val acct1 = checkingAccount(custSucc, Calendar.getInstance().getTime())
                                                  //> acct1  : scala.util.Try[books.funreactdomainmodels.ch3.Account] = Success(Ch
                                                  //| eckingAccount(STUB_ID,c1,Thu Oct 29 20:38:45 PDT 2015,None,Balance(0.0)))
  val acct2 = checkingAccount(custFail, Calendar.getInstance().getTime())
                                                  //> acct2  : scala.util.Try[books.funreactdomainmodels.ch3.Account] = Failure(ja
                                                  //| va.lang.Exception: Customer failed verification)
  
  def verifyZeroBal(acct: Account): Boolean = {
    acct.balance == Balance(0.0)
  }                                               //> verifyZeroBal: (acct: books.funreactdomainmodels.ch3.Account)Boolean
  
  def runTest(acct: Account): Either[String, Exception] = {
    val acctBal = for {
      a <- credit(acct, 1000)
      b <- debit(a, 200)
      c <- debit(b, 190)
      bal = c.balance.amount
    } yield bal
    acctBal match {
      case Success(b) => {
        if(b == 610) Left("Success: correct balance")
        else Right(new Exception("Failed: incorrect balance"))
      }
      case Failure(f) => Right(new Exception("Failed test: " + f.getMessage))
    }
  }                                               //> runTest: (acct: books.funreactdomainmodels.ch3.Account)Either[String,Except
                                                  //| ion]
  
  List(acct1, acct2) foreach { a =>
    a match {
      case Success(acct) => {
        println(verifyZeroBal(acct))
        println(runTest(acct))
      }
      case Failure(f) => {
         println(new Exception("Account creation failed!"))
         println(f.getMessage)
      }
    }                                             //> true
                                                  //| Left(Success: correct balance)
                                                  //| java.lang.Exception: Account creation failed!
                                                  //| Customer failed verification
  }
}