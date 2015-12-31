package books.mathematical_methods_linguistics.set_theory.ch3_properties_relations

object Reflexivity {

    /*
     * A relationship in a set that is reflexive contains the ordered pair 
     * <x,x> for every x that is a member of the set. 
     */
    def isReflexive[A](s: Set[A])(r: Set[(A,A)]): Boolean = {
        s.forall { a => r.contains(a, a) }
    }
}