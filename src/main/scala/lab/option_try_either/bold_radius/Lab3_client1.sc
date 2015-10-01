package lab.option_try_either.bold_radius

object Lab3_client1 {
  import lab.option_try_either.bold_radius.Lab2.searchObject2
  import lab.option_try_either.bold_radius.Lab3._

  // Not using Try. Exception is expected here and causes crash.
  (for(i <- 1 to 10) yield searchObject2("id1"))
    .map(out => s"(200, ${out.toString()})")      //> java.lang.Exception: Something bad happened
                                                  //| 	at lab.option_try_either.bold_radius.Lab3$MaybeWithExceptionObjectServic
                                                  //| e$.getObject(Lab3.scala:15)
                                                  //| 	at lab.option_try_either.bold_radius.Lab2$.searchObject2(Lab2.scala:19)
                                                  //| 	at lab.option_try_either.bold_radius.Lab3_client1$$anonfun$main$1$$anonf
                                                  //| un$1.apply(lab.option_try_either.bold_radius.Lab3_client1.scala:8)
                                                  //| 	at lab.option_try_either.bold_radius.Lab3_client1$$anonfun$main$1$$anonf
                                                  //| un$1.apply(lab.option_try_either.bold_radius.Lab3_client1.scala:8)
                                                  //| 	at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike
                                                  //| .scala:245)
                                                  //| 	at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike
                                                  //| .scala:245)
                                                  //| 	at scala.collection.immutable.Range.foreach(Range.scala:166)
                                                  //| 	at scala.collection.TraversableLike$class.map(TraversableLike.scala:245)
                                                  //| 
                                                  //| 	at scala.collection.AbstractTraversable.map(Traversable.scala:104)
                                                  //| 	at lab.option_try_either.bold_radius.Lab3_client1$$an
                                                  //| Output exceeds cutoff limit.

  '''
}
/*


*/