package lab.typesystem.parameterization.twitter

object ParametricPolymorphism_1 {

	2 :: 1 :: "bar" :: "foo" :: Nil           //> res0: List[Any] = List(2, 1, bar, foo)
	
	def drop1b[A](list: List[A]) = list.tail  //> drop1b: [A](list: List[A])List[A]
	
	drop1b(List('a', 'b', 'c'))               //> res1: List[Char] = List(b, c)
	drop1b(List(0.7, 0.8, 1.1))               //> res2: List[Double] = List(0.8, 1.1)
	drop1b(List("cat", 3.0)) // So the type parameterization doesn't really make much difference! What it does do is allow for genericism/polymorphism
                                                  //> res3: List[Any] = List(3.0)
	List('a', 'b', 'c').tail                  //> res4: List[Char] = List(b, c)
}