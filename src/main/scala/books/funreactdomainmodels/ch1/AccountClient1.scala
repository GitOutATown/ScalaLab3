package books.funreactdomainmodels.ch1

import Customer._
import AccountService._
import java.util.Date
import java.util.Calendar

object AccountClient1 extends App {

    val cust = getCustomer()
    val acct = verifyCustomer(cust).map { c => 
        openCheckingAccount(c, Calendar.getInstance().getTime())
    }.getOrElse(throw new Exception("Verification failed for customer"))
    
    println(acct)
}