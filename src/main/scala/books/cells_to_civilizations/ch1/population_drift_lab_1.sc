package books.cells_to_civilizations.ch1

import scala.util.Random

object population_drift_lab_1 {

  def rand = Random.nextInt(3) + 1                //> rand: => Int
  rand                                            //> res0: Int = 2
  rand                                            //> res1: Int = 2
  rand                                            //> res2: Int = 3
  rand                                            //> res3: Int = 3
  rand                                            //> res4: Int = 1
  
  def pick = Random.nextInt(2)                    //> pick: => Int
  pick                                            //> res5: Int = 1
  pick                                            //> res6: Int = 1
  pick                                            //> res7: Int = 0
  pick                                            //> res8: Int = 1
  pick                                            //> res9: Int = 0
  
  trait Marble
  case object Black extends Marble
  case object White extends Marble
  
  def select = {
    pick match {
      case 0 => Black
      case 1 => White
    }
  }                                               //> select: => Product with Serializable with books.cells_to_civilizations.ch1.p
                                                  //| opulation_drift_lab_1.Marble
  
  val group = for(i <- 1 to 10) yield select      //> group  : scala.collection.immutable.IndexedSeq[Product with Serializable wit
                                                  //| h books.cells_to_civilizations.ch1.population_drift_lab_1.Marble] = Vector(W
                                                  //| hite, Black, Black, Black, White, Black, White, Black, Black, White)
  group foreach(println(_))                       //> White
                                                  //| Black
                                                  //| Black
                                                  //| Black
                                                  //| White
                                                  //| Black
                                                  //| White
                                                  //| Black
                                                  //| Black
                                                  //| White
  
  
  
  
  '''                                             //> res10: Char('\'') = '
}