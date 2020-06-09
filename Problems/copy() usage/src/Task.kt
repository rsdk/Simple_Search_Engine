import java.util.Scanner

// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val h = input.nextInt()
    val l = input.nextInt()
    val l2 = input.nextInt()
    val w = input.nextInt()
    val b1 = Box(h, l, w)
    val b2 = b1.copy(length = l2)
    println(b1)
    println(b2)
}