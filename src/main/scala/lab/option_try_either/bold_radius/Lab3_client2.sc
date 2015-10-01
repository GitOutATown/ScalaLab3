package lab.option_try_either.bold_radius

object Lab3_client2 {
  import lab.option_try_either.bold_radius.Lab2.searchObject2
  import lab.option_try_either.bold_radius.Lab3._
  
  // Using Try. Failure is handled.
  // Code from this iteration doesn't blow up when calls external service
  // and we're able to differentiate between valid results and errors
  (for(i <- 1 to 10) yield searchObject3("id1")).map(out => out match {
    case scala.util.Success(out) => s"(200, ${out.toString()})"
    case scala.util.Failure(f) => s"(500, ${f.getMessage()})"
  })                                              //> res0: scala.collection.immutable.IndexedSeq[String] = Vector((200, Some({"id
                                                  //| ": id1})), (500, Something bad happened), (500, Something bad happened), (20
                                                  //| 0, Some({"id": id1})), (200, Some({"id": id1})), (200, Some({"id": id1})), (
                                                  //| 200, None), (500, Something bad happened), (200, None), (200, Some({"id": id
                                                  //| 1})))


  
  '''                                             //> res1: Char('\'') = '
}