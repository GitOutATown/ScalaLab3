package books.multiagnentsystems.ch1

case class Sensor(id: Long, var frequency: Color) {
    import Colors._
    
    val self = this
    
    var domain: Set[Color] = Set()
    
    var neighbors: Set[Sensor] = Set() // subset of network
    
    // Asynchronous
    def coordFreq {
        val domainCheck = domain
        neighbors foreach revise _ // each neighbor
        // Termination condition, no change in domain state
        // TODO: This needs a repeat limit
        // println("~~coordFreq Node:" + self.id + " domainCheck:" + domainCheck + " domain:" + domain)
        if(domainCheck != domain) neighbors foreach(n => n coordFreq)
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

