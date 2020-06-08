fun main() {
    val a = readLine()!!
    val b = readLine()!!
    val c = readLine()!!
    val sep = readLine()!!
    if (sep == "NO SEPARATOR") {
        println(concat(a, b, c))
    } else {
        println(concat(a, b, c, sep))
    }
}

fun concat(a: String, b: String, c: String, sep: String = " "): String {
    return a + sep + b + sep + c
}

