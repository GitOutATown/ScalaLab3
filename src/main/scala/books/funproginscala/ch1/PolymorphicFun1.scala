package books.funproginscala.ch1

object PolymorphicFun1 extends App {

    def findFirst[A](as: Array[A], p: A => Boolean): Int = {
        def loop(n: Int): Int = {
            if(n >= as.length) -1
            else if(p(as(n))) n
            else loop(n+1)
        }
        
        loop(0)
    }
    
    def strMatch(str1: String)(str2: String): Boolean = str1 == str2
    
    // ------------------------- //
    
    val fooMatch = strMatch("foo")_
    
    val strings = Array("bar", "bee", "foo", "jax", "bear")
    
    val res1 = findFirst(strings, fooMatch)
    //println(res1)
    
    // ----------------------- //
    
    val startsWithJ = (s: String) => s.startsWith("j")
    
    val res2 = findFirst(strings, startsWithJ)
    //println(res2)
    
    // ---------------------- //
    
    val numbs1 = Array(97, 25, 480, 23)
    
    val gt100 = (x: Int) => (x > 100)
    
    val res3 = findFirst(numbs1, gt100)
    //println(res3)
    
    // ---------------------- //
    
    def orderedInt(a: Int, b: Int): Boolean = a <= b
    
    def orderedStr(a: String, b: String): Boolean = a <= b
    
    def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
        
        def loop(i: Int): Boolean = {
            if(i >= as.length) true
            else if(!(ordered(as(i-1), as(i)))) {
                false
            } 
            else loop(i+1)
        }
        
        if(as.length == 1) true
        else loop(1)
    }
    
    // ---------------------- //
    
    val numbs2 = Array(1,2,2,4,7,10,14,14)
    
    val res4 = isSorted(numbs2, orderedInt)
    println("res4: " + res4)
    
    val strings2 = Array("apple", "carrot", "grape", "grapefruit")
    val strings3 = Array("apple", "carrot", "grapefruit", "grape")

    val res5 = isSorted(strings2, orderedStr)
    println("res5: " + res5)
    
    val res6 = isSorted(strings3, orderedStr)
    println("res6: " + res6)
    
    // ---------------------- //
    
    val res7 = isSorted(numbs2, (a: Int, b: Int) => a <= b)
    println("res7: " + res7)
    
    val res8 = isSorted(strings3, (a: String, b: String) => a <= b)
    println("res8: " + res8)
}




