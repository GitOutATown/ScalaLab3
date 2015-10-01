package lab.option_try_either.bold_radius

object Lab4_client1 {
  import lab.option_try_either.bold_radius.Lab4._

  // Generate sample ids
  val ids = for(i <- 1 to 20)
    yield if(scala.util.Random.nextInt(2) == 0) "id1" else "invalid"
                                                  //> ids  : scala.collection.immutable.IndexedSeq[String] = Vector(invalid, id1, 
                                                  //| invalid, id1, id1, id1, id1, id1, invalid, invalid, invalid, id1, id1, inval
                                                  //| id, id1, id1, id1, invalid, id1, id1)
  
  // Code from this iteration doesn't blow up when it calls external service;
  // We're able to differentiate between valid results and errors
  // and we can easy handle invalid input with no need to parse exceptions.
  ids.map(searchObject4(_)).map(out => out match {
    case scala.util.Left(scala.util.Failure(f)) => s"(500, ${f.getMessage()})"
    case scala.util.Left(scala.util.Success(Some(out))) => s"(200, ${out.toString()})"
    case scala.util.Left(scala.util.Success(None)) => "(404)" //can be 200 with empty result or more granulated 404
    case scala.util.Right(InternalError(1000)) => "(400, input id must start with 'id')"//internalize
    case scala.util.Right(InternalError(_)) => "(400, Better check your input')"// gap in implementation, new error somewhere deeper in the code
  })                                              //> res0: scala.collection.immutable.IndexedSeq[String] = Vector((400, input id
                                                  //|  must start with 'id'), (200, {"id": id1}), (400, input id must start with 
                                                  //| 'id'), (404), (404), (404), (200, {"id": id1}), (200, {"id": id1}), (400, i
                                                  //| nput id must start with 'id'), (400, input id must start with 'id'), (400, 
                                                  //| input id must start with 'id'), (200, {"id": id1}), (404), (400, input id m
                                                  //| ust start with 'id'), (404), (404), (200, {"id": id1}), (400, input id must
                                                  //|  start with 'id'), (200, {"id": id1}), (200, {"id": id1}))
    
  
  
  '''                                             //> res1: Char('\'') = '
  
}