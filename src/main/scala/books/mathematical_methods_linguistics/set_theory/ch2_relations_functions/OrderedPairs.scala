package books.mathematical_methods_linguistics.set_theory.ch2_relations_functions

object OrderedPairs {
    
    // NOT WORKING
    def order[A](s: Set[A]): Set[Set[A]] = {
        // Diagnostic
        s.toList.map{ case e => println(e)}
        
        def inner(s: Set[A], op: Set[Set[A]]): Set[Set[A]] = {
            println("op: " + op)
            if(s.isEmpty) op
            else {
                inner(s.tail, op.map(_ + s.head))
            }
        }
        
        inner(s, Set(Set.empty[A]))
    }
}