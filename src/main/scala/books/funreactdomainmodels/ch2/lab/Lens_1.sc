package books.funreactdomainmodels.ch2.lab

object Lens_1 {

  // Careful! This is just my first whacked experiment with the lens pattern!

  case class Lens[O, V](
	  get: O => V,
	  set: (O, V) => O
	)
	
	val test1 = Lens[String, Int](
	  get = _.toInt,
	  set = (o, v) => o
	)                                         //> test1  : books.funreactdomainmodels.ch2.lab.Lens_1.Lens[String,Int] = Lens(<
                                                  //| function1>,<function2>)
	
	test1.set("foo", 42)                      //> res0: String = foo
	test1.get("foo")                          //> java.lang.NumberFormatException: For input string: "foo"
                                                  //| 	at java.lang.NumberFormatException.forInputString(NumberFormatException.
                                                  //| java:65)
                                                  //| 	at java.lang.Integer.parseInt(Integer.java:492)
                                                  //| 	at java.lang.Integer.parseInt(Integer.java:527)
                                                  //| 	at scala.collection.immutable.StringLike$class.toInt(StringLike.scala:27
                                                  //| 2)
                                                  //| 	at scala.collection.immutable.StringOps.toInt(StringOps.scala:30)
                                                  //| 	at books.funreactdomainmodels.ch2.lab.Lens_1$$anonfun$main$1$$anonfun$1.
                                                  //| apply(books.funreactdomainmodels.ch2.lab.Lens_1.scala:13)
                                                  //| 	at books.funreactdomainmodels.ch2.lab.Lens_1$$anonfun$main$1$$anonfun$1.
                                                  //| apply(books.funreactdomainmodels.ch2.lab.Lens_1.scala:13)
                                                  //| 	at books.funreactdomainmodels.ch2.lab.Lens_1$$anonfun$main$1.apply$mcV$s
                                                  //| p(books.funreactdomainmodels.ch2.lab.Lens_1.scala:18)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.li
                                                  //| Output exceeds cutoff limit.

  '''
}