package books.intro_count_prob_patrick.ch1

object lab_2 {

  // How many numbers in a contiguous inclusive list?
  def numsInList(start: Int, end: Int): Int = {
    end - start + 1
    // same as end - (start - 1)
  }                                               //> numsInList: (start: Int, end: Int)Int
  
  numsInList(1, 18)                               //> res0: Int = 18
  numsInList(7, 29)                               //> res1: Int = 23
  
  // How many multiples of div are there in a contiguous inclusive list?
  // TODO: Add boundry constraints
  def numMultiples(first: Int, last: Int, div: Int): Int = {
  
    def isMult(num: Int, div: Int): Boolean = {
	    num % div == 0
	  }
	  
    def findNearestMult(num: Int, direction: Boolean): Int = {
      if(isMult(num, div)) num
      else {
        if(first - last == 0) 0
        else{
          val increment = if(direction) num + 1 else num - 1
          findNearestMult(num, direction)
        }
      }
	  }
	  
	  val start = findNearestMult(first, true)
	  val end = findNearestMult(last, false)
	  
	  numsInList(start, end) / div
  }                                               //> numMultiples: (first: Int, last: Int, div: Int)Int
  
  numMultiples(62, 215, 3)
  
  '''                                             //> res2: Char('\'') = '
}