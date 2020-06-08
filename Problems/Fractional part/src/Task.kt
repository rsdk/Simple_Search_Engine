import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.next().toDouble()
    val back = a - a.toInt()
    val b = back * 10
    println(b.toInt())
}