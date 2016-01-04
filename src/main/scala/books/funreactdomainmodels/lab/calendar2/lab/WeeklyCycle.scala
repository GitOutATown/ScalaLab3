package books.funreactdomainmodels.lab.calendar2.lab

object WeeklyCycle {

    sealed trait Day
    case object Sunday extends Day
    case object Monday extends Day
    case object Tuesday extends Day
    case object Wednesday extends Day
    case object Thursday extends Day
    case object Friday extends Day
    case object Saturday extends Day
    
    trait Month { def length: Int }
    case object January extends Month { val length = 31 }
    case object February extends Month { val length = 28 }// leap handled by year
    case object March extends Month { val length = 31 }
    case object April extends Month { val length = 30 }
    case object May extends Month { val length = 31 }
    case object June extends Month { val length = 30 }
    case object July extends Month { val length = 31 }
    case object August extends Month { val length = 31 }
    case object September extends Month { val length = 30 }
    case object October extends Month { val length = 31 }
    case object November extends Month { val length = 30 }
    case object December extends Month { val length = 31 }
    val months = Seq(January, February, March, April, May, June, July, August, September, October, November, December)
        
    case class Year(year: Int, startDay: Day, leap: Boolean) {
        require(year < 0 || 0 < year)
    }
}