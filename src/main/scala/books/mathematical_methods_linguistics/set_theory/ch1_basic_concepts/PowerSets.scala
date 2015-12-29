package books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts

object PowerSets {

    // http://stackoverflow.com/questions/11581175/how-to-generate-the-power-set-of-a-set-in-scala
    def power[A](s: Set[A]): Set[Set[A]] = {
        
        @annotation.tailrec
        def pwr(s: Set[A], ps: Set[Set[A]]): Set[Set[A]] =
            if (s.isEmpty) ps
            else pwr(s.tail, ps ++ (ps map (_ + s.head)))
        
        pwr(s, Set(Set.empty[A])) //Powerset of ∅ is {∅}
    }
}