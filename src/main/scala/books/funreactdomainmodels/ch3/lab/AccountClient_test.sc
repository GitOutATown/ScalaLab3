package books.funreactdomainmodels.ch3
package lab

  import Customer._
  import AccountEntities._
  import Account._
  import java.util.Date
  import java.util.Calendar
  import scala.util.{Try, Success, Failure}

object AccountClient_test {

  val c = getSuccessCustomer                      //> c  : books.funreactdomainmodels.ch3.Customer = Customer(c1,Sally Success,Add
                                                  //| ress())
  val effectiveDate = Calendar.getInstance().getTime()
                                                  //> effectiveDate  : java.util.Date = Thu Dec 03 13:58:40 PST 2015

  CheckingAccount(
    "STUB_ID",
    c.id,
    effectiveDate,
    None,
    Balance(0.0)
  )                                               //> res0: books.funreactdomainmodels.ch3.AccountEntities.CheckingAccount = Check
                                                  //| ingAccount(STUB_ID,c1,Thu Dec 03 13:58:40 PST 2015,None,Balance(0.0))
  
  '''                                             //> res1: Char('\'') = '
}