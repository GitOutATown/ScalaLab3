package lab.currying

object curry_lab_1_MEM {

    def filterMEM(xs: List[Int], p: Int => Boolean): List[Int] = 
        if(xs.isEmpty) xs
        else if(p(xs.head)) xs.head :: filterMEM(xs.tail, p)
        else filterMEM(xs.tail, p)
        
    def modNMEM(n: Int)(x: Int) = x % n == 0
}