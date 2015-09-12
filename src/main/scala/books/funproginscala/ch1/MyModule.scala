package books.funproginscala.ch1

object MyModule {
    
    def main(args: Array[String]): Unit = {
        println(formatResult("absolute value", -42, abs))
        println(formatResult("factorial", 6, fac))
    }
    
    def abs(n: Int): Int =
            if(n < 0) -n
            else n
            
    def fac(n: Int): Int = {
        def inter(n: Int, acc: Int): Int = {
            if(n <= 0) acc
            else(inter(n-1, n*acc))
        }
        inter(n, 1)
    }

    private def formatResult(name: String, n: Int, f: Int => Int) = {
        val msg = s"The %s of %d is %d."
        msg.format(name, n, f(n))
    }
}