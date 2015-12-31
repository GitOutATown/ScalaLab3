package books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts

object SetOperations1 {
    
    // pseudo compliment, curried for partial function set up
    def compliment[A](universe: Set[A])(s: Set[A]): Set[A] = {
        universe -- s
    }
    
    def isSubset[A](container: Set[A], sub: Set[A]): Boolean = {
        (sub union container) == container &&
        (sub intersect container) == sub
    }
}