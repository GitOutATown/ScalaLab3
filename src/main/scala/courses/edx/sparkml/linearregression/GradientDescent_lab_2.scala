package courses.edx.sparkml.linearregression

import scala.math._
import util.MathUtil._

object GradientDescent_lab_2 extends App {
    
    val rnd = roundAt(3)_

    val theta = 3.0
    val alpha = 0.1

    def J(theta: Double): Double = pow(theta, 2)
    
    def derivJtheta(theta: Double): Double = 2 * theta
    
    def updateRule(alpha: Double)(recurse: Int)(theta: Double): Double = {
        def inter(theta: Double, recurse: Int): Double = {
            println("theta: " + rnd(theta))
            if(recurse > 0) {
                val newTheta = theta - (alpha * derivJtheta(theta))
                inter(newTheta, recurse - 1)
            }
            else theta
        }
        inter(theta, recurse)
    }
    
    val minTheta = updateRule(alpha)(10)_
    
    minTheta(theta)
}




