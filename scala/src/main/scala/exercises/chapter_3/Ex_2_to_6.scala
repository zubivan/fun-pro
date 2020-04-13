package exercises.chapter_3

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[A](value: A, next: List[A]) extends List[A]

object List {
  def tail[A](list: List[A]): List[A] = {
    drop(list, 1)
  }

  def setHead[A](list: List[A], value: A): List[A] = {
    list match {
      case Nil           => Cons(value, Nil)
      case Cons(_, tail) => Cons(value, tail)
    }
  }

  def drop[A](list: List[A], n: Int): List[A] = {
    (list, n) match {
      case (Nil, _) => Nil
      case (Cons(_, tail), 0) => {
        tail
      }
      case (Cons(_, tail), _) => {
        drop(tail, n - 1)
      }
    }
  }

  def dropWhile[A](list: List[A])(f: A => Boolean): List[A] = {
    list match {
      case Cons(value, tail) if f(value) => {
        dropWhile(tail)(f)
      }
      case _ => list
    }
  }

  def init[A](list: List[A]): List[A] = {
    list match {
      case Nil               => Nil
      case Cons(value, Nil)  => Nil
      case Cons(value, next) => Cons(value, init(next))
    }
  }
}
