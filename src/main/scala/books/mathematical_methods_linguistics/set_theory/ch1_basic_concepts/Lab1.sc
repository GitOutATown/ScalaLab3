package books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts

object Lab1 {

  val s1 = Set.empty                              //> s1  : scala.collection.immutable.Set[Nothing] = Set()
  val s2 = Set('c', 'd', 'e', 'f')                //> s2  : scala.collection.immutable.Set[Char] = Set(c, d, e, f)
  
  s1.map { println(_) }                           //> res0: scala.collection.immutable.Set[Unit] = Set()
  
  s2.map { println(_) }                           //> c
                                                  //| d
                                                  //| e
                                                  //| f
                                                  //| res1: scala.collection.immutable.Set[Unit] = Set(())
  
  s2.head                                         //> res2: Char = c
  s2.tail                                         //> res3: scala.collection.immutable.Set[Char] = Set(d, e, f)

  '''                                             //> res4: Char('\'') = '
}