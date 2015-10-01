package lab.option_try_either.bold_radius

object Lab3 {
    import lab.option_try_either.bold_radius.Lab1.{MyObject}
    import lab.option_try_either.bold_radius.Lab2.{ObjectService2T, searchObject2}

    /** With Try *****************/
        
    // Service that (randomly) returns object or empty, sometimes exception occures 
    implicit object MaybeWithExceptionObjectService extends ObjectService2T {
        def getObject(id: String) = 
            (scala.util.Random.nextInt(2), scala.util.Random.nextInt(2)) match {
                case (0, 0) => Some(MyObject(id))
                case (0, 1) => None
                case (1, _) => throw new Exception("Something bad happened")
        }
    }
        
    def searchObject3(id: String)(implicit service: ObjectService2T)
        : scala.util.Try[Option[MyObject]] =
            scala.util.Try(service.getObject(id))
}




