package lab.option_try_either.bold_radius

object Lab4 {
    import lab.option_try_either.bold_radius.Lab1.{MyObject}
    import lab.option_try_either.bold_radius.Lab3.{searchObject3}

    case class InternalError(id: Int)
    
    /* Code that sanitizes the input before calling code from Lab3; 
     * Enforces id field format.
     * You can really see the layering here with searchObject4 calling
     * searchObject3 */
    def searchObject4(id: String)
        : Either[scala.util.Try[Option[MyObject]], InternalError] =
            if(!id.startsWith("id")) scala.util.Right(InternalError(1000)) 
            else scala.util.Left(searchObject3(id))

}