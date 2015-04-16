package lab.collections

object Vector_lab {

	val nums = Vector("louis", "frank", "hiromi")
                                                  //> nums  : scala.collection.immutable.Vector[String] = Vector(louis, frank, hiro
                                                  //| mi)
  // complexity O(log(n))
	nums(1)                                   //> res0: String = frank
	
	// new vector with a different string at index 2, complexity O(log(n))
	val nums2 = nums.updated(2, "helena")     //> nums2  : scala.collection.immutable.Vector[String] = Vector(louis, frank, he
                                                  //| lena)
	
	nums                                      //> res1: scala.collection.immutable.Vector[String] = Vector(louis, frank, hirom
                                                  //| i)
  nums2                                           //> res2: scala.collection.immutable.Vector[String] = Vector(louis, frank, helen
                                                  //| a)
	
	'''                                       //> res3: Char('\'') = '
}