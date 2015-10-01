package lab.option_try_either.bold_radius

object Lab2 {
    import lab.option_try_either.bold_radius.Lab1.{MyObject}
    
    /** With Option *****************/
    
    // Loosened up; Adaptable to a binary condition.
    trait ObjectService2T {
        def getObject(id: String): Option[MyObject]
    }
    
    // Service that (randomly) returns object or empty 
    implicit object MaybeObjectService extends ObjectService2T {
        def getObject(id: String) = 
            if(scala.util.Random.nextInt(2) == 0) Some(MyObject(id)) else None
    }
    
    def searchObject2(id: String)(implicit service: ObjectService2T) 
        :Option[MyObject] = service.getObject(id)
        
}





