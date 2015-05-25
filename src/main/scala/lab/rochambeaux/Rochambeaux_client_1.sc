package lab.rochambeaux

import Rochambeaux._

object Rochambeaux_client_1 {

  val p1 = Play(PAPER)                            //> p1  : lab.rochambeaux.Play = Play(lab.rochambeaux.PAPER$@3a962da5)
  val p2 = Play(PAPER)                            //> p2  : lab.rochambeaux.Play = Play(lab.rochambeaux.PAPER$@3a962da5)
  play(p1, p2)                                    //> res0: lab.rochambeaux.Play = Play(lab.rochambeaux.DRAW$@62811340)
  
  val mike = Player("Mike")                       //> mike  : lab.rochambeaux.Player = Player(Mike)
  val mary = Player("Mary")                       //> mary  : lab.rochambeaux.Player = Player(Mary)
  mike choose()                                   //> res1: lab.rochambeaux.Play = Play(lab.rochambeaux.ROCK$@4ee42af2)
  mike choose()                                   //> res2: lab.rochambeaux.Play = Play(lab.rochambeaux.ROCK$@4ee42af2)
  play(mike choose, mary choose)                  //> res3: lab.rochambeaux.Play = Play(lab.rochambeaux.PAPER$@3a962da5)
}