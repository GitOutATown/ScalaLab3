package books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts

object PowerSets_diagnostic {

    // http://stackoverflow.com/questions/11581175/how-to-generate-the-power-set-of-a-set-in-scala
    def powerDiag[A](s: Set[A]): Set[Set[A]] = {
        
        @annotation.tailrec
        def pwr(s: Set[A], ps: Set[Set[A]]): Set[Set[A]] = {
            println("-----------------------")
            println("s: " + s)
            if (s.isEmpty) {
                println("s is empty. Returning ps...")
                ps
            }
            else {
                println("s.head: " + s.head + "\ns.tail: " + s.tail + "\nps: " + ps)
                val acc1 = ps map (_ + s.head)
                println("ps map (_ + s.head): " + acc1)
                val acc2 = ps ++ acc1
                println("ps ++ (ps map (_ + s.head)): " + acc2)
                pwr(s.tail, acc2)
            }
        }
        
        pwr(s, Set(Set.empty[A])) //Powerset of ∅ is {∅}
    }
}