#[cfg(not(broken))]
fn curry<A, B, C, F, G>(f: F) -> impl Fn(A) -> G
where
    F: Fn(A, B) -> C,
    G: Fn(B) -> C,
{
    move |a| move |b| f(a, b)
}

#[cfg(not(broken))]
#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn it_should_compile() {
        let add = |a: i32, b: i32| a + b;

        let add5 = curry(add)(5);

        assert_eq!(add5(5), 10);
    }
}
