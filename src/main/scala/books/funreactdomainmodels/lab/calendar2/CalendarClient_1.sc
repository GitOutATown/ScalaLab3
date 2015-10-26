package books.funreactdomainmodels.lab.calendar2

import books.funreactdomainmodels.lab.calendar2.CalendarApplication._
import books.funreactdomainmodels.lab.calendar2.CalendarEntities._
import books.funreactdomainmodels.lab.calendar2.Event._
import java.util.Locale
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

object CalendarClient_1 {

  val workCalRef1 = newCalendar(User("myWorkCal")).get
                                                  //> workCalRef1  : books.funreactdomainmodels.lab.calendar2.CalendarEntities.Cal
                                                  //| endar = Calendar(User(myWorkCal),List(),List())
  val personalCalRef1 = newCalendar(User("myPersonalCal")).get
                                                  //> personalCalRef1  : books.funreactdomainmodels.lab.calendar2.CalendarEntities
                                                  //| .Calendar = Calendar(User(myPersonalCal),List(),List())
  
  val pattern = "MMM d HH:mm:ss Z yyyy"           //> pattern  : String = MMM d HH:mm:ss Z yyyy
  val startTimeInput = "Mar 21 18:30:00 +0000 2016"
                                                  //> startTimeInput  : String = Mar 21 18:30:00 +0000 2016
  
  val format = DateTimeFormat.forPattern(pattern).withLocale(Locale.ENGLISH)
                                                  //> format  : org.joda.time.format.DateTimeFormatter = org.joda.time.format.Date
                                                  //| TimeFormatter@59c4fcd4
  val startTime1 = format.parseDateTime(startTimeInput)
                                                  //> startTime1  : org.joda.time.DateTime = 2016-03-21T11:30:00.000-07:00
  val endTime1 = startTime1.plusHours(3)          //> endTime1  : org.joda.time.DateTime = 2016-03-21T14:30:00.000-07:00
  
  val myBDayParty = CalendarEvent(workCalRef1, "MyB-Day", startTime1, endTime1)
                                                  //> myBDayParty  : books.funreactdomainmodels.lab.calendar2.CalendarEntities.Cal
                                                  //| endarEvent = CalendarEvent(Calendar(User(myWorkCal),List(),List()),MyB-Day,2
                                                  //| 016-03-21T11:30:00.000-07:00,2016-03-21T14:30:00.000-07:00,None,None,None,Li
                                                  //| st(),List())
  val workCalRef2 = addEvent(workCalRef1, myBDayParty)
                                                  //> workCalRef2  : scala.util.Try[books.funreactdomainmodels.lab.calendar2.Calen
                                                  //| darEntities.Calendar] = Success(Calendar(User(myWorkCal),List(CalendarEvent(
                                                  //| Calendar(User(myWorkCal),List(),List()),MyB-Day,2016-03-21T11:30:00.000-07:0
                                                  //| 0,2016-03-21T14:30:00.000-07:00,None,None,None,List(),List())),List()))
  val workEvents = workCalRef2.get.events         //> workEvents  : List[books.funreactdomainmodels.lab.calendar2.CalendarEntities
                                                  //| .CalendarEvent] = List(CalendarEvent(Calendar(User(myWorkCal),List(),List())
                                                  //| ,MyB-Day,2016-03-21T11:30:00.000-07:00,2016-03-21T14:30:00.000-07:00,None,No
                                                  //| ne,None,List(),List()))
  workEvents.foreach { e => println(e.name) }     //> MyB-Day
  
  val (workCalRef3, personalCalRef2) = transferEvent(workCalRef1, personalCalRef1, myBDayParty).get
                                                  //> workCalRef3  : books.funreactdomainmodels.lab.calendar2.CalendarEntities.Ca
                                                  //| lendar = Calendar(User(myWorkCal),List(),List())
                                                  //| personalCalRef2  : books.funreactdomainmodels.lab.calendar2.CalendarEntitie
                                                  //| s.Calendar = Calendar(User(myPersonalCal),List(CalendarEvent(Calendar(User(
                                                  //| myWorkCal),List(),List()),MyB-Day,2016-03-21T11:30:00.000-07:00,2016-03-21T
                                                  //| 14:30:00.000-07:00,None,None,None,List(),List())),List())
  workCalRef3.events                              //> res0: List[books.funreactdomainmodels.lab.calendar2.CalendarEntities.Calend
                                                  //| arEvent] = List()
  personalCalRef2.events.foreach(e => println(e.name))
                                                  //> MyB-Day
  
  
  '''                                             //> res1: Char('\'') = '
}