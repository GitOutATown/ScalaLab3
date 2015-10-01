package lab.option_try_either.bold_radius

object Lab1 {
    // Note interesting use of implicits

    // This data object is constant. No need for variability.
    case class MyObject(id: String) {
        override def toString = s"""{"id": $id}"""
    }
  
    trait ObjectServiceT {
        /* No leeway here. Must return MyObject, therefore rigid and brittle.
         * vulnerable to variable conditions.*/
        def getObject(id: String): MyObject 
    }
    
    implicit object DefiniteObjectService extends ObjectServiceT {
        def getObject(id: String) = MyObject(id)
    }
    
    def searchObject(id: String)(implicit service: ObjectServiceT): MyObject = 
        service.getObject(id)
}




