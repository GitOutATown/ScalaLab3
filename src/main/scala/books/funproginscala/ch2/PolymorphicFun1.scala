package books.funproginscala.ch2

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
        
    val fooMatch = strMatch("foo")_
    
    // ------------------------- //
            
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
}




