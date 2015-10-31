package books.funreactdomainmodels.lab.calendar2

import books.funreactdomainmodels.lab.calendar2.CalendarApplication._
import books.funreactdomainmodels.lab.calendar2.CalendarEntities._
import books.funreactdomainmodels.lab.calendar2.Event._
import java.util.Locale
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

object CalendarClient_1 {

  val user1 = User("u1")                          //> user1  : books.funreactdomainmodels.lab.calendar2.CalendarEntities.User = Us
                                                  //| er(u1)
  val workCalRef1 = personalCalendar(user1, "myWorkCal").get
                                                  //> workCalRef1  : books.funreactdomainmodels.lab.calendar2.Calendar = PersonalC
                                                  //| alendar(User(u1),myWorkCal,List(),List())
  val personalCalRef1 = personalCalendar(user1, "myPersonalCal").get
                                                  //> personalCalRef1  : books.funreactdomainmodels.lab.calendar2.Calendar = Perso
                                                  //| nalCalendar(User(u1),myPersonalCal,List(),List())
  
  val pattern = "MMM d HH:mm:ss Z yyyy"           //> pattern  : String = MMM d HH:mm:ss Z yyyy
  val startTimeInput = "Mar 21 18:30:00 +0000 2016"
                                                  //> startTimeInput  : String = Mar 21 18:30:00 +0000 2016
  
  val format = DateTimeFormat.forPattern(pattern).withLocale(Locale.ENGLISH)
                                                  //> format  : org.joda.time.format.DateTimeFormatter = org.joda.time.format.Date
                                                  //| TimeFormatter@40bb0f79
  val startTime1 = format.parseDateTime(startTimeInput)
                                                  //> startTime1  : org.joda.time.DateTime = 2016-03-21T11:30:00.000-07:00
  val endTime1 = startTime1.plusHours(3)          //> endTime1  : org.joda.time.DateTime = 2016-03-21T14:30:00.000-07:00
  
  val myBDayParty = CalendarEvent(workCalRef1, "MyB-Day", startTime1, endTime1)
                                                  //> myBDayParty  : books.funreactdomainmodels.lab.calendar2.CalendarEntities.Cal
                                                  //| endarEvent = CalendarEvent(PersonalCalendar(User(u1),myWorkCal,List(),List()
                                                  //| ),MyB-Day,2016-03-21T11:30:00.000-07:00,2016-03-21T14:30:00.000-07:00,None,N
                                                  //| one,None,None,List())
  val workCalRef2 = addEvent(workCalRef1, myBDayParty)
                                                  //> workCalRef2  : scala.util.Try[books.funreactdomainmodels.lab.calendar2.Calen
                                                  //| dar] = Success(PersonalCalendar(User(u1),myWorkCal,List(CalendarEvent(Person
                                                  //| alCalendar(User(u1),myWorkCal,List(),List()),MyB-Day,2016-03-21T11:30:00.000
                                                  //| -07:00,2016-03-21T14:30:00.000-07:00,None,None,None,None,List())),List()))
  val workEvents = workCalRef2.get.events         //> workEvents  : List[books.funreactdomainmodels.lab.calendar2.CalendarEntities
                                                  //| .CalendarEvent] = List(CalendarEvent(PersonalCalendar(User(u1),myWorkCal,Lis
                                                  //| t(),List()),MyB-Day,2016-03-21T11:30:00.000-07:00,2016-03-21T14:30:00.000-07
                                                  //| :00,None,None,None,None,List()))
  workEvents.foreach { e => println(e.name) }     //> MyB-Day
  
  val (workCalRef3, personalCalRef2) = transferEvent(workCalRef1, personalCalRef1, myBDayParty).get
                                                  //> workCalRef3  : books.funreactdomainmodels.lab.calendar2.Calendar = Personal
                                                  //| Calendar(User(u1),myWorkCal,List(),List())
                                                  //| personalCalRef2  : books.funreactdomainmodels.lab.calendar2.Calendar = Pers
                                                  //| onalCalendar(User(u1),myPersonalCal,List(CalendarEvent(PersonalCalendar(Use
                                                  //| r(u1),myWorkCal,List(),List()),MyB-Day,2016-03-21T11:30:00.000-07:00,2016-0
                                                  //| 3-21T14:30:00.000-07:00,None,None,None,None,List())),List())
  workCalRef3.events                              //> res0: List[books.funreactdomainmodels.lab.calendar2.CalendarEntities.Calend
                                                  //| arEvent] = List()
  personalCalRef2.events.foreach(e => println(e.name))
                                                  //> MyB-Day
  
  
  '''                                             //> res1: Char('\'') = '
}
/*


*/