package books.funproginscala.ch3

object Tree_client_1 {
  import Tree._

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
  
  size(tree1)                                     //> res0: Int = 7
  size(tree2)                                     //> res1: Int = 3
  '''                                             //> res2: Char('\'') = '
  
}