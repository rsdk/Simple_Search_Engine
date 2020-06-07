fun compose(g: (Int) -> Int, h: (Int) -> Int): (Int) -> Int {
    return { a -> g(h(a)) }
}