package exercises.chapter_2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class Ex_1_Spec extends AnyFlatSpec with Matchers {
  behavior of "Fibonacci number generator"

  it should "respect 0 value" in {
    Ex_1.fib(1) shouldEqual 0
  }

  it should "respect 1 value" in {
    Ex_1.fib(2) shouldEqual 1
  }

  it should "respect 6 value" in {
    Ex_1.fib(6) shouldEqual 5
  }
}
