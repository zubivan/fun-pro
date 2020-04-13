pub fn isSorted<T>(arr: &[T], ordered: fn(T, T) -> bool) -> bool
where
    T: Copy,
{
    arr.iter()
        .as_slice()
        .windows(2)
        .all(|w| ordered(w[0], w[1]))
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_empty_case() {
        let arr: Vec<i32> = vec![];
        assert_eq!(isSorted(&arr, |_x, _y| { true }), true);
    }

    #[test]
    fn test_single_element_case() {
        let arr = vec![1];
        assert_eq!(isSorted(&arr, |_x, _y| { true }), true);
    }

    #[test]
    fn test_sorted_array_case() {
        let arr = vec![1, 2, 3];
        assert_eq!(isSorted(&arr, |x, y| { y > x }), true);
    }

    #[test]
    fn test_unsorted_array_case() {
        let arr = vec![3, 2, 1];
        assert_eq!(isSorted(&arr, |x, y| { y > x }), false);
    }
}
