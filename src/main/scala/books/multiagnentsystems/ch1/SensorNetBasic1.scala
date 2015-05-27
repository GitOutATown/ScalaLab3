package books.multiagnentsystems.ch1

case class Sensor(id: Long, var frequency: Color) {
    import Colors._
    
    val self = this
    
    var domain = colors
    
    var neighbors: Set[Sensor] = Set() // subset of network
    
    // Asynchronous
    def coordFreq {
        neighbors map revise _ // each neighbor
    }
    // Pruning
    def revise(that: Sensor) {
        val prunedDomain = for{
            vj <- that.domain 
            vi <- self.domain 
            if vj != vi // vi doesn't conflict with vj, i.e. satisfies constraint
        } yield vi
        domain = prunedDomain
    }
}

trait Color
object Colors {
    object RED extends Color
    object GREEN extends Color
    object YELLOW extends Color
    
    val colors = Set(RED, GREEN, YELLOW)
        
    def randomColor = scala.util.Random.shuffle(List(RED, GREEN, YELLOW)).head
}
