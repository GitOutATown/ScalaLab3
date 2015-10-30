package lab.types.advanced

object HigherKinds {
    
    trait Container[M[_]] { 
        def put[A](x: A): M[A] 
        def get[A](m: M[A]): A 
    }

    val container = new Container[List] { 
        def put[A](x: A) = List(x)
        def get[A](m: List[A]) = m.head 
    }
}