package exercises.chapter_2

object Ex_2 {
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    as.sliding(2).forall{
      case Array(left, right) => ordered(left, right)
      case _ => true
    }
  }
}
