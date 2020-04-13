package exercises.chapter_2

object Ex_5 {
    def compose[A, B, C](f: B => C, g : A => B) : A => C = {
        (a: A) => f(g(a))
    }
}