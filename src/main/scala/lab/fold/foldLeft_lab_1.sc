package lab.fold

object foldLeft_lab_1 {

  List(1, 2, 3).foldLeft(0)((acc, x) => acc + x)  //> res0: Int = 6
  
  List(1, 2, 3).foldLeft(0)((acc, x) => {
    println("acc:" + acc + " x:" + x)
    acc + x
  })                                              //> acc:0 x:1
                                                  //| acc:1 x:2
                                                  //| acc:3 x:3
                                                  //| res1: Int = 6

  '''                                             //> res2: Char('\'') = '
}