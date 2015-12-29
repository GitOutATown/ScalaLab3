package books.funproginscala.ch4

object Option_client {

  def mean(xs: Seq[Double]): Option[Double] = {
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)
  }                                               //> mean: (xs: Seq[Double])books.funproginscala.ch4.Option[Double]
  
  mean(List(1,2,3))                               //> res0: books.funproginscala.ch4.Option[Double] = Some(2.0)

  '''                                             //> res1: Char('\'') = '
 
}