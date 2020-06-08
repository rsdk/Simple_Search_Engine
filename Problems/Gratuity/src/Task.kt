fun tip(bill: Int, percentage: Int = 10): Int {
    return (percentage.toDouble() / 100.0 * bill.toDouble()).toInt()
}