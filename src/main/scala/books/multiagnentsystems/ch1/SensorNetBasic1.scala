package books.multiagnentsystems.ch1

case class Sensor(id: Long, var frequency: Option[Color] = None) {
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

// I feel this should be non-deterministic and therefor not implemented
/*class Network {
    var sensors: Set[Sensor] = Set()
}*/

trait Color
object Colors {
    object RED extends Color
    object GREEN extends Color
    object YELLOW extends Color
    
    val colors = List(RED, GREEN, YELLOW)
    
    val red = Some(RED)
    val green = Some(GREEN)
    val yellow = Some(YELLOW)
    
    def randomColor = scala.util.Random.shuffle(List(red, green, yellow)).head
}
