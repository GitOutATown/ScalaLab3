package lab.math.probability.fourmilab

import lab.math.probability.common.Combinatorics._

object combo_lab_1 {
  // https://www.fourmilab.ch/rpkp/experiments/statistics.html

  /* Mathematically, the number of ways to get x heads (or tails)
   * in n flips is spoken of as the “number of combinations of n
   * things taken x at a time”
   * n! / (x!(n-x!))
   * This is just the binary coeficient
   */
   
   // So, the number of ways to get 2 heads in 4 coin flips is 6.
   binCoef(4,2)                                   //> res0: Double = 6.0
   
   
  '''                                             //> res1: Char('\'') = '
}