package lab.trees.rosetta

case class IntNode(value: Int, left: Option[IntNode] = None, right: Option[IntNode] = None) {
 
  // recursive
  def preorder(f: IntNode => Unit) {
    println("In def preorder - f: " + f + " | this.value: " + this.value)
    	println("..calling passed in f(this)...")
    f(this) // So this is just calling the println in the foreach case statement on the List below, i.e. StringBuilder assembly...
    println("..calling left (recursion)..")
    left.map(_.preorder(f)) // Same as: if(left.isDefined) left.get.preorder(f)
    println("..calling right (recursion)..")
    right.map(_.preorder(f))
  }
 
  def postorder(f: IntNode => Unit) {
    println("In def postorder - f: " + f + " | this.value: " + this.value)
    println("..calling left (recursion)..")
    left.map(_.postorder(f))
    println("..calling right (recursion)..")
    right.map(_.postorder(f))
    println("..calling passed in f(this)...")
    f(this)
  }
 
  def inorder(f: IntNode => Unit) {
    println("In def inorder - f: " + f + " | this.value: " + this.value)
    println("..calling left (recursion)..")
    left.map(_.inorder(f))
    println("..calling passed in f(this)...")
    f(this)
    println("..calling right (recursion)..")
    right.map(_.inorder(f))
  }
 
  def levelorder(f: IntNode => Unit) {
	println("In def levelorder - f: " + f + " | this.value: " + this.value)
    def loVisit(ls: List[IntNode]): Unit = {
		println("In loVisit TOP")
		ls match {
	      	case Nil => None
	      	case node :: rest => {
		        println("..calling passed in f(node)...")
		        f(node)
		        // Here is where the sorting is being done. Actually, the tree is (must be) already sorted.
		        // This whole file is just about traversal, not sorting.
		        // Note that the mechanism of List is assembled here in order of left to right which replicates the required sorted tree structure.
		        println(">>> calling loVisit recursion with: " + rest + " ++ " + node.left + " ++ " + node.right)
		        loVisit(rest ++ node.left ++ node.right)
	      	}
		}
	}
	println("..initiating loVisit recursion..")
    loVisit(List(this))
  }
}

object TreeTraversal extends App {
	
	implicit def intNode2SomeIntNode(n: IntNode) = Some[IntNode](n)
 
	val tree = IntNode(1, // root
	    IntNode(2, // root's left
	    		IntNode(4, // 2's left
    				IntNode(7) // 4's left
			),
			IntNode(5) // 2's right
		),
	    IntNode(3, // root's right
	    		IntNode(6, // 3's left
    				IntNode(8), // 6's left
    				IntNode(9) // 6's right
			)
		)
    	)
 
  List(
    "  preorder: " -> tree.preorder _, // `_` denotes the function value of type `IntNode => Unit` (returning nothing)
    "   inorder: " -> tree.inorder _,
    " postorder: " -> tree.postorder _,
    "levelorder: " -> tree.levelorder _) foreach {
      case (name, func) =>
        println("\nforeach...")
        val s = new StringBuilder(name)
        println("===> Calling func " + name + " on the root IntNode.")
        // It's passing an anonymous function for assembling the values of the nested (hierarchical, tree) IntNode structure.
        func(n => {
          println("...which is an annonymous function for StringBuilder assembly of tree with: " + n.value.toString)
          s ++= n.value.toString + " "
        })
        println("StringBuilder assembled: " + s + " for " + name)
    }
}