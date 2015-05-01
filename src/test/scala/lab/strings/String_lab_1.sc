package lab.strings

object String_lab_1 {

	def tweetLength(text: String): Int = {
    /* This should be simply text.codePointCount(0, text.length), but it
     * is not implemented in Scala.js 0.6.2.
     */
    if (text.isEmpty) 0
    else {
      text.length - text.init.zip(text.tail).count(
          (Character.isSurrogatePair _).tupled)
    }
  }                                               //> tweetLength: (text: String)Int
  
  val tweet1 = "The rain in Spain"                //> tweet1  : String = The rain in Spain
  tweet1.length                                   //> res0: Int = 17
  tweetLength(tweet1)                             //> res1: Int = 17
  
  // -------------------- //
  
  tweet1.init                                     //> res2: String = The rain in Spai
  tweet1.tail                                     //> res3: String = he rain in Spain
	tweet1.init.zip(tweet1.tail)              //> res4: scala.collection.immutable.IndexedSeq[(Char, Char)] = Vector((T,h), (h
                                                  //| ,e), (e, ), ( ,r), (r,a), (a,i), (i,n), (n, ), ( ,i), (i,n), (n, ), ( ,S), (
                                                  //| S,p), (p,a), (a,i), (i,n))
	'''                                       //> res5: Char('\'') = '
}