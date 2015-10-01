package lab.option_try_either.bold_radius

object Lab2_client1 {
  import lab.option_try_either.bold_radius.Lab2._

  (for(i <- 1 to 10) yield searchObject2("id1"))
      .map(out => s"(200, ${out.toString()})")    //> res0: scala.collection.immutable.IndexedSeq[String] = Vector((200, None), (2
                                                  //| 00, None), (200, Some({"id": id1})), (200, Some({"id": id1})), (200, Some({"
                                                  //| id": id1})), (200, None), (200, None), (200, Some({"id": id1})), (200, Some(
                                                  //| {"id": id1})), (200, Some({"id": id1})))

  '''                                             //> res1: Char('\'') = '
}