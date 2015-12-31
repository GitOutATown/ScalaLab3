package books.mathematical_methods_linguistics.set_theory.ch2_relations_functions

object Function {
    
    // Maps a relation into domain set A to produce a set from range set B.
    def func[A,B](domain: Set[A])(range: Set[B])(rel: Set[(A,B)]): Set[B] = {
        require(isFunction(domain, range, rel))
        for{
            a <- domain
            ab <- rel
            if a == ab._1
        } yield ab._2
    }

    def isFunction[A,B](domain: Set[A], range: Set[B], rel: Set[(A,B)]): Boolean = {
        val as = rel.toList.map{ case (a,b) => a }
        val bs = rel.toList.map{ case (a,b) => b }
        as.distinct.size == rel.size &&
        as.forall { a => domain.contains(a) } &&
        bs.forall { b => range.contains(b) }
    }
}