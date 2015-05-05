package lab.monad

object flatten_test {
	
	// http://scabl.blogspot.com/2013/02/monads-in-scala-1.html

	// Error behavior as expected
	// Just(1).flatten
	
	Person.persons foreach { p =>
	  assert(Just(Just(p)).flatten == Just(p))
	}
  
	assert(Just(MaybeNot).flatten == MaybeNot)
 
	assert(MaybeNot.flatten == MaybeNot)
	
	Just("foo")                               //> res0: lab.monad.Just[String] = Just(foo)
	Just(Just("foo"))                         //> res1: lab.monad.Just[lab.monad.Just[String]] = Just(Just(foo))
	Just(Just("foo")).flatten                 //> res2: lab.monad.Maybe[String] = Just(foo)
	// flatten does not automatically recurse
	Just(Just(Just("foo"))).flatten           //> res3: lab.monad.Maybe[lab.monad.Just[String]] = Just(Just(foo))
	Just(Just(Just("foo")).flatten).flatten   //> res4: lab.monad.Maybe[String] = Just(foo)
	// Just("foo").flatten // error
	
	'''                                       //> res5: Char('\'') = '
}