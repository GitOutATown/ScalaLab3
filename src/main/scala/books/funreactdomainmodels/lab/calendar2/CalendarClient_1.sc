package books.funreactdomainmodels.lab.calendar2

import books.funreactdomainmodels.lab.calendar2.CalendarApplication._
import books.funreactdomainmodels.lab.calendar2.CalendarEntities._
import java.util.Locale
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
//import org.joda.time.convert._
//import org.joda.time.format._

//http://stackoverflow.com/questions/29569307/joda-datetime-parsing-full-date-name
//http://stackoverflow.com/questions/24324401/joda-time-iso-datetime-formatting

object CalendarClient_1 {

  //val cal1 = newCalendar(User("myPersonalCal")).get
  //val formatter: DateTimeFormatter = ISODateTimeFormat.dateTime().withZone(DateTimeZone.getDefault())
  val pattern = "MMM d HH:mm:ss Z yyyy"           //> pattern  : String = MMM d HH:mm:ss Z yyyy
  val input = "Mar 21 18:30:00 +0000 2016"        //> input  : String = Mar 21 18:30:00 +0000 2016
  
  val format = DateTimeFormat.forPattern(pattern).withLocale(Locale.ENGLISH)
                                                  //> format  : org.joda.time.format.DateTimeFormatter = org.joda.time.format.Date
                                                  //| TimeFormatter@5e48a0e1
  val dateTime1 = format.parseDateTime(input)     //> dateTime1  : org.joda.time.DateTime = 2016-03-21T11:30:00.000-07:00
  '''                                             //> res0: Char('\'') = '
}