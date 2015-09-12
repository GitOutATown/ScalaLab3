package lab.typesystem.variance

/*
 * https://twitter.github.io/scala_school/type-basics.html
 */
object Variance_lab_1 {

  // VARIANCE
  
  class Covariant[+A]
  
  val cv: Covariant[AnyRef] = new Covariant[String]
                                                  //> cv  : lab.typesystem.variance.Variance_lab_1.Covariant[AnyRef] = lab.typesys
                                                  //| tem.variance.Variance_lab_1$Covariant@72a61373
  
  // ERROR: type mismatch; found : lab.typesystem.variance.Variance_lab_1.Covariant[AnyRef]  required: lab.typesystem.variance.Variance_lab_1.Covariant[String]
  // val fail: Covariant[String] = new Covariant[AnyRef]
  
  class Contravariant[-A]
  
  val cv3: Contravariant[String] = new Contravariant[AnyRef]
                                                  //> cv3  : lab.typesystem.variance.Variance_lab_1.Contravariant[String] = lab.ty
                                                  //| pesystem.variance.Variance_lab_1$$anonfun$main$1$Contravariant$1@3d35cda0
  // type mismatch; found : lab.typesystem.variance.Variance_lab_1.Contravariant[String]  required: lab.typesystem.variance.Variance_lab_1.Contravariant[AnyRef]
  // val fail: Contravariant[AnyRef] = new Contravariant[String]

  // Contravariance seems strange. When is it used? Somewhat surprising!
  trait Function1 [-T1, +R] extends AnyRef
  
  // If you think about this from the point of view of substitution, it makes a lot of sense. Let’s first define a simple class hierarchy:
  class Animal { val sound = "rustle" }
  class Bird extends Animal { override val sound = "call" }
  class Chicken extends Bird { override val sound = "cluck" }
  val getTweet: (Bird => String) = ((a: Animal) => a.sound )
                                                  //> getTweet  : lab.typesystem.variance.Variance_lab_1.Bird => String = <functi
                                                  //| on1>
  // function parameters are contravariant
  // ERROR: type mismatch;  found   : lab.typesystem.variance.Variance_lab_1.Chicken => String  required: lab.typesystem.variance.Variance_lab_1.Bird => String
  // val fail: (Bird => String) = ((a: Chicken) => a.sound )
  // ERROR: type mismatch;  found   : lab.typesystem.variance.Variance_lab_1.Bird => String  required: lab.typesystem.variance.Variance_lab_1.Animal => String
  // val fail: (Animal => String) = ((a: Bird) => a.sound )
  
  // A function’s return value type is covariant.
  val hatch: (() => Bird) = (() => new Chicken )  //> hatch  : () => lab.typesystem.variance.Variance_lab_1.Bird = <function0>
  
  // BOUNDS
  // Scala allows you to restrict polymorphic variables using bounds. These bounds express subtype relationships.
  
  // ERROR: value sound is not a member of type parameter T
  // def cacophony[T](things: Seq[T]) = things map (_.sound)
  
  def biophony[T <: Animal](things: Seq[T]) = things map (_.sound)
                                                  //> biophony: [T <: lab.typesystem.variance.Variance_lab_1.Animal](things: Seq[
                                                  //| T])Seq[String]
  biophony(Seq(new Chicken, new Bird))            //> res0: Seq[String] = List(cluck, call)
  
  val flock = List(new Bird, new Bird)            //> flock  : List[lab.typesystem.variance.Variance_lab_1.Bird] = List(lab.types
                                                  //| ystem.variance.Variance_lab_1$$anonfun$main$1$Bird$1@498b3b74, lab.typesyst
                                                  //| em.variance.Variance_lab_1$$anonfun$main$1$Bird$1@53ec6264)
  val oddFlock = new Chicken :: flock             //> oddFlock  : List[lab.typesystem.variance.Variance_lab_1.Bird] = List(lab.ty
                                                  //| pesystem.variance.Variance_lab_1$$anonfun$main$1$Chicken$1@442fbe47, lab.ty
                                                  //| pesystem.variance.Variance_lab_1$$anonfun$main$1$Bird$1@498b3b74, lab.types
                                                  //| ystem.variance.Variance_lab_1$$anonfun$main$1$Bird$1@53ec6264)
  new Animal :: flock                             //> res1: List[lab.typesystem.variance.Variance_lab_1.Animal] = List(lab.typesy
                                                  //| stem.variance.Variance_lab_1$$anonfun$main$1$Animal$1@1a754a4a, lab.typesys
                                                  //| tem.variance.Variance_lab_1$$anonfun$main$1$Bird$1@498b3b74, lab.typesystem
                                                  //| .variance.Variance_lab_1$$anonfun$main$1$Bird$1@53ec6264)
  
  new Animal :: oddFlock                          //> res2: List[lab.typesystem.variance.Variance_lab_1.Animal] = List(lab.typesy
                                                  //| stem.variance.Variance_lab_1$$anonfun$main$1$Animal$1@a604dd8, lab.typesyst
                                                  //| em.variance.Variance_lab_1$$anonfun$main$1$Chicken$1@442fbe47, lab.typesyst
                                                  //| em.variance.Variance_lab_1$$anonfun$main$1$Bird$1@498b3b74, lab.typesystem.
                                                  //| variance.Variance_lab_1$$anonfun$main$1$Bird$1@53ec6264)
  '''                                             //> res3: Char('\'') = '
}
/*





*/