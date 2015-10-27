package books.funreactdomainmodels.ch3

object AccountClient_1 {

  import Customer._
  import AccountEntities._
  import Account._
  import java.util.Date
  import java.util.Calendar
  import scala.util.{Try, Success, Failure}

  val custStub = getStubCustomer()                //> custStub  : books.funreactdomainmodels.ch3.Customer = Customer(c1,Joe Stub,A
                                                  //| ddress())
  val acct1 = verifyCustomer(custStub).map { c =>
    checkingAccount(c, Calendar.getInstance().getTime())
  }.getOrElse(throw new Exception("Verification failed for customer"))
                                                  //> acct1  : scala.util.Try[books.funreactdomainmodels.ch3.AccountEntities.Check
                                                  //| ingAccount] = Success(CheckingAccount(STUB_ID,c1,Mon Oct 26 20:13:34 PDT 201
                                                  //| 5,None,Balance(0.0)))
  
  def verifyZeroBal(chAcct: CheckingAccount): Boolean = {
    chAcct.balance == Balance(0.0)
  }                                               //> verifyZeroBal: (chAcct: books.funreactdomainmodels.ch3.AccountEntities.Check
                                                  //| ingAccount)Boolean
  
  def runTest(chAcct: CheckingAccount): Either[CheckingAccount, Exception] = {
	  val a = for {
	    a <- creditChecking(chAcct, 1000)
	    b <- debitChecking(a, 200)
	    c <- debitChecking(b, 190)
	  } yield c
	  a match {
	    case Success(acct) => Left(acct)
	    case Failure(f) => Right(new Exception("failed test"))
	  }
	}                                         //> runTest: (chAcct: books.funreactdomainmodels.ch3.AccountEntities.CheckingAcc
                                                  //| ount)Either[books.funreactdomainmodels.ch3.AccountEntities.CheckingAccount,E
                                                  //| xception]
  
  acct1 match {
    case Success(acct) => {
      (verifyZeroBal(acct), runTest(acct))
    }
    case Failure(f) => new Exception("Account creation failed!")
  }                                               //> res0: java.io.Serializable = (true,Left(CheckingAccount(STUB_ID,c1,Mon Oct 
                                                  //| 26 20:13:34 PDT 2015,None,Balance(610.0))))

}