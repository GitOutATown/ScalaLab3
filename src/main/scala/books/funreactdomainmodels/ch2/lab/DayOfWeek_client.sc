package books.funreactdomainmodels.ch2.lab

import DayOfWeek._

object DayOfWeek_client {

  // Smart constructor pattern

  def schedule(day: DayOfWeek) = {
    "Scheduling " + day
  }                                               //> schedule: (day: books.funreactdomainmodels.ch2.lab.DayOfWeek)String
  
  /* Here is where I effectively isolate the DayOfWeek type in order to use
   * it as its type.
   */
  def scheduleDay(int: Int) = dayOfWeek(int) match {
    case Some(d) => schedule(d)
    case None => "Bad day!"
  }                                               //> scheduleDay: (int: Int)String
  
  scheduleDay(2)                                  //> res0: String = Scheduling Tuesday
  scheduleDay(8)                                  //> res1: String = Bad day!
  
  // ---- Less satisfactory techniques ------- //
  
  dayOfWeek(2).map(schedule)                      //> res2: Option[String] = Some(Scheduling Tuesday)
  dayOfWeek(8).map(schedule)                      //> res3: Option[String] = None

  val day = dayOfWeek(1).getOrElse("Error")       //> day  : Object = Monday
  dayOfWeek(8).getOrElse("Error")                 //> res4: Object = Error
  
  val one = dayOfWeek(1) match {
    case Some(d) => d
    case None => "Bad day!"
  }                                               //> one  : Object = Monday
  
  dayOfWeek(1) match {
    case Some(d) => schedule(d)
    case None =>
  }                                               //> res5: Any = Scheduling Monday
  
  def getDay(int: Int): Either[DayOfWeek, String] = dayOfWeek(int) match {
    case Some(d) => Left(d)
    case None => Right("Bad day!")
  }                                               //> getDay: (int: Int)Either[books.funreactdomainmodels.ch2.lab.DayOfWeek,String
                                                  //| ]
  
  getDay(8)                                       //> res6: Either[books.funreactdomainmodels.ch2.lab.DayOfWeek,String] = Right(Ba
                                                  //| d day!)
  val res = getDay(1)                             //> res  : Either[books.funreactdomainmodels.ch2.lab.DayOfWeek,String] = Left(Mo
                                                  //| nday)
  if(res.isLeft) res.left.get                     //> res7: Any = Monday
  
  dayOfWeek(8).isDefined                          //> res8: Boolean = false
  if(dayOfWeek(8).isDefined) dayOfWeek(8).get
  else "Bad day"                                  //> res9: Object = Bad day
  
  if(dayOfWeek(1).isDefined) dayOfWeek(1).get     //> res10: Any = Monday
  
  //val noSuchElement = dayOfWeek(8).get

  
}