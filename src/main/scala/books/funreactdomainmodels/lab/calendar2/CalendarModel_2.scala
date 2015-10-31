package books.funreactdomainmodels.lab.calendar2

import org.joda.time.DateTime
import scala.util.{Try, Success, Failure}
import CalendarEntities._

/*
 * Base contract and interface for Calendar entity and 
 * the various types of calendars.
 */
trait Calendar {
    def user: User
    def name: String
    def events: List[CalendarEvent] 
    def holidays: List[Holiday]
}

trait CalendarService[User, Calendar] {
    
    /*
    def firstDayOfWeek: DayName
    def getWeek(date: DateTime): Try[Week]
    def getMonth(date: DateTime): Try[Month]
    def getYear(date: DateTime): Try[Year]
    def getHolidays(holidays: List[Holiday])
    */
    
    def personalCalendar(uId: User, name: String): Try[Calendar]
}

object CalendarApplication extends CalendarService[User, Calendar] { //with EventService {
    
    def personalCalendar(uId: User, name: String): Try[Calendar] = 
        Success(PersonalCalendar(uId, name))
}

trait Event {
    def name: String
    def startTime: DateTime
    def endTime: DateTime
    def notes: Option[List[String]]
    def reminders: Option[List[Reminder]]
}

/*
 * Base contract and interface for Event entity and 
 * the various types of Events.
 * All functions are abstract with concrete implementations 
 * in module type companion objects.
 */
trait EventService[Calendar, CalendarEvent, Milestone, Reminder] {
    
    def addEvent(calendar: Calendar, event: CalendarEvent): Try[(Calendar)]
    
    def deleteEvent(calendar: Calendar, event: CalendarEvent): Try[Calendar]
    
    def findEvent(calendar: Calendar, name: String): Try[List[CalendarEvent]]
    
    //def editEvent(event: CalendarEvent): Try[CalendarEvent]
    
    //def eventsBy(startTime: DateTime, endTime: DateTime): Try[List[CalendarEvent]]
    
    def addReminder(event: Event, date: DateTime): Try[Event]
    
    def deleteReminder(event: Event, reminder: Reminder)
        : Try[Event]
    
    def changeReminder(
        event: Event, oldReminder: Reminder, newDate: DateTime
    ): Try[Event]
    
    def transferEvent(
        sourceCal: Calendar, targetCal: Calendar, event: CalendarEvent
    ): Try[(Calendar, Calendar)]
}

object Event extends EventService[Calendar, CalendarEvent, Milestone, Reminder] {
    
    def calendarEvent(
        calendar: Calendar,
        name: String,
        startTime: DateTime, 
        endTime: DateTime
    ){
        // TODO: Need validation
        CalendarEvent(
            calendar: Calendar,
            name: String,
            startTime: DateTime, 
            endTime: DateTime
        )
    }
    
    def addEvent(calendar: Calendar, event: CalendarEvent)
        : Try[(Calendar)] = calendar match {
        case pc: PersonalCalendar => 
            Success(pc.copy(events = event :: calendar.events))
    }
    
    def deleteEvent(
        calendar: Calendar, event: CalendarEvent
    ): Try[Calendar] = calendar match {
        case pc: PersonalCalendar =>
            val events = pc.events.filter(e => e != event)
            Success(pc.copy(events = events))
    }
    
    def findEvent(calendar: Calendar, name: String)
        : Try[List[CalendarEvent]] = {
        val foundEvents = calendar.events.filter(_.name == name)
        Success(foundEvents)
    }
    
    def addReminder(event: Event, date: DateTime)
        : Try[Event] = event.reminders match {
        case Some(reminders) => 
            val newReminders = Reminder(date) :: reminders
            event match {
                // TODO: This is not DRY
                case ce: CalendarEvent =>
                    Success(ce.copy(reminders = Some(newReminders)))
                case ms: Milestone =>
                    Success(ms.copy(reminders = Some(newReminders)))
            }
        case None => event match {
            // TODO: This is not DRY
            case ce: CalendarEvent =>
                Success(ce.copy(reminders = Some(List(Reminder(date)))))
            case ms: Milestone =>
                Success(ms.copy(reminders = Some(List(Reminder(date)))))
        }
    }
    
    def deleteReminder(event: Event, reminder: Reminder)
        : Try[Event] = event.reminders match {
            case Some(reminders) =>
                val newReminders = reminders.filter(r => r != reminder)
                event match {
                    // TODO: This is not DRY
                    case ce: CalendarEvent => 
                        Success(ce.copy(reminders = Some(newReminders)))
                    case ms: Milestone =>
                        Success(ms.copy(reminders = Some(newReminders)))
                }
            case None => Success(event) // No op, reminders are already None
    }
    
    def changeReminder(
        event: Event, oldReminder: Reminder, newDate: DateTime
    ): Try[Event] = event.reminders match {
            case Some(reminders) =>
                val newReminders = Reminder(newDate) :: reminders.filter { 
                    r => r != oldReminder 
                }
                event match {
                    // TODO: This is not DRY
                    case ce: CalendarEvent =>
                        Success(ce.copy(reminders = Some(newReminders)))
                    case ms: Milestone =>
                        Success(ms.copy(reminders = Some(newReminders)))
                }
            case None =>
                event match {
                    // TODO: This is not DRY
                    case ce: CalendarEvent =>
                        Success(ce.copy(
                            reminders = Some(List(Reminder(newDate)))
                        ))
                    case ms: Milestone =>
                        Success(ms.copy(
                            reminders = Some(List(Reminder(newDate)))
                        ))
                }
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
        
    final case class User (uId: String)
    
    final case class PersonalCalendar private[calendar2](
        user: User,
        name: String,
        events: List[CalendarEvent] = Nil, 
        holidays: List[Holiday] = Nil
    ) extends Calendar
    
    final case class ProjectCalendar private[calendar2](
        user: User,
        name: String,
        events: List[CalendarEvent] = Nil, 
        holidays: List[Holiday] = Nil,
        milestones: List[Milestone]
    ) extends Calendar
    
    final case class CalendarEvent private[calendar2](
        calendar: Calendar,
        name: String,
        startTime: DateTime, 
        endTime: DateTime, 
        location: Option[Location] = None,
        notes: Option[List[String]] = None,
        url: Option[URL] = None,
        reminders: Option[List[Reminder]] = None,
        invites: List[Email] = Nil
    ) extends Event
    
    final case class Milestone private[calendar2] (
        name: String,
        startTime: DateTime,
        endTime: DateTime,
        notes: Option[List[String]],
        reminders: Option[List[Reminder]],
        description: Option[String],
        notification: List[Notification]
    ) extends Event
        
    case class Year(months: List[Month])
    
    case class Month(days: List[Day])
    
    case class Week(days: List[Day])
    
    case class Day(date: DateTime)
    
    case class Location(name: String, address: Address, map: Map)
    
    case class Map()
    
    case class Address()

    case class URL()
    
    case class Email(address: String)
    
    final case class Reminder(before: DateTime)
    
    final case class Holiday(date: DateTime, name: String)
    
    final case class Notification(recipients: Option[List[User]])
}


