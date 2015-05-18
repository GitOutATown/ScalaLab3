package lab.random

object random_lab_1 {

  math.random                                     //> res0: Double = 0.7053912041437841
  math.random.toLong                              //> res1: Long = 0
  //Thread.sleep((long)(Math.random() * 1000))
  (math.random.toLong) * 1000                     //> res2: Long = 0
  
  scala.util.Random.nextInt(10000)                //> res3: Int = 3931
  scala.util.Random.nextInt(10000)                //> res4: Int = 3360
  scala.util.Random.nextInt(10000)                //> res5: Int = 8358
  scala.util.Random.nextInt(10000)                //> res6: Int = 3329
  
  scala.util.Random.nextInt(7000)                 //> res7: Int = 2407
  scala.util.Random.nextInt(7000)                 //> res8: Int = 6933
  scala.util.Random.nextInt(7000)                 //> res9: Int = 856
  scala.util.Random.nextInt(7000)                 //> res10: Int = 1279
  scala.util.Random.nextInt(7000)                 //> res11: Int = 5657
  
  scala.util.Random.nextInt(5000)                 //> res12: Int = 862
  scala.util.Random.nextInt(5000)                 //> res13: Int = 4997
  scala.util.Random.nextInt(5000)                 //> res14: Int = 1859
  scala.util.Random.nextInt(5000)                 //> res15: Int = 2369
  scala.util.Random.nextInt(5000)                 //> res16: Int = 1688
  scala.util.Random.nextInt(5000)                 //> res17: Int = 3657
  
  scala.util.Random.nextInt(1000)                 //> res18: Int = 800
  scala.util.Random.nextInt(1000)                 //> res19: Int = 60
  scala.util.Random.nextInt(1000)                 //> res20: Int = 250
}