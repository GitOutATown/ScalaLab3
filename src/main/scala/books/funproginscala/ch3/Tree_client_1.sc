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
  
  maximum(tree3)                                  //> res2: Int = 7
  
  depth(tree1)                                    //> res3: Int = 3
  depth(tree2)                                    //> res4: Int = 2
  depth(tree3)                                    //> res5: Int = 5
  
  '''                                             //> res6: Char('\'') = '
}