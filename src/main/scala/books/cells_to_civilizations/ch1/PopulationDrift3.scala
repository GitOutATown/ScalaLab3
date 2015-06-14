package books.cells_to_civilizations.ch1

import scala.util.Random

object PopulationDrift3 {
    
    trait Marble
    case object Black extends Marble
    case object White extends Marble
    
    def ratio(group: Seq[Marble]): (Double, Double) = {
        val black = group.filter(m => m == Black)
        val ratioBlk = black.length.toDouble / group.length.toDouble
        val ratioWht = 1d - ratioBlk
        (ratioBlk, ratioWht)
    }
    
    // Recursive
    /* This algorithm introduces some degree of stohasticism in that the cycle of duplication
     * does not evenly fit the limit (i.e. 100, 200, 400, 800 -> 1000) so that the last
     * remainder of increase is randomly chosen (i.e. does not adhere to the original input
     * ratio.
     * The idea was to stick close to a mechanical increase mechanism as opposed to a pure
     * mathematical projection.
     * TODO: Also implement a purely mathematical projection of the original ratio projected
     * to the limit.
     */
    def duplicate(limit: Int)(group: Seq[Marble]): Seq[Marble] = {
        //println("===> duplicate group.length: " + group.length)
        println("===> group ratio: " + ratio(group))
        group.length match {
            case l if (l <= (limit / 2)) => {
                //println("---> case <1>")
                val result = group.flatMap(m => m match {
                    case Black => Seq(Black, Black)
                    case White => Seq(White, White)
                })
                duplicate(limit)(result)
            }
            case l if (limit - l < 2) => {
                //println("---> case 2, returning final group of length " + group.length)
                group
            }
            case _ => {
                val lastLimit = limit - group.length
                val lastLength = lastLimit / 2
                //println(s"---> case 3, calling duplicate for lastLimit: $lastLimit lastLength: $lastLength")
                group ++ duplicate(lastLimit)(group.take(lastLength))
            }
        }
    } // end duplicate

}