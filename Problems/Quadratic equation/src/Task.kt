import java.lang.Math.pow
import java.lang.Math.sqrt
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`).useLocale(Locale.ENGLISH)
    val a = scanner.nextDouble()
    val b = scanner.nextDouble()
    val c = scanner.nextDouble()

    val root1 = -(b + sqrt(pow(b, 2.0) - 4 * a * c)) / (2 * a)
    val root2 = -(b - sqrt(pow(b, 2.0) - 4 * a * c)) / (2 * a)

    println("${Math.min(root1, root2)} ${Math.max(root1, root2)}")
}