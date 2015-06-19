package courses.langmead.tries

import courses.langmead.tries.Trie_lab_11._

object Node_contains_lab_1 {

  val aNode1 = Node('a', List(Node('b')))         //> aNode1  : courses.langmead.tries.Trie_lab_11.Node = Node(a,List(Node(b,List(
                                                  //| ))))
  val aNode2 = Node('a', List(Node('b')))         //> aNode2  : courses.langmead.tries.Trie_lab_11.Node = Node(a,List(Node(b,List(
                                                  //| ))))
  val aNode3 = Node('a', List(Node('c')))         //> aNode3  : courses.langmead.tries.Trie_lab_11.Node = Node(a,List(Node(c,List(
                                                  //| ))))
  
  val list = List(aNode1)                         //> list  : List[courses.langmead.tries.Trie_lab_11.Node] = List(Node(a,List(Nod
                                                  //| e(b,List()))))
  list contains aNode1                            //> res0: Boolean = true
  list contains aNode2                            //> res1: Boolean = true
  list contains aNode3                            //> res2: Boolean = false
}