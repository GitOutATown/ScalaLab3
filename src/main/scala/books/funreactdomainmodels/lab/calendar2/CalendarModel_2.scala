package books.funreactdomainmodels.lab.calendar2

import org.joda.time.DateTime
import scala.util.{Try, Success, Failure}
import CalendarEntities._

/*
 * Base contract and interface for Calendar entity and 
 * the various types of accounts.
 */
trait CalendarService[User, Calendar] {
    
    /*
    def firstDayOfWeek: DayName
    def getWeek(date: DateTime): Try[Week]
    def getMonth(date: DateTime): Try[Month]
    def getYear(date: DateTime): Try[Year]
    def getHolidays(holidays: List[Holiday])
    */
    
    def newCalendar(uId: User): Try[Calendar]
}

object CalendarApplication extends CalendarService[User, Calendar] { //with EventService {
    
    def newCalendar(uId: User): Try[Calendar] = Success(Calendar(uId))
}

trait Event {
    def name: String
    def startTime: DateTime
    def endTime: DateTime
    def notes: Option[List[String]]
    def reminders: List[Reminder]
}

/*
 * Base contract and interface for Event entity and 
 * the various types of Events.
 * All functions are abstract with concrete implementations 
 * in module type companion objects.
 */
trait EventService[Calendar, CalendarEvent, Reminder] {
    
    def addEvent(calendar: Calendar, event: CalendarEvent): Try[(Calendar)]
    
    def deleteEvent(calendar: Calendar, event: CalendarEvent): Try[Calendar]
    
    def findEvent(calendar: Calendar, name: String): Try[List[CalendarEvent]]
    
    //def editEvent(event: CalendarEvent): Try[CalendarEvent]
    
    //def eventsBy(startTime: DateTime, endTime: DateTime): Try[List[CalendarEvent]]
    
    def addReminder(event: CalendarEvent, date: DateTime): Try[CalendarEvent]
    
    def deleteReminder(event: CalendarEvent, reminder: Reminder)
        : Try[CalendarEvent]
    
    def changeReminder(
        event: CalendarEvent, oldReminder: Reminder, newDate: DateTime
    ): Try[CalendarEvent]
    
    def transferEvent(
        sourceCal: Calendar, targetCal: Calendar, event: CalendarEvent
    ): Try[(Calendar, Calendar)]
}

object Event extends EventService[Calendar, CalendarEvent, Reminder] {
    
    def addEvent(calendar: Calendar, event: CalendarEvent): Try[(Calendar)] = {
        val newCalendar = calendar.copy(events = event :: calendar.events)
        Success(newCalendar)
    }
    
    def deleteEvent(
        calendar: Calendar, event: CalendarEvent
    ): Try[Calendar] = {
        val newEvents = calendar.events.filter(e => e != event)
        Success(calendar.copy(events = newEvents))
    }
    
    def findEvent(calendar: Calendar, name: String)
        : Try[List[CalendarEvent]] = {
        val foundEvents = calendar.events.filter(_.name == name)
        Success(foundEvents)
    }
    
    def addReminder(event: CalendarEvent, date: DateTime)
        : Try[CalendarEvent] = {
        val newReminders = Reminder(date) :: event.reminders
        Success(event.copy(reminders = newReminders))
    }
    
    def deleteReminder(event: CalendarEvent, reminder: Reminder)
        : Try[CalendarEvent] = {
        val newReminders = event.reminders.filter { 
            r => r != reminder 
        }
        Success(event.copy(reminders = newReminders))
    }
    
    def changeReminder(
        event: CalendarEvent, oldReminder: Reminder, newDate: DateTime
    ): Try[CalendarEvent] = {
        val newReminders = Reminder(newDate) :: event.reminders.filter { 
            r => r != oldReminder 
        }
        Success(event.copy(reminders = newReminders))
    }
    
    def transferEvent(
        sourceCal: Calendar, targetCal: Calendar, event: CalendarEvent
    )
    : Try[(Calendar, Calendar)] = {
        for {
            sCal <- deleteEvent(sourceCal, event)
            tCal <- addEvent(targetCal, event)
        } yield (sCal, tCal)
    }
}
    
trait InviteService[CalendarEvent, Email] {
    
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
        startTime: DateTime, 
        endTime: DateTime, 
        location: Option[Location] = None,
        notes: Option[List[String]] = None,
        url: Option[URL] = None,
        reminders: List[Reminder] = Nil,
        invites: List[Email] = Nil
    ) extends Event
    
    case class Calendar (
        user: User, events: List[CalendarEvent] = Nil, holidays: List[Holiday] = Nil
    )
        
    case class Year(months: List[Month])
    
    case class Month(days: List[Day])
    
    case class Week(days: List[Day])
    
    case class Day(date: DateTime)
    
    case class Location(name: String, address: Address, map: Map)
    
    case class Map()
    
    case class Address()

    case class URL()
    
    case class Email(address: String)
    
    case class Reminder(before: DateTime)
    
    case class Holiday(date: DateTime, name: String)
}


