import java.util.Scanner


data class Client(val name: String, val age: Int, val balance: Int) {
    override fun equals(other: Any?): Boolean {
        other as Client
        if (name == other.name && age == other.age) return true
        return false
    }
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val name = input.next()
    val age = input.nextInt()
    val balance = input.nextInt()
    val name2 = input.next()
    val age2 = input.nextInt()
    val balance2 = input.nextInt()

    val c1 = Client(name, age, balance)
    val c2 = Client(name2, age2, balance2)
    println(c1 == c2)
}