package lab.equality

object Equality_lab_1 {
  List(1,2,3) == List(1,2,3)                      //> res0: Boolean = true
  List(1,2,3) == List(1,3,2)                      //> res1: Boolean = false
  List(1,2,3) eq List(1,2,3)                      //> res2: Boolean = false
}