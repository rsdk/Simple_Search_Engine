import java.math.BigInteger

fun main() {
    val a = readLine()!!.toBigInteger()
    val b = readLine()!!.toBigInteger()
    val sum = a + b
    val c = BigInteger.valueOf(100)
    val d = c * a / sum
    val e = c * b / sum
    print("${d}% ${e}%")
}