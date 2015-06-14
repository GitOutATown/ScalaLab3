package books.cells_to_civilizations.ch1

import scala.util.Random

object population_drift_lab_2 {

  trait Marble
  case object Black extends Marble
  case object White extends Marble
  
  val blackPop = for(i <- 1 to 500) yield Black   //> blackPop  : scala.collection.immutable.IndexedSeq[books.cells_to_civilizatio
                                                  //| ns.ch1.population_drift_lab_2.Black.type] = Vector(Black, Black, Black, Blac
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
  val whitePop = for(i <- 1 to 500) yield White   //> whitePop  : scala.collection.immutable.IndexedSeq[books.cells_to_civilizatio
                                                  //| ns.ch1.population_drift_lab_2.White.type] = Vector(White, White, White, Whit
                                                  //| e, White, White, White, White, White, White, White, White, White, White, Whi
                                                  //| te, White, White, White, White, White, White, White, White, White, White, Wh
                                                  //| ite, White, White, White, White, White, White, White, White, White, White, W
                                                  //| hite, White, White, White, White, White, White, White, White, White, White, 
                                                  //| White, White, White, White, White, White, White, White, White, White, White,
                                                  //|  White, White, White, White, White, White, White, White, White, White, White
                                                  //| , White, White, White, White, White, White, White, White, White, White, Whit
                                                  //| e, White, White, White, White, White, White, White, White, White, White, Whi
                                                  //| te, White, White, White, White, White, White, White, White, White, White, Wh
                                                  //| ite, White, White, White, White, White, White, White, White, White, White, W
                                                  //| hite, White, White, Whit
                                                  //| Output exceeds cutoff limit.
  
  val mixedPop = blackPop ++ whitePop             //> mixedPop  : scala.collection.immutable.IndexedSeq[Product with Serializable 
                                                  //| with books.cells_to_civilizations.ch1.population_drift_lab_2.Marble] = Vecto
                                                  //| r(Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Blac
                                                  //| k, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Bla
                                                  //| ck, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Bl
                                                  //| ack, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, B
                                                  //| lack, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, 
                                                  //| Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black,
                                                  //|  Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black
                                                  //| , Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Blac
                                                  //| k, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Bla
                                                  //| ck, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Bl
                                                  //| ack, Black, Black, Black
                                                  //| Output exceeds cutoff limit.
  
  mixedPop.length                                 //> res0: Int = 1000
  
  val shuf1 = Random.shuffle(mixedPop)            //> shuf1  : scala.collection.immutable.IndexedSeq[Product with Serializable wit
                                                  //| h books.cells_to_civilizations.ch1.population_drift_lab_2.Marble] = Vector(B
                                                  //| lack, Black, Black, Black, Black, Black, Black, Black, Black, Black, White, 
                                                  //| Black, White, Black, White, White, White, White, Black, White, Black, Black,
                                                  //|  Black, Black, Black, Black, White, White, White, White, Black, Black, White
                                                  //| , White, Black, Black, White, White, Black, Black, White, Black, Black, Whit
                                                  //| e, Black, White, Black, White, Black, Black, Black, Black, Black, White, Bla
                                                  //| ck, Black, Black, Black, White, White, Black, Black, White, White, White, Wh
                                                  //| ite, White, White, White, Black, White, Black, Black, White, Black, Black, W
                                                  //| hite, Black, White, Black, Black, White, Black, Black, Black, Black, Black, 
                                                  //| Black, Black, Black, White, White, Black, Black, Black, Black, Black, Black,
                                                  //|  White, White, Black, White, White, White, Black, White, Black, White, Black
                                                  //| , Black, White, Black, W
                                                  //| Output exceeds cutoff limit.
  
  val select1 = shuf1.take(100)                   //> select1  : scala.collection.immutable.IndexedSeq[Product with Serializable w
                                                  //| ith books.cells_to_civilizations.ch1.population_drift_lab_2.Marble] = Vector
                                                  //| (Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, White
                                                  //| , Black, White, Black, White, White, White, White, Black, White, Black, Blac
                                                  //| k, Black, Black, Black, Black, White, White, White, White, Black, Black, Whi
                                                  //| te, White, Black, Black, White, White, Black, Black, White, Black, Black, Wh
                                                  //| ite, Black, White, Black, White, Black, Black, Black, Black, Black, White, B
                                                  //| lack, Black, Black, Black, White, White, Black, Black, White, White, White, 
                                                  //| White, White, White, White, Black, White, Black, Black, White, Black, Black,
                                                  //|  White, Black, White, Black, Black, White, Black, Black, Black, Black, Black
                                                  //| , Black, Black, Black, White, White, Black, Black, Black, Black, Black, Blac
                                                  //| k, White, White)
  
  def ratio(group: Seq[Marble]): (Double, Double) = {
    val black = group.filter(m => m == Black)
    val ratioBlk = black.length.toDouble / group.length.toDouble
    val ratioWht = 1d - ratioBlk
    (ratioBlk, ratioWht)
  }                                               //> ratio: (group: Seq[books.cells_to_civilizations.ch1.population_drift_lab_2.M
                                                  //| arble])(Double, Double)
  
  ratio(select1)                                  //> res1: (Double, Double) = (0.62,0.38)
  
  // Recursive
  def duplicate(group: Seq[Marble])(limit: Int): Seq[Marble] = {
    val result = group.flatMap(m => m match {
      case Black => Seq(Black, Black)
      case White => Seq(White, White)
    })
    
    result
  }                                               //> duplicate: (group: Seq[books.cells_to_civilizations.ch1.population_drift_lab
                                                  //| _2.Marble])(limit: Int)Seq[books.cells_to_civilizations.ch1.population_drift
                                                  //| _lab_2.Marble]
  
  val dup1 = duplicate(select1)(1000)             //> dup1  : Seq[books.cells_to_civilizations.ch1.population_drift_lab_2.Marble] 
                                                  //| = Vector(Black, Black, Black, Black, Black, Black, Black, Black, Black, Blac
                                                  //| k, Black, Black, Black, Black, Black, Black, Black, Black, Black, Black, Whi
                                                  //| te, White, Black, Black, White, White, Black, Black, White, White, White, Wh
                                                  //| ite, White, White, White, White, Black, Black, White, White, Black, Black, B
                                                  //| lack, Black, Black, Black, Black, Black, Black, Black, Black, Black, White, 
                                                  //| White, White, White, White, White, White, White, Black, Black, Black, Black,
                                                  //|  White, White, White, White, Black, Black, Black, Black, White, White, White
                                                  //| , White, Black, Black, Black, Black, White, White, Black, Black, Black, Blac
                                                  //| k, White, White, Black, Black, White, White, Black, Black, White, White, Bla
                                                  //| ck, Black, Black, Black, Black, Black, Black, Black, Black, Black, White, Wh
                                                  //| ite, Black, Black, Black, Black, Black, Black, Black, Black, White, White, W
                                                  //| hite, White, Black, Blac
                                                  //| Output exceeds cutoff limit.
  dup1.length                                     //> res2: Int = 200
  ratio(dup1)                                     //> res3: (Double, Double) = (0.62,0.38)

  '''                                             //> res4: Char('\'') = '
}
/*






*/