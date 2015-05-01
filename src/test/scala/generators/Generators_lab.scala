package generators

object Generators_lab {
  
  val list1 = List(1,2,3)
  val list2 = List('a', 'b', 'c')
  
  for { // map
    n <- list1 // map
  } yield n
  
  for { // flatMap
    num <- list1 // flatMap
    alpha <- list2 // map
  } yield (num, alpha)
  
  for( // foreach
      i <- 0 until 5 // foreach
  ) println(i)

}