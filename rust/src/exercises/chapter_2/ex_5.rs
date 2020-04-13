fn compose<A, B, C, G, F>(f: F, g: G) -> impl Fn(A) -> C
where
    F: Fn(B) -> C,
    G: Fn(A) -> B,
{
    move |a| f(g(a))
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn it_should_compile() {
        let multiply_and_add = compose(|x| x + 2, |x| x - 2);

        assert_eq!(multiply_and_add(0), 0);
    }
}
