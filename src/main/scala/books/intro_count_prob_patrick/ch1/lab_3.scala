package books.intro_count_prob_patrick.ch1

object lab_3 extends App {

    // How many numbers in a contiguous inclusive list Ints?
    def numsInList(start: Int, end: Int): Int = {
        end - start + 1
        // same as end - (start - 1)
    }
    
    println("numsInList(1, 18): " + numsInList(1, 18))
    println("numsInList(1, 18): " + numsInList(7, 29))
    
    // How many multiples of div are there in a contiguous inclusive list of Ints?
    // TODO: Add boundry constraints
    def numMultiples(first: Int, last: Int, div: Int): Int = {
    
        def isMult(num: Int, div: Int): Boolean = {
            num % div == 0
        }
         
        // Determine range of muliples of div
        def findNearestMult(num: Int, direction: Boolean): Int = {
            println("findNearestMult, num: " + num)
            if(isMult(num, div)) num
            else {
                if(first - last == 0) 0 // boundary
                else{
                    val increment = if(direction) num + 1 else num - 1
                    findNearestMult(increment, direction)
                }
            }
        }
            
        val start = findNearestMult(first, true)
        val end = findNearestMult(last, false)
        
        // TODO: Note the +1. Should be able to explain why.
        val result = (numsInList(start, end) / div) + 1
        
        println("start:" + start + " end:" + end + " numMultiples:" + result)
        
        result
    }
    
    println("numMultiples(62, 215, 3): " + numMultiples(62, 215, 3))
    println("numMultiples(62, 315, 3): " + numMultiples(62, 315, 3))
    println("numMultiples(29, 407, 3): " + numMultiples(29, 407, 3))
    
}