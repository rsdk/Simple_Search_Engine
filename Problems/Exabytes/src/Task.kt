import java.math.BigInteger

fun main() {
    val a = readLine()!!.toBigInteger()
    var b = BigInteger.valueOf(2)
    b = b.pow(63)
    println(a * b)
}