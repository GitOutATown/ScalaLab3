package lab.binary_trees

object binary_tree_lab_1 {

	def ord = scala.math.Ordering.Int         //> ord: => math.Ordering.Int.type

	type Rank = Int // Ordering of tree size (i.e. 0,1,2,4,8,16...)
  case class Node(x: Int, r: Int, c: List[Node]) // x basis for priority. c is immediate children (not a direct ref to every node in the tree, just the immediate branch nodes.).

	def link(t1: Node, t2: Node): Node = {
		assert(t1.r == t2.r)
    // Ordering of tree by Node.x value to put min at root
    if (ord.lteq(t1.x, t2.x)) Node(t1.x, t1.r+1, t2::t1.c)
    else Node(t2.x, t2.r+1, t1::t2.c)
  }                                               //> link: (t1: lab.binary_trees.binary_tree_lab_1.Node, t2: lab.binary_trees.bin
                                                  //| ary_tree_lab_1.Node)lab.binary_trees.binary_tree_lab_1.Node
  
  // ------------------------ //
  
  val n1 = Node(8, 0, Nil)                        //> n1  : lab.binary_trees.binary_tree_lab_1.Node = Node(8,0,List())
  val n2 = Node(3, 0, Nil)                        //> n2  : lab.binary_trees.binary_tree_lab_1.Node = Node(3,0,List())
  val n3 = Node(2, 0, Nil)                        //> n3  : lab.binary_trees.binary_tree_lab_1.Node = Node(2,0,List())
  val n4 = Node(6, 0, Nil)                        //> n4  : lab.binary_trees.binary_tree_lab_1.Node = Node(6,0,List())
  
  val n5 = link(n1, n2)                           //> n5  : lab.binary_trees.binary_tree_lab_1.Node = Node(3,1,List(Node(8,0,List(
                                                  //| ))))
  val n6 = link(n3, n4)                           //> n6  : lab.binary_trees.binary_tree_lab_1.Node = Node(2,1,List(Node(6,0,List(
                                                  //| ))))
  val n7 = link(n5, n6)                           //> n7  : lab.binary_trees.binary_tree_lab_1.Node = Node(2,2,List(Node(3,1,List(
                                                  //| Node(8,0,List()))), Node(6,0,List())))
  
  // ------------------------ //
  
  val n8 = link(n2, n3)                           //> n8  : lab.binary_trees.binary_tree_lab_1.Node = Node(2,1,List(Node(3,0,List(
                                                  //| ))))
  val n9 = link(n4, n1)                           //> n9  : lab.binary_trees.binary_tree_lab_1.Node = Node(6,1,List(Node(8,0,List(
                                                  //| ))))
  val n10 = link(n9, n8)                          //> n10  : lab.binary_trees.binary_tree_lab_1.Node = Node(2,2,List(Node(6,1,List
                                                  //| (Node(8,0,List()))), Node(3,0,List())))
	'''                                       //> res0: Char('\'') = '
}