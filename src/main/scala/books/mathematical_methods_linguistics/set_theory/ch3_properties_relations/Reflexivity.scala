package books.mathematical_methods_linguistics.set_theory.ch3_properties_relations

import books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts.SetOperations1._
import books.mathematical_methods_linguistics.set_theory.ch2_relations_functions.Identity._

object Reflexivity {

    /*
     * A relationship in a set that is reflexive contains the ordered pair 
     * <x,x> for every x that is a member of the set. 
     */
    def isReflexive[A](set: Set[A])(rel: Set[(A,A)]): Boolean = {
        isSubset(rel, identityRel(set))
    }
    
    def nonReflexive[A](set: Set[A])(rel: Set[(A,A)]): Boolean = {
        !isReflexive(set)(rel)
    }
    
    def irreflexive[A](set: Set[A])(rel: Set[(A,A)]): Boolean = {
        val identity = identityRel(set)
        rel.forall(r => !identity.contains(r))
    }
}


