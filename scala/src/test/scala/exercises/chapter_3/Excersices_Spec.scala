package exercises.chapter_3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Excersices_Spec extends AnyFlatSpec with Matchers {
  behavior of "fold right"

  it should "short-circuiting fold right" in {
    val list = Cons(1, Cons(2, Cons(3, Empty)))

    List.foldRight(list, 1)((el, acc) => if (el == 0) acc else el * acc)
  }
}
