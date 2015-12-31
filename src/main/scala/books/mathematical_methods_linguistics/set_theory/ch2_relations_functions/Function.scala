package books.mathematical_methods_linguistics.set_theory.ch2_relations_functions

object Function {
    
    // Maps a relation into domain set A to produce a set from range set B.
    // Requires proper function mapping.
    def func[A,B](domain: Set[A])(range: Set[B])(rel: Set[(A,B)]): Set[B] = {
        require(isFunction(domain, range, rel))
        for{
            a <- domain
            ab <- rel
            if a == ab._1
        } yield ab._2
    }
    
    // Maps a relation into domain set A to produce a set from range set B.
    def relation[A,B](domain: Set[A])(range: Set[B])(rel: Set[(A,B)]): Set[B] = {
        require(relExists(domain, range, rel))
        for{
            a <- domain
            ab <- rel
            if a == ab._1
        } yield ab._2
    }
    
    def composeRel[A,B](domain: Set[A])(range: Set[B])(rel: Set[(A,B)]): Set[(A,B)] = {
        //require(relExists(domain, range, rel))
        for{
            a <- domain
            ab <- rel
            if a == ab._1
        } yield ab
    }
    
    def composeRel2[A,B](rel1: Set[(A,B)], rel2: Set[(A,B)]): Set[(A,B)] = {
        for{
            (a1, b1) <- rel1
            (a2, b2) <- rel2
            if b1 == a2
        } yield (a1, b2)
    }

    // verify proper function mapping
    def isFunction[A,B](domain: Set[A], range: Set[B], rel: Set[(A,B)]): Boolean = {
        val as = rel.toList.map{ case (a,b) => a }
        val bs = rel.toList.map{ case (a,b) => b }
        as.distinct.size == rel.size &&
        as.forall { a => domain.contains(a) } &&
        bs.forall { b => range.contains(b) }
    }
    
    // verify relation exists in domain and range
    def relExists[A,B](domain: Set[A], range: Set[B], rel: Set[(A,B)]): Boolean = {
        val as = rel.toList.map{ case (a,b) => a }
        val bs = rel.toList.map{ case (a,b) => b }
        as.forall { a => domain.contains(a) } &&
        bs.forall { b => range.contains(b) }
    }
    
    def range[A,B](rel: Set[(A,B)]): Set[B] = {
        rel.map{ case (a,b) => b }
    }
}