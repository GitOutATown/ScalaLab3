package lab.rochambeaux

import Rochambeaux._

object Rochambeaux_client_1 {
  
  val mike = Player("Mike")                       //> mike  : lab.rochambeaux.Player = Player(Mike)
  val mary = Player("Mary")                       //> mary  : lab.rochambeaux.Player = Player(Mary)
  play(mike, mary)                                //> res0: String = DRAW
  play(mary, mike)                                //> res1: String = Mike
  play(mike, mary)                                //> res2: String = Mike
  
  for (i <- 1 until 10) println(play(mike, mary)) //> DRAW
                                                  //| Mike
                                                  //| Mike
                                                  //| Mike
                                                  //| Mary
                                                  //| Mike
                                                  //| Mike
                                                  //| DRAW
                                                  //| DRAW
}