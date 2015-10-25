package books.funreactdomainmodels.lab.calendar2

import java.util.Date
import scala.util.{Try, Success, Failure}

trait CalendarService {
    import CalendarEntities._
    import CalendarEntities.Days._
    
    /*
    def firstDayOfWeek: DayName
    def getWeek(date: Date): Try[Week]
    def getMonth(date: Date): Try[Month]
    def getYear(date: Date): Try[Year]
    def getHolidays(holidays: List[Holiday])
    */
    
    def newCalendar(uId: User): Try[Calendar] = Success(Calendar(uId))
}

object CalendarApplication extends CalendarService with EventService

trait EventService {
    import CalendarEntities._
    
    def addEvent(calendar: Calendar, event: CalendarEvent): Try[(Calendar)] = {
        val newCalendar = calendar.copy(events = event :: calendar.events)
        Success(newCalendar)
    }
    
    def deleteEvent(calendar: Calendar, event: CalendarEvent): Try[Calendar] = {
        val newEvents = calendar.events.filter(e => e != event)
        Success(calendar.copy(events = newEvents))
    }
    
    def findEvent(calendar: Calendar, name: String): Try[List[CalendarEvent]] = {
        val foundEvents = calendar.events.filter(_.name == name)
        Success(foundEvents)
    }
    
    //def editEvent(event: CalendarEvent): Try[CalendarEvent]
    
    //def eventsBy(startTime: Date, endTime: Date): Try[List[CalendarEvent]]
    
    def addReminder(event: CalendarEvent, date: Date): Try[CalendarEvent] = {
        val newReminders = Reminder(date) :: event.reminders
        Success(event.copy(reminders = newReminders))
    }
    
    def deleteReminder(event: CalendarEvent, reminder: Reminder): Try[CalendarEvent] = {
        val newReminders = event.reminders.filter { 
            r => r != reminder 
        }
        Success(event.copy(reminders = newReminders))
    }
    
    def changeReminder(
        event: CalendarEvent, oldReminder: Reminder, newDate: Date
    ): Try[CalendarEvent] = {
        val newReminders = Reminder(newDate) :: event.reminders.filter { 
            r => r != oldReminder 
        }
        Success(event.copy(reminders = newReminders))
    }
    
    def transferEvent(sourceCal: Calendar, targetCal: Calendar, event: CalendarEvent)
        : Try[(Calendar, Calendar)] = {
        for {
            sCal <- deleteEvent(sourceCal, event)
            tCal <- addEvent(targetCal, event)
        } yield (sCal, tCal)
    }
}
    
trait InviteService {
    import CalendarEntities._
    
    // Side effects
    def invite(event: CalendarEvent, email: List[Email])
    def send(invite: List[Email])
}

object CalendarEntities {
    
    object Days extends Enumeration {
        type DayName = Value
        val SUN, MON, TUE, WED, THU, FRI, SAT = Value
    }
        
    case class User(uId: String)
    
    case class CalendarEvent(
        calendar: Calendar,
        name: String,
        startTime: Date, 
        endTime: Date, 
        location: Option[Location] = None,
        notes: Option[List[String]] = None,
        url: Option[URL] = None,
        reminders: List[Reminder] = Nil,
        invites: List[Email] = Nil
    )
    
    case class Calendar (
        user: User, events: List[CalendarEvent] = Nil, holidays: List[Holiday] = Nil
    )
        
    case class Year(months: List[Month])
    
    case class Month(days: List[Day])
    
    case class Week(days: List[Day])
    
    case class Day(date: Date)
    
    case class Location(name: String, address: Address, map: Map)
    
    case class Map()
    
    case class Address()

    case class URL()
    
    case class Email(address: String)
    
    case class Reminder(before: Date)
    
    case class Holiday(date: Date, name: String)
}


