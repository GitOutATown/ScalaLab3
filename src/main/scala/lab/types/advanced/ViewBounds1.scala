package lab.types.advanced

// https://twitter.github.io/scala_school/advanced-types.html

object ViewBounds1 {
    
    implicit def strToInt(x: String) = x.toInt
    
    // Specify a view bound with <%
    class Container[A <% Int] { 
        def addIt(x: A) = 123 + x 
    }

}