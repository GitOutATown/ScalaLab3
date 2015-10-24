package books.funreactdomainmodels.ch2

import Customer._
import AccountService._
import java.util.Date
import java.util.Calendar

object AccountClient1 extends App {

  import Customer._
  import AccountEntities._
  import AccountService._
  import java.util.Date
  import java.util.Calendar

  val custStub = getStubCustomer()
    
  val acct1 = verifyCustomer(custStub).map { c =>
    openCheckingAccount(c, Calendar.getInstance().getTime())
  }.getOrElse(throw new Exception("Verification failed for customer"))
  acct1.balance == Balance(0.0)
  
  val acct1_1 = creditChecking(acct1, 1000.00)
  acct1
  
  for {
    a <- creditChecking(acct1, 1000)
    b <- debitChecking(a, 200)
    c <- debitChecking(b, 190)
  } yield c
}