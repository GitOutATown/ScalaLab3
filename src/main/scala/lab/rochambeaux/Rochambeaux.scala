package lab.rochambeaux

case class Player(val choice: Choice) {
    val self = this
    def compare(that: Player): Player = 
        (self.choice compare that.choice) match {
            case self.choice => self
            case that.choice => that
            case _ => Rochambeaux.draw
        }
}

trait Choice {
    val self = this
    def compare(that: Choice): Choice 
}

object ROCK extends Choice {
    def compare(that: Choice): Choice = that match {
        case PAPER => that
        case SISSORS => self
        case _ => DRAW
    }
}

object PAPER extends Choice {
    def compare(that: Choice): Choice = that match {
        case SISSORS => that
        case ROCK => self
        case _ => DRAW
    }
}

object SISSORS extends Choice {
    def compare(that: Choice): Choice = that match {
        case ROCK => that
        case PAPER => self
        case _ => DRAW
    }
}

object DRAW extends Choice {
    def compare(that: Choice) = self
}

object Rochambeaux {
    
    def winner(p1: Player, p2: Player): Player = {
        p1 compare p2
    }
    
    val draw = Player(DRAW)
}




