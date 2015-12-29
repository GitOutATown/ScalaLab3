package lab.math.calculus.coordinatesystem

import scala.math.{pow, sqrt}
import scala.util.{Either, Right, Left}
import lab.math.calculus.coordinatesystem.Triangle._

object Distance {
    
    def hypotDist(x1: Double, y1: Double)(x2: Double, y2: Double): Double = {
        val xDist = pow(x1 - x2, 2)
        val yDist = pow(y1 - y2, 2)
        sqrt(xDist + yDist)
    }
    
    def hypotDist(x1: Int, y1: Int)(x2: Int, y2: Int): Double = {
        val xDist = pow(x1 - x2, 2)
        val yDist = pow(y1 - y2, 2)
        sqrt(xDist + yDist)
    }
    
    def hypotMidPt(x1: Double, y1: Double)(x2: Double, y2: Double): (Double, Double) = {
        val xMid = (x1 + x2) / 2d
        val yMid = (y1 + y2) / 2d
        (xMid, yMid)
    }
    
    def hypotMidPt(x1: Int, y1: Int)(x2: Int, y2: Int): (Double, Double) = {
        val xMid = (x1 + x2) / 2d
        val yMid = (y1 + y2) / 2d
        (xMid, yMid)
    }
    
    def lengthSides(x1: Double, y1: Double)
                   (x2: Double, y2: Double)
                   (x3: Double, y3: Double): (Double, Double, Double) = {
        val lenA = hypotDist(x1, y1)(x2, y2)
        val lenB = hypotDist(x2, y2)(x3, y3)
        val lenC = hypotDist(x3, y3)(x1, y1)
        (lenA, lenB, lenC)
    }
    
    def lengthSides(x1: Int, y1: Int)
                   (x2: Int, y2: Int)
                   (x3: Int, y3: Int): (Double, Double, Double) = {
        val lenA = hypotDist(x1, y1)(x2, y2)
        val lenB = hypotDist(x2, y2)(x3, y3)
        val lenC = hypotDist(x3, y3)(x1, y1)
        (lenA, lenB, lenC)
    }
    
    def isIsoceles(ls: (Double, Double, Double)): Boolean = {
        ls._1 == ls._2 || ls._1 == ls._3 || ls._2 == ls._3
    }
    
    def isRight(ls: (Double, Double, Double)): Boolean = {
        sq(ls._1) + sq(ls._2) == sq(ls._3) || 
        sq(ls._2) + sq(ls._3) == sq(ls._1) ||
        sq(ls._1) + sq(ls._3) == sq(ls._2)
    }
    
    def isRightWhich(x1: Int, y1: Int)
                    (x2: Int, y2: Int)
                    (x3: Int, y3: Int)
                    : Either[Boolean, (Boolean, (Double, Double))] = {
        
        val lenA = hypotDist(x1, y1)(x2, y2)
        val lenB = hypotDist(x2, y2)(x3, y3)
        val lenC = hypotDist(x3, y3)(x1, y1)
        
             if( sq(lenB) + sq(lenC) == sq(lenA) ) Right(true, (x3, y3))
        else if( sq(lenA) + sq(lenC) == sq(lenB) ) Right(true, (x1, y1))
        else if( sq(lenA) + sq(lenB) == sq(lenC) ) Right(true, (x2, y2))
        
        else Left(false)
    }
    
    def isRightWhich(t: Triangle)
                    : Either[Boolean, (Boolean, (Double, Double))] = {
        
        val lenA = hypotDist(t.x1, t.y1)(t.x2, t.y2)
        val lenB = hypotDist(t.x2, t.y2)(t.x3, t.y3)
        val lenC = hypotDist(t.x3, t.y3)(t.x1, t.y1)
        
             if( sq(lenB) + sq(lenC) == sq(lenA) ) Right(true, (t.x3, t.y3))
        else if( sq(lenA) + sq(lenC) == sq(lenB) ) Right(true, (t.x1, t.y1))
        else if( sq(lenA) + sq(lenB) == sq(lenC) ) Right(true, (t.x2, t.y2))
        
        else Left(false)
    }
        
    // ----- Util ------- //
    
    val sq = (x: Double) => pow(x, 2)
}

class Triangle(
    val x1: Int, val y1: Int, val x2: Int, val y2: Int, val x3: Int, val y3: Int
)
object Triangle {
    def apply(x1: Int, y1: Int)
             (x2: Int, y2: Int)
             (x3: Int, y3: Int): Triangle = new Triangle(x1, y1, x2, y2, x3, y3)
}





