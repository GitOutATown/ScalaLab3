package lab.properties

object Properties_lab_1 {
	
	//class C1(var property: Int) // 1st version
	
	/* def property references private var, not externally accessable.
	 * property could be named anything. But must be congruent with _=
	 * symbol to reference companion def.*/
	class C1( private var p:Int ) {
		def property = p
		def property_= (newVal:Int) = p = newVal * 100
	}
	
	class C2( val dependecy:C1 ){
		println("C1.property:" + dependecy.property)
		dependecy.property += 1
		println("C1.property:" + dependecy.property)
	}
	
	val c2 = new C2( new C1(10) )             //> C1.property:10
                                                  //| C1.property:1100
                                                  //| c2  : lab.properties.Properties_lab_1.C2 = lab.properties.Properties_lab_1$C
                                                  //| 2@45f96cf3
	
	c2.dependecy.property = 3
	c2.dependecy.property                     //> res0: Int = 300
	
	// ------------------------- //
	
		//val c0 = new C2 // error
	//val c1 = new C1 // error
	val c1_1 = new C1(10)                     //> c1_1  : lab.properties.Properties_lab_1.C1 = lab.properties.Properties_lab_1
                                                  //| $C1@7a5fe968
	//c1_1.p // error
	c1_1.property                             //> res1: Int = 10
	c1_1.property = 20
	c1_1.property                             //> res2: Int = 2000
	
}