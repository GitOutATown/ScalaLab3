package lab.bigO

object Big_O_notation_lab_2 {

    def containsDuplicates[T](list: List[T]): Boolean = {
        (for{
            i <- 0 to list.length
            j <- 0 to list.length
            if (i != j && list(i) == list(j))
        } yield true).headOption.get
    }
}