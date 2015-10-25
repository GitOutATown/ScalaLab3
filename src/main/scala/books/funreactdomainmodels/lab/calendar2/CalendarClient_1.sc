package books.funreactdomainmodels.lab.calendar2

import books.funreactdomainmodels.lab.calendar2.CalendarApplication._
import books.funreactdomainmodels.lab.calendar2.CalendarEntities._
import java.util.{Calendar, Date, Locale}
import org.joda.time._
import org.joda.time.convert._
import org.joda.time.format._

object CalendarClient_1 {

  //val cal1 = newCalendar(User("myPersonalCal")).get
  //val formatter: DateTimeFormatter = ISODateTimeFormat.dateTime().withZone(DateTimeZone.getDefault())
  val pattern = "MMM d HH:mm:ss Z yyyy"           //> pattern  : String = MMM d HH:mm:ss Z yyyy
  val input = "Apr 10 18:31:45 +0000 2015"        //> input  : String = Apr 10 18:31:45 +0000 2015
  
  val format = DateTimeFormat.forPattern(pattern).withLocale(Locale.ENGLISH)
                                                  //> format  : org.joda.time.format.DateTimeFormatter = org.joda.time.format.Date
                                                  //| TimeFormatter@5e48a0e1
  format.parseDateTime(input)                     //> res0: org.joda.time.DateTime = 2015-04-10T11:31:45.000-07:00
  '''                                             //> res1: Char('\'') = '
}