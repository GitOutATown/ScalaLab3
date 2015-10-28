package books.funproginscala.ch2

object PolymorphicFun_MEM {

    def findFirst[A](as: Array[A], p: A => Boolean): Int = {
        def inner(i: Int): Int = {
            if(i >= as.length) -1
            else if(p(as(i))) i
            else(inner(i+1))
        }
        inner(0)
    }
    
    def stringMatch(s1: String)(s2: String) = s1 == s2
    
    def isSorted[A](as: Array[A], f:(A,A) => Boolean): Boolean = {
        def inner(i: Int): Boolean = {
            if(i >= as.length) true
            else if(!(f(as(i-1), as(i)))) false
            else inner(i+1)
        }
        inner(1)
    }
}