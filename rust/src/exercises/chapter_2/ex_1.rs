pub fn feb(n: i64) -> i64 {
    fn feb(n: i64, pair: (i64, i64)) -> i64 {
        match n {
            0 | 1 => pair.0,
            _ => feb(n - 1, (pair.1, pair.0 + pair.1)),
        }
    }

    feb(n, (0, 1))
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_zero_case() {
        assert_eq!(feb(1), 0);
    }

    #[test]
    fn test_one_case() {
        assert_eq!(feb(2), 1);
    }

    #[test]
    fn test_other_case() {
        assert_eq!(feb(6), 5);
    }
}
