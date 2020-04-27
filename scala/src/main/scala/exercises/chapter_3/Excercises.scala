package exercises.chapter_3

import scala.annotation.tailrec

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[A](value: A, tail: List[A]) extends List[A]

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
      case Cons(value, tail) => Cons(value, init(tail))
    }
  }

  def foldRight[A, B](list: List[A], inital: B)(f: (A, B) => B): B = {
    list match {
      case Nil               => inital
      case Cons(value, tail) => f(value, foldRight(tail, inital)(f))
    }
  }

  def length[A](list: List[A]): Int = {
    foldRight(list, 0)((_, acc) => acc + 1)
  }

  @tailrec
  def foldLeft[A, B](list: List[A], initial: B)(f: (B, A) => B): B = {
    list match {
      case Nil               => initial
      case Cons(value, tail) => foldLeft(tail, f(initial, value))(f)
    }
  }

  def reverse[A](list: List[A]): List[A] = {
    foldLeft[A, List[A]](list, Nil)((acc, h) => Cons(h, acc))
  }

  def fold_right_with_left_reverse[A, B](list: List[A], inital: B)(
      f: (A, B) => B
  ): B = {
    foldLeft[List[A], B](reverse(list), inital)(f)
  }

  def fold_right_with_left_deffer[A, B](list: List[A], inital: B)(
      f: (A, B) => B
  ): B = {
    foldLeft(list, (b: B) => b)((g, a) => b => g(f(a, b)))(inital)
  }

  def append[A](list: List[A], addition: List[A]): List[A] =
    foldRight(list, addition)(Cons(_, _))
}

object Concrete_Usecase {
  def sum(list: List[Int]) = List.foldLeft(list, 0)(_ + _)

  def product(list: List[Int]) = List.foldLeft(list, 1)(_ * _)
}
