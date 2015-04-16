package lab.collections

object Streams_lab_1 {

	val xs1 = Stream(1, 2, 3)                 //> xs1  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
	val xs2 = Stream.cons(1, Stream.cons(2, Stream.cons(3, Stream.empty))) // same as above
                                                  //> xs2  : Stream.Cons[Int] = Stream(1, ?)
	val xs3 = (2 to 1000000000).toStream      //> xs3  : scala.collection.immutable.Stream[Int] = Stream(2, ?)
	val x = 1                                 //> x  : Int = 1
	x #:: xs3                                 //> res0: scala.collection.immutable.Stream[Int] = Stream(1, ?)
					// Same as Stream.cons(x, xs)
         	// In the Stream's cons operator, the second parameter (the tail)
         	// is defined as a "call by name" parameter.
         	// Note that x::xs always produces a List
  '''                                             //> res1: Char('\'') = '
}