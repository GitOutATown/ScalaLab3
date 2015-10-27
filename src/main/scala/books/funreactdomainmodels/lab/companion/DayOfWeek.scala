package books.funreactdomainmodels.lab.companion

sealed trait DayOfWeekAbst {
  val value: Int
  override def toString = value match {
      case 1 => "Monday"
      case 2 => "Tuesday"
      case 3 => "Wednesday"
      case 4 => "Thursday"
      case 5 => "Friday"
      case 6 => "Saturday"
      case 7 => "Sunday"
  }
  
  /*
   *  This would make DayOfWeekAbst abstract and break the 
   *  companion object factory.
   */
  // def someFunc
}

object DayOfWeekAbst {
  private def unsafeDayOfWeek(d: Int) = new DayOfWeekAbst { val value = d }
  private val isValid: Int => Boolean = { i => i >= 1 && i <= 7 }
  def dayOfWeek(d: Int): Option[DayOfWeekAbst] = if (isValid(d))
    Some(unsafeDayOfWeek(d)) else None
}



