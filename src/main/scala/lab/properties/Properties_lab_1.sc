package lab.properties

object Properties_lab_1 {
	
	//class C1(var property: Int) // 1st version
	
	class C1( private var p:Int ) {
		def property = p
		def property_= (newVal:Int) = p = newVal * 100
	}
	
	class C2( val dependecy:C1 ){
		println("a:" + dependecy.property)
		dependecy.property += 1
		println("b:" + dependecy.property)
	}
	
	val c2 = new C2( new C1(10) )             //> a:10
                                                  //| b:1100
                                                  //| c2  : lab.properties.Properties_lab_1.C2 = lab.properties.Properties_lab_1$C
                                                  //| 2@2b1de6a0
	
	c2.dependecy.property = 3
	c2.dependecy.property                     //> res0: Int = 300
	
}