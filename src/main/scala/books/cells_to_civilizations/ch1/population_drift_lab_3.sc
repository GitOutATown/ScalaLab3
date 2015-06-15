package books.cells_to_civilizations.ch1

import books.cells_to_civilizations.ch1.PopulationDrift3._
import scala.util.Random

object population_drift_lab_3 {

  val blackPop = for(i <- 1 to 500) yield Black   //> blackPop  : scala.collection.immutable.IndexedSeq[books.cells_to_civilizatio
                                                  //| ns.ch1.PopulationDrift3.Black.type] = Vector(Black, Black, Black, Black, Bla
                                                  //| ck, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Bl
                                                  //| ack, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, B
                                                  //| lack, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, 
                                                  //| Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black,
                                                  //|  Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black
                                                  //| , Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Blac
                                                  //| k, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Bla
                                                  //| ck, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Bl
                                                  //| ack, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, B
                                                  //| lack, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, 
                                                  //| Black, Black, Black, Bla
                                                  //| Output exceeds cutoff limit.
  val whitePop = for(i <- 1 to 500) yield White   //> whitePop  : scala.collection.immutable.IndexedSeq[books.cells_to_civilizatio
                                                  //| ns.ch1.PopulationDrift3.White.type] = Vector(White, White, White, White, Whi
                                                  //| te, White, White, White, White, White, White, White, White, White, White, Wh
                                                  //| ite, White, White, White, White, White, White, White, White, White, White, W
                                                  //| hite, White, White, White, White, White, White, White, White, White, White, 
                                                  //| White, White, White, White, White, White, White, White, White, White, White,
                                                  //|  White, White, White, White, White, White, White, White, White, White, White
                                                  //| , White, White, White, White, White, White, White, White, White, White, Whit
                                                  //| e, White, White, White, White, White, White, White, White, White, White, Whi
                                                  //| te, White, White, White, White, White, White, White, White, White, White, Wh
                                                  //| ite, White, White, White, White, White, White, White, White, White, White, W
                                                  //| hite, White, White, White, White, White, White, White, White, White, White, 
                                                  //| White, White, White, Whi
                                                  //| Output exceeds cutoff limit.
  val mixedPop = blackPop ++ whitePop             //> mixedPop  : scala.collection.immutable.IndexedSeq[Product with Serializable 
                                                  //| with books.cells_to_civilizations.ch1.PopulationDrift3.Marble] = Vector(Blac
                                                  //| k, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Bla
                                                  //| ck, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Bl
                                                  //| ack, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, B
                                                  //| lack, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, 
                                                  //| Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black,
                                                  //|  Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black
                                                  //| , Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Blac
                                                  //| k, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Bla
                                                  //| ck, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Bl
                                                  //| ack, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, B
                                                  //| lack, Black, Black, Blac
                                                  //| Output exceeds cutoff limit.
  ratio(mixedPop)                                 //> res0: (Double, Double) = (0.5,0.5)
  mixedPop.length                                 //> res1: Int = 1000
  val shuf1 = Random.shuffle(mixedPop)            //> shuf1  : scala.collection.immutable.IndexedSeq[Product with Serializable wit
                                                  //| h books.cells_to_civilizations.ch1.PopulationDrift3.Marble] = Vector(White, 
                                                  //| White, White, White, Black, White, Black, Black, White, Black, White, White,
                                                  //|  White, White, White, Black, Black, Black, White, Black, Black, Black, White
                                                  //| , Black, Black, Black, White, White, Black, Black, White, Black, Black, Blac
                                                  //| k, Black, Black, Black, Black, Black, White, White, Black, White, Black, Whi
                                                  //| te, Black, White, White, Black, Black, Black, White, Black, Black, Black, Bl
                                                  //| ack, White, White, Black, Black, White, Black, Black, Black, Black, White, W
                                                  //| hite, Black, White, Black, White, White, Black, Black, White, Black, White, 
                                                  //| White, Black, Black, White, White, Black, Black, White, Black, White, Black,
                                                  //|  Black, White, Black, White, White, Black, White, White, White, White, Black
                                                  //| , Black, White, White, Black, Black, Black, White, Black, White, White, Whit
                                                  //| e, Black, White, Black, 
                                                  //| Output exceeds cutoff limit.
  ratio(shuf1)                                    //> res2: (Double, Double) = (0.5,0.5)
  val select1 = shuf1.take(100)                   //> select1  : scala.collection.immutable.IndexedSeq[Product with Serializable w
                                                  //| ith books.cells_to_civilizations.ch1.PopulationDrift3.Marble] = Vector(White
                                                  //| , White, White, White, Black, White, Black, Black, White, Black, White, Whit
                                                  //| e, White, White, White, Black, Black, Black, White, Black, Black, Black, Whi
                                                  //| te, Black, Black, Black, White, White, Black, Black, White, Black, Black, Bl
                                                  //| ack, Black, Black, Black, Black, Black, White, White, Black, White, Black, W
                                                  //| hite, Black, White, White, Black, Black, Black, White, Black, Black, Black, 
                                                  //| Black, White, White, Black, Black, White, Black, Black, Black, Black, White,
                                                  //|  White, Black, White, Black, White, White, Black, Black, White, Black, White
                                                  //| , White, Black, Black, White, White, Black, Black, White, Black, White, Blac
                                                  //| k, Black, White, Black, White, White, Black, White, White, White, White, Bla
                                                  //| ck, Black)
  ratio(select1)                                  //> res3: (Double, Double) = (0.55,0.44999999999999996)
  val popIncrease1000 = duplicate(1000)_          //> popIncrease1000  : Seq[books.cells_to_civilizations.ch1.PopulationDrift3.Mar
                                                  //| ble] => Seq[books.cells_to_civilizations.ch1.PopulationDrift3.Marble] = <fun
                                                  //| ction1>
  val resultPop1 = popIncrease1000(select1)       //> ===> group ratio: (0.55,0.44999999999999996)
                                                  //| ===> group ratio: (0.55,0.44999999999999996)
                                                  //| ===> group ratio: (0.55,0.44999999999999996)
                                                  //| ===> group ratio: (0.55,0.44999999999999996)
                                                  //| ===> group ratio: (0.32,0.6799999999999999)
                                                  //| ===> group ratio: (0.32,0.6799999999999999)
                                                  //| resultPop1  : Seq[books.cells_to_civilizations.ch1.PopulationDrift3.Marble] 
                                                  //| = Vector(White, White, White, White, White, White, White, White, White, Whit
                                                  //| e, White, White, White, White, White, White, White, White, White, White, Whi
                                                  //| te, White, White, White, White, White, White, White, White, White, White, Wh
                                                  //| ite, Black, Black, Black, Black, Black, Black, Black, Black, White, White, W
                                                  //| hite, White, White, White, White, White, Black, Black, Black, Black, Black, 
                                                  //| Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black,
                                                  //|  White, White, White, White, White, White, White, White, Black, Black, Black
                                                  //| , Black, Black, Black, Black, Black, White, White, White
                                                  //| Output exceeds cutoff limit.
  ratio(resultPop1)                               //> res4: (Double, Double) = (0.504,0.496)
  val resultPop1Length = resultPop1.length        //> resultPop1Length  : Int = 1000
  
  '''                                             //> res5: Char('\'') = '
  
}
/*






*/