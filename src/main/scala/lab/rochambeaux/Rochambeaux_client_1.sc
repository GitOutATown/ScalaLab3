package lab.rochambeaux

object Rochambeaux_client_1 {

  val p1 = Player(ROCK)                           //> p1  : lab.rochambeaux.Player = Player(lab.rochambeaux.ROCK$@3ecc52fc)
  val p2 = Player(SISSORS)                        //> p2  : lab.rochambeaux.Player = Player(lab.rochambeaux.SISSORS$@1cb2e0be)
  Rochambeaux.winner(p1, p2)                      //> res0: lab.rochambeaux.Player = Player(lab.rochambeaux.ROCK$@3ecc52fc)
}