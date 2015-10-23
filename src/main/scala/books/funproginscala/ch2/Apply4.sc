package books.funproginscala.ch2

object Apply4 {

	class Baz(i: Int, j: Int)
    
  new Baz(5, 6)                                   //> res0: books.funproginscala.ch2.Apply4.Baz = books.funproginscala.ch2.Apply4$B
                                                  //| az@42f3b418
  // Baz(1, 2) // Error. Companion object definition not parsed yet in worksheet.
    
  object Baz {
    	def apply(i: Int, j: Int) = {
    		new Baz(i, j)
		}
  }
  
  Baz(7, 8) // Companion object parsed now        //> res1: books.funproginscala.ch2.Apply4.Baz = books.funproginscala.ch2.Apply4$
                                                  //| Baz@3a15c018

	'''                                       //> res2: Char('\'') = '
}