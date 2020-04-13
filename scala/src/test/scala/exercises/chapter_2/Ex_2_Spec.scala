package exercises.chapter_2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Ex_2_Spec extends AnyFlatSpec with Matchers {
  behavior of "isSorted"

  it should "return true for empty array" in {
    Ex_2.isSorted[Any](Array(), (_, _) => true) shouldEqual true
  }

  it should "return true for an array of one element" in {
    Ex_2.isSorted[Int](Array(1), (x, y) => y > x) shouldEqual true
  }

  it should "return return true for a sorted array" in {
    Ex_2.isSorted[Int](Array(1, 2, 3), (x, y) => y > x) shouldEqual true
  }

  it should "return return false for unsorted array" in {
    Ex_2.isSorted[Int](Array(3, 2, 1), (x, y) => y > x) shouldEqual false
  }
}
