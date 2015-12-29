package books.funproginscala.ch3

object Tree_client_1 {
  import Tree._

  // Data (trees)
  
  val tree1: Tree[String] =
  Branch(
    Branch(
      Leaf("a"),
      Leaf("b")
    ),
    Branch(
      Leaf("c"),
      Leaf("d")
    )
  )                                               //> tree1  : books.funproginscala.ch3.Tree[String] = Branch(Branch(Leaf(a),Leaf(
                                                  //| b)),Branch(Leaf(c),Leaf(d)))
  
  val tree2: Tree[String] =
  Branch(
	  Leaf("a"),
	  Leaf("b")
  )                                               //> tree2  : books.funproginscala.ch3.Tree[String] = Branch(Leaf(a),Leaf(b))
  
  val tree3 =
  Branch(
    Branch(
      Branch(
        Leaf(1),
        Branch(
          Leaf(4),
          Leaf(7)
        )
      ),
      Leaf(3)
    ),
    Branch(
      Leaf(2),
      Leaf(5)
    )
  )                                               //> tree3  : books.funproginscala.ch3.Branch[Int] = Branch(Branch(Branch(Leaf(1)
                                                  //| ,Branch(Leaf(4),Leaf(7))),Leaf(3)),Branch(Leaf(2),Leaf(5)))
  
  // Operations
  
  size(tree1)                                     //> res0: Int = 7
  size(tree2)                                     //> res1: Int = 3
  
  sizeViaFold(tree1)                              //> res2: Int = 7
  sizeViaFold(tree2)                              //> res3: Int = 3
  
  maximum(tree3)                                  //> res4: Int = 7
  maxViaFold(tree3)                               //> res5: Int = 7
  
  depth(tree1)                                    //> res6: Int = 2
  depth(tree2)                                    //> res7: Int = 1
  depth(tree3)                                    //> res8: Int = 4
  
  depthViaFold(tree1)                             //> res9: Int = 2
  depthViaFold(tree2)                             //> res10: Int = 1
  depthViaFold(tree3)                             //> res11: Int = 4
  
  map(tree3)(_ * 2)                               //> res12: books.funproginscala.ch3.Tree[Int] = Branch(Branch(Branch(Leaf(2),Bra
                                                  //| nch(Leaf(8),Leaf(14))),Leaf(6)),Branch(Leaf(4),Leaf(10)))
  map(tree2)(x => "c")                            //> res13: books.funproginscala.ch3.Tree[String] = Branch(Leaf(c),Leaf(c))
  
  mapViaFold(tree3)(_ * 2)                        //> res14: books.funproginscala.ch3.Tree[Int] = Branch(Branch(Branch(Leaf(2),Bra
                                                  //| nch(Leaf(8),Leaf(14))),Leaf(6)),Branch(Leaf(4),Leaf(10)))
  mapViaFold(tree2)(x => "c")                     //> res15: books.funproginscala.ch3.Tree[String] = Branch(Leaf(c),Leaf(c))
}
/*



*/