package books.funproginscala.ch3.MEM

object Tree_client {

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
  )                                               //> tree1  : books.funproginscala.ch3.MEM.Tree[String] = Branch(Branch(Leaf(a),L
                                                  //| eaf(b)),Branch(Leaf(c),Leaf(d)))
  
  val tree2: Tree[String] =
  Branch(
    Leaf("a"),
    Leaf("b")
  )                                               //> tree2  : books.funproginscala.ch3.MEM.Tree[String] = Branch(Leaf(a),Leaf(b))
                                                  //| 
  
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
  )                                               //> tree3  : books.funproginscala.ch3.MEM.Branch[Int] = Branch(Branch(Branch(Lea
                                                  //| f(1),Branch(Leaf(4),Leaf(7))),Leaf(3)),Branch(Leaf(2),Leaf(5)))
  
  // Operations
  
  size(tree1)                                     //> res0: Int = 7
  size(tree2)                                     //> res1: Int = 3
  
  maximum(tree3)                                  //> res2: Int = 7
  
  depth(tree1)                                    //> res3: Int = 2
  depth(tree2)                                    //> res4: Int = 1
  depth(tree3)                                    //> res5: Int = 4
  
  map(tree3)(_ * 2)                               //> res6: books.funproginscala.ch3.MEM.Tree[Int] = Branch(Branch(Branch(Leaf(2),
                                                  //| Branch(Leaf(8),Leaf(14))),Leaf(6)),Branch(Leaf(4),Leaf(10)))
  map(tree2)(x => "c")                            //> res7: books.funproginscala.ch3.MEM.Tree[String] = Branch(Leaf(c),Leaf(c))
}