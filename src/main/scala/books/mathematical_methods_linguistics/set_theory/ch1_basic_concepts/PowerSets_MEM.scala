package books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts

object PowerSets_MEM {

    def powerMEM[A](s: Set[A]): Set[Set[A]] = {
        def inner(s: Set[A], ps: Set[Set[A]]): Set[Set[A]] = {
            if(s.isEmpty) ps
            else inner(s.tail, (ps ++ ( ps.map(_ + s.head) )))
        }
        inner(s, Set(Set.empty))
    }
}