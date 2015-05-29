package books.multiagnentsystems.ch1.async

case class Sensor(id: Long, var frequency: Color) {
    import scala.concurrent._
    import ExecutionContext.Implicits.global
    import scala.util.{Success, Failure}
    import Colors._
    
    val self = this
    
    var domain: Set[Color] = Set()
    
    var neighbors: Set[Sensor] = Set() // subset of network
    
    def coordFreq {
        //Thread.sleep(500)
        val domainCheck = domain
        val revNeibsFut = Future { neighbors foreach revise _ }// each neighbor
        println("~~coordFreq Node:" + self.id + " domainCheck:" + domainCheck + " domain:" + domain)
        revNeibsFut onComplete { 
            case Success(unit) =>
                if(domainCheck != domain) {
                    neighbors foreach(n => n coordFreq)
                    // self.coordFreq // Not completely certain as of yet whether this might be needed in some scenarios.
                }
            case Failure(e) => throw e
        }
    }
    // Pruning
    def revise(that: Sensor) {
        val prunedDomain = for{
            vi <- self.domain
            vj <- that.domain  
            if vj != vi // vi doesn't conflict with vj, i.e. satisfies constraint
        } yield vi
        domain = prunedDomain
    }
}

trait Color
object Colors {
    object RED extends Color {override def toString = "RED"}
    object GREEN extends Color {override def toString = "GREEN"}
    object BLUE extends Color {override def toString = "BLUE"}
    
    val colors = Set(RED, GREEN, BLUE)
        
    def randomColor = scala.util.Random.shuffle(List(RED, GREEN, BLUE)).head
}

