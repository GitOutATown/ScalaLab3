package courses.coursera.reactive_programming.week3

object TradingServices {
    
    val available = 510 - (math.random * 100)
    println("available: " + available)

    // Simulate facimili of a connection and network request/response
    def getCurrentValue: Double = {
        Thread.sleep(500) // express/exagerate latency
        //randomConnectionStatus // simulation of broken connection
        val rand = math.random // introduce range of response behavior
        rand
    }
    
    // Simulate facimili of a connection and network request/response 
    def isProfitable(quote: Double): Boolean = {
        Thread.sleep(500)
        randomConnectionStatus
        val threshold = 0.10 // arbitrary condition
        val result = quote > threshold
        result
    }
    
    def buy(amount: Int, quote: Double): Int = {
        Thread.sleep(500)
        //randomConnectionStatus
        if(amount <= available) amount
        else throw new Exception("Purchase amount not available")
    }
    
    case class ConnectionException(message: String) extends Exception(message)
    
    def randomConnectionStatus = {
        if(math.random > 0.75) throw new ConnectionException("Broken connection!")
    }
}