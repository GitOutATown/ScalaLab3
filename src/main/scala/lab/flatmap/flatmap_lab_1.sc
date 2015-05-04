package lab.flatmap

object flatmap_lab_1 {

	val list1 = List(2,3,4)                   //> list1  : List[Int] = List(2, 3, 4)
	val list2 = List(5,6,7)                   //> list2  : List[Int] = List(5, 6, 7)
	
	// flatMap, map
	val flatMap_map = list1.flatMap(x => {
		println("x:" + x)
		val inner = list2.map(y => x*y)
		println("inner:" + inner)
		inner
	})                                        //> x:2
                                                  //| inner:List(10, 12, 14)
                                                  //| x:3
                                                  //| inner:List(15, 18, 21)
                                                  //| x:4
                                                  //| inner:List(20, 24, 28)
                                                  //| flatMap_map  : List[Int] = List(10, 12, 14, 15, 18, 21, 20, 24, 28)
	// map, map
	val map_map = list1.map(x => {
		println("x:" + x)
		val inner = list2.map(y => x*y)
		println("inner:" + inner)
		inner
	})                                        //> x:2
                                                  //| inner:List(10, 12, 14)
                                                  //| x:3
                                                  //| inner:List(15, 18, 21)
                                                  //| x:4
                                                  //| inner:List(20, 24, 28)
                                                  //| map_map  : List[List[Int]] = List(List(10, 12, 14), List(15, 18, 21), List(2
                                                  //| 0, 24, 28))

	'''                                       //> res0: Char('\'') = '
}