package lab.enumeration_type.rochambeaux

object Rochambeaux extends Enumeration {
    type Rochambeaux = Value
    val ROCK, PAPER, SISSORS = Value
    
    val choiceMap = Map[String, Rochambeaux.Value] (
            "ROCK" -> Rochambeaux.ROCK,
            "PAPER" -> Rochambeaux.PAPER,
            "SISSORS" -> Rochambeaux.SISSORS
    )
    
    def apply(choice: String) = {
        choiceMap(choice)
    }
    
    def game() = {
        
    }
    
    def winner(player1: Value, player2: Value) = {
        (player1, player2) match {
            case (ROCK, PAPER) =>
            case (ROCK, SISSORS) =>
            case (ROCK, ROCK) =>
            case (PAPER, ROCK) =>
        }
    }
}