package books.mathematical_methods_linguistics.set_theory.ch3_properties_relations

import books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts.SetOperations1._
import books.mathematical_methods_linguistics.set_theory.ch2_relations_functions.Identity._
import books.mathematical_methods_linguistics.set_theory.ch2_relations_functions.CartesianProduct._

object Reflexivity {

    /*
     * A relationship in a set that is reflexive contains the ordered pair 
     * <x,x> for every x that is a member of the set. 
     */
    def isReflexive[A](set: Set[A])(rel: Set[(A,A)]): Boolean = {
        isSubset(rel, identityRel(set)) // (container, subset)
    }
    
    // Uses function to generate relations
    def isReflexFunc[A](set: Set[A])(f: (A,A) => Boolean): Boolean = {
        val rel = {
            val allCombos = cartProd(set, set)
            allCombos filter{ case(a1,a2) => f(a1,a2)}
        }
        isSubset(rel, identityRel(set)) // (container, subset)
    }
    
    // true if not all relations are reflexive
    def nonReflexive[A](set: Set[A])(rel: Set[(A,A)]): Boolean = {
        !isReflexive(set)(rel)
    }
    
    // Uses function to generate relations
    def nonReflexFunc[A](set: Set[A])(f: (A,A) => Boolean): Boolean = {
        !isReflexFunc(set)(f)
    }
    
    // true if no relations are reflexive
    def irreflexive[A](set: Set[A])(rel: Set[(A,A)]): Boolean = {
        val identity = identityRel(set)
        rel.intersect(identity) == Set.empty
    }
    
    /*
     * true if no relations are reflexive
     * Uses function to generate relations
     */
    def irreflexFunc[A](set: Set[A])(f: (A,A) => Boolean): Boolean = {
        val rel = {
            val allCombos = cartProd(set, set)
            allCombos filter{ case(a1,a2) => f(a1,a2)}
        }
        irreflexive(set)(rel)
    }
}


