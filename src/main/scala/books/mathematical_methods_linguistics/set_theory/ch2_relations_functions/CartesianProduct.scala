package books.mathematical_methods_linguistics.set_theory.ch2_relations_functions

object CartesianProduct {
    
     def cartProd[A,B](s1: Set[A], s2: Set[B]): Set[(A,B)] = {
         for{
             k <- s1
             l <- s2
         } yield (k,l)
     }

    // def smallest(Set)
}