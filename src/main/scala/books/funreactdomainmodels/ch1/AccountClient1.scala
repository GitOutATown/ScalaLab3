package books.funreactdomainmodels.ch1

import Customer._
import AccountService._
import java.util.Date
import java.util.Calendar

object AccountClient1 extends App {

    val custStub = getStubCustomer()
    
    val acct1 = verifyCustomer(custStub).map { c => 
        openCheckingAccount(c, Calendar.getInstance().getTime())
    }.getOrElse(throw new Exception("Verification failed for customer"))
    
    println(acct1)
}