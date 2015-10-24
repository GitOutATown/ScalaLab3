package lab.fold

object foldRight_lab_1 {

  List(1, 2, 3).foldRight(0)((x, acc) => acc + x) //> res0: Int = 6
  
  List(1, 2, 3).foldRight(0)((x, acc) => {
    println("acc:" + acc + " x:" + x)
    acc + x
  })                                              //> acc:0 x:3
                                                  //| acc:3 x:2
                                                  //| acc:5 x:1
                                                  //| res1: Int = 6

  '''                                             //> res2: Char('\'') = '
}