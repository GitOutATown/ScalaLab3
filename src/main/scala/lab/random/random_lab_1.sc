package lab.random

object random_lab_1 {

  math.random                                     //> res0: Double = 0.8468946753401573
  math.random.toLong                              //> res1: Long = 0
  //Thread.sleep((long)(Math.random() * 1000))
  (math.random.toLong) * 1000                     //> res2: Long = 0
  
  scala.util.Random.nextInt(10000)                //> res3: Int = 477
  scala.util.Random.nextInt(10000)                //> res4: Int = 9060
  scala.util.Random.nextInt(10000)                //> res5: Int = 6488
  scala.util.Random.nextInt(10000)                //> res6: Int = 7407
  
  scala.util.Random.nextInt(7000)                 //> res7: Int = 2049
  scala.util.Random.nextInt(7000)                 //> res8: Int = 1588
  scala.util.Random.nextInt(7000)                 //> res9: Int = 1432
  scala.util.Random.nextInt(7000)                 //> res10: Int = 19
  scala.util.Random.nextInt(7000)                 //> res11: Int = 121
  
  scala.util.Random.nextInt(5000)                 //> res12: Int = 828
  scala.util.Random.nextInt(5000)                 //> res13: Int = 3266
  scala.util.Random.nextInt(5000)                 //> res14: Int = 3316
  scala.util.Random.nextInt(5000)                 //> res15: Int = 2365
  scala.util.Random.nextInt(5000)                 //> res16: Int = 4398
  scala.util.Random.nextInt(5000)                 //> res17: Int = 4633
  
  scala.util.Random.nextInt(1000)                 //> res18: Int = 181
  scala.util.Random.nextInt(1000)                 //> res19: Int = 808
  scala.util.Random.nextInt(1000)                 //> res20: Int = 451
  
  scala.util.Random.shuffle(List("how", "are", "you"))
                                                  //> res21: List[String] = List(how, you, are)
  scala.util.Random.shuffle(List("how", "are", "you"))
                                                  //> res22: List[String] = List(are, you, how)
  scala.util.Random.shuffle(List("how", "are", "you"))
                                                  //> res23: List[String] = List(are, how, you)
  scala.util.Random.shuffle(List("how", "are", "you"))
                                                  //> res24: List[String] = List(how, you, are)
}