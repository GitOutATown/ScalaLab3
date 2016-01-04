package books.mathematical_methods_linguistics.set_theory.ch3_properties_relations

import books.mathematical_methods_linguistics.set_theory.ch2_relations_functions.CartesianProduct._
import books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts.SetOperations1._

object Symmetry {

    /*
     * If an ordered pair is in R, then the pair with the members reversed 
     * is also in R. I.e. both <x,y> and <y,x> must exist in the relation.
     */
    def isSym[A](rel: Set[(A,A)]): Boolean = {
        inverse(rel).subsetOf(rel)
    }
    
    // Verifies the relations are constrained to exist in a particular set.
    def isSymConstr[A](set: Set[A])(rel: Set[(A,A)]): Boolean = {
        constrRelToSet(set, rel) // Side effect. TODO: Should be Try
        inverse(rel).subsetOf(rel)
    }
    
    // Uses function to generate relations
    def isSymFunc[A](rel: Set[(A,A)])(f: (A,A) => Boolean): Boolean = {
        inverse(rel).subsetOf(rel filter{ case(a1,a2) => f(a1,a2)})
    }
    
    def isSymFuncConstr[A](rel: Set[(A,A)])(set: Set[A])(f: (A,A) => Boolean): Boolean = {
        constrRelToSet(set, rel) // Side effect. TODO: Should be Try
        val relSym = inverse(rel) filter{ case(a1,a2) => f(a1,a2)}
        relSym.subsetOf(rel)
    }
    
    // Verifies the relations are constrained to exist in a particular set. 
    // Side effect. TODO: Should be Try
    def constrRelToSet[A](set: Set[A], rel: Set[(A,A)]) {
        require((rel.map{ case(a1,a2) => a1}).subsetOf(set))
        require((rel.map{ case(a1,a2) => a2}).subsetOf(set))
    }
    
    // true if no pairs are symmetric
    def isAsym[A](rel: Set[(A,A)]): Boolean = {
        inverse(rel).intersect(rel) == Set.empty
    }
    
    // true if whenever both <x,y> and <y,x> are in the relation x = y.
    def antiSym[A](rel: Set[(A,A)]): Boolean = {
        val res = rel.filter{ case (a, b) => {
            // rel.contains(b, a) && // This logic is more explicit per the books definition, i.e. queries reflexivity, but reflexivity test is not logically necessary.
            (a == b) 
        }}
        !res.isEmpty
    }
}
    
    
    
    