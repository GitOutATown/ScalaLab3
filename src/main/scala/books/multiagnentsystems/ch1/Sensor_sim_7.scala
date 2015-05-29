package books.multiagnentsystems.ch1

object Sensor_sim_7 extends App {
    import Colors._
    
    val s1 = new Sensor(1, randomColor)
    val s2 = new Sensor(2, randomColor)
    val s3 = new Sensor(3, randomColor)
    
    // This problem accurately returns no solution
    s1.domain = Set(RED, BLUE)
    s2.domain = Set(RED, BLUE)
    s3.domain = Set(RED, BLUE)
    
    println("Before...")
    println("s1.domain: " + s1.domain)
    println("s2.domain: " + s2.domain)
    println("s3.domain: " + s3.domain)
    
    println()

    s1.neighbors = Set(s2, s3)
    s2.neighbors = Set(s1, s3)
    s3.neighbors = Set(s2, s1)
    
    // ------------------- //
    
    List(s1, s2, s3).map(s => s.coordFreq)
    //List(s2, s3, s1).map(s => s.coordFreq) // Same result
    //List(s3, s2, s1).map(s => s.coordFreq) // Same result
    
    println("After...")
    println("s1.domain: " + s1.domain)
    println("s2.domain: " + s2.domain)
    println("s3.domain: " + s3.domain)

    println("s1.domain.size: " + s1.domain.size)
    println("s2.domain.size: " + s2.domain.size)
    println("s3.domain.size: " + s3.domain.size)

}







