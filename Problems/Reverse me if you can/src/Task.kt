fun reverse(input: Int?): Int {
    if (input == null) return -1
    return input.toString().reversed().toInt()
}