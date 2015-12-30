package books.mathematical_methods_linguistics.set_theory.ch2_relations_functions

object CartesianProduct {
    
    def cartProd[A,B](s1: Set[A], s2: Set[B]): Set[(A,B)] = {
        for{
            k <- s1
            l <- s2
        } yield (k,l)
    }

    /*
     * Determines smallest cartesian product of which s is a subset of.
     */
     def smallest[A,B](s: Set[(A,B)]): (Set[A], Set[B]) = {
         val coord1 = s.map{ case (a, b) => a }
         val coord2 = s.map{ case (a, b) => b }
         (coord1, coord2)
     }
}