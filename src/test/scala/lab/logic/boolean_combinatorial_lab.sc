package lab.logic

object boolean_combinatorial_lab {

	//val a = true
	val a = false                             //> a  : Boolean = false
	//val b = true
	val b = false                             //> b  : Boolean = false
	
	a || b                                    //> res0: Boolean = false
	!(!a && !b)                               //> res1: Boolean = false
	
	a || b == !(!a && !b)                     //> res2: Boolean = true
	
	!a                                        //> res3: Boolean = true
	!b                                        //> res4: Boolean = true
	a && b                                    //> res5: Boolean = false
	!a && !b                                  //> res6: Boolean = true
	!(!a && !b)                               //> res7: Boolean = false
	
	'''                                       //> res8: Char('\'') = '
}