package books.cells_to_civilizations.ch1

import books.cells_to_civilizations.ch1.PopulationDrift4._
import scala.util.Random

object PopulationDrift_lab_4 extends App {

    val blackPop = for(i <- 1 to 500) yield Black
    val whitePop = for(i <- 1 to 500) yield White
    val mixedPop = Random.shuffle((blackPop ++ whitePop))
    
    println("Initial mixed population size: " + mixedPop.length + 
        ". Mixed population ratio: " + ratio(mixedPop))
    
    // parameters: maxNumCycles, sampleSize, reproductionCap, population
    val resultingPop = cycleSampleRepro(10)(100)(1000)(mixedPop)
    println("Resulting Population ratio: " + ratio(resultingPop))
}