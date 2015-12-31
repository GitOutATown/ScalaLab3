package books.mathematical_methods_linguistics.set_theory.ch2_relations_functions

object Identity {
    
    // Produces reflexive relation
    def identityRel[A](s: Set[A]): Set[(A,A)] = {
        s.map(a => (a,a))
    }
    
    // Produces identity element
    def identityElem[A](a: A): A = a
    
    // Produces identity set
    def identitySet[A](s: Set[A]): Set[A] = {
        s.map(a => a)
    }

}