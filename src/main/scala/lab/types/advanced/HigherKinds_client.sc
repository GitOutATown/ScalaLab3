package lab.types.advanced

object HigherKinds_client {
  import HigherKinds._

  container.put("hey")                            //> res0: List[String] = List(hey)
  container.put(123)                              //> res1: List[Int] = List(123)
}