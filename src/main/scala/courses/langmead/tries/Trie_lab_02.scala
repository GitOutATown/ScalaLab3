package courses.langmead.tries

object Trie_lab_02 {
    
    // SUCCESS!

    val R = 'R'                                                                         //> R    : Char = R
    val a = 'a'                                                                         //> a    : Char = a
    val b = 'b'                                                                         //> b    : Char = b
    val $ = '$'                                                                         //> $    : Char = $

    case class Node(ch: Char, children: List[Node] = Nil)

    Node( // R
        R,
        List( // R's children
            Node( // $
                $,
                List()
            ), 
            Node( // b,a,$
                b,
                List(
                    Node(a, 
                        List(
                            Node(
                                $,
                                List()
                            ), 
                            Node(
                                a,
                                List(
                                    Node(
                                        b,
                                        List(
                                            Node(
                                                a,
                                                List(
                                                    Node(
                                                        $,
                                                        List()
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            ), 
            Node( // a
                a,
                List(
                    Node(
                        $,
                        List()
                    ), 
                    Node(
                        a,
                        List(
                            Node(
                                b,
                                List(
                                    Node(
                                        a,
                                        List(
                                            Node($,
                                                List()
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    ), 
                    Node(
                        b,
                        List(
                            Node(
                                a,
                                List(
                                    Node(
                                        $,
                                        List()
                                    ), 
                                    Node(
                                        a,
                                        List(
                                            Node(
                                                b,
                                                List(
                                                    Node(
                                                        a,
                                                        List(
                                                            Node(
                                                                $,
                                                                List()
                                                            )
                                                        )
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        ) // end R's children
    ) // end R

}








































