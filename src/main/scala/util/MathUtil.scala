package util

object MathUtil {

    def log2(x: Double) = scala.math.log(x)/scala.math.log(2)
    
    def roundAt(prec: Int)(n: Double): Double = {
        val scale = math pow(10, prec)
        //println("scale: " + scale)
        (math round n * scale) / scale
    }
}