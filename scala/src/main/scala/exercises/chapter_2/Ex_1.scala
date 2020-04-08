package exercises.chapter_2

object Ex_1 {
  def fib(n: Int): Int = {
    def fib(n: Int, pair: (Int, Int)): Int = n match {
      case 0 | 1 => pair._1
      case _     => fib(n - 1, (pair._2, pair._1 + pair._2))
    }

    fib(n, (0, 1))
  }
}
