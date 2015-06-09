package books.mathematical_methods_linguistics.set_theory.ch1_basic_concepts

object SetOperations_lab_1 {

  val nullSet = Set[Int]()
  // universe
  val U = (1 to 25).toSet
  val s1 = Set(1,2,3,4,5,6,7,8,9,10)
  val s2 = Set(2,4,6,8,10)
  val s3 = Set(11, 12, 13)
  
  s1.union(s2)
  s1.intersect(s2)
  
  s2 -- s1
  
  // I'm not seeing any difference between -- and diff
  (U -- s1).toList.sorted
  U.diff(s1).toList.sorted
  Set(1,2,3) -- Set(0,1,2,3,4)
  Set(1,2,3) -- Set(11,12)
  
  // pseudo compliment, curried for partial function set up
  def compliment(universe: Set[Int])(s: Set[Int]): Set[Int] = {
    universe -- s
  }
  def isSubset(container: Set[Int])(sub: Set[Int]): Boolean = {
    (sub union container) == container &&
    (sub intersect container) == sub
  }
  
  val comp = compliment(U)_
  
  comp(s1).toList.sorted
  comp(s2).toList.sorted
  
  /** Some fundamental set-theoretic equalities **/
  // TODO: For these examples to be more meaningful, I should set them up as scalacheck tests
  
  // 1. Idempotent Laws
  // a. X union X = X
  (s1 union s1) == s1
  // b. X intersect X = X
  (s1 intersect s1) == s1
  
  // 2. Commutative Laws
  // a. X union Y = Y union X
  (s1 union s2) == (s2 union s1)
  // b. X intersect Y = Y intersect X
  (s1 intersect s2) == (s2 intersect s1)
  
  // 3. Associative Laws
  // a. (X union Y) union Z = X union (Y union Z)
  ((s1 union s2) union s3) == (s1 union (s2 union s3))
  // b. (X intersect Y) intersect Z = X intersect (Y intersect Z)
  ((s1 intersect s2) intersect s3) == (s1 intersect (s2 intersect s3))
  // 4. Distributive Laws
  // a. X union (Y intersect Z) = (X union Y) intersect (X union Z)
  (s1 union (s2 intersect s3)) == ((s1 union s2) intersect (s1 union s3))
  // b. X intersect (Y union Z) = (X intersect Y) union (X intersect Z)
  (s1 intersect (s2 union s3)) == ((s1 intersect s2) union (s1 intersect s3))
  // 5. Identity Laws
  // a. X union null set = X
  (s1 union nullSet) == s1
  // b. X union univers = univers
  (s1 union U) == U
  // c. X intersect nullSet = nullSet
  (s1 intersect nullSet) == nullSet
  // d. X intersect U = X
  (s1 intersect U) == s1
  
  // 6. Complement Laws
  // a. X union X' = U
  (s1 union comp(s1)) == U
  // b. (X')' = X
  (comp(comp(s1))) == s1
  // c. X intersect X' = nullSet
  (s1 intersect comp(s1)) == nullSet
  // d. X - Y = X intersect Y'
  (s1 -- s2) == (s1 intersect comp(s2))
  
  // 7. DeMorgan's Law
  // a. (X union Y)' = X' intersect Y'
  (comp(s1 union s2)) == (comp(s1) intersect comp(s2))
  // b. (X intersect Y)' = X' union Y'
  (comp(s1 intersect s2)) == (comp(s1) union comp(s2))
  // 8. Consistency Principal
  // a. X isASubsetOf Y iff X union Y = Y
  s2.subsetOf(s1) && (s2 union s1) == s1
  // b. X isASubsetOf Y iff X intersect Y = X
  s2.subsetOf(s1) && (s2 intersect s1) == s2
  isSubset(s1)(s2) // s2 isSubset s1
  //isSubset(s2)(s1) // false
}
/*






*/