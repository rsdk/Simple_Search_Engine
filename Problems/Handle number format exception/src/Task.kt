import java.lang.Exception

fun parseCardNumber(cardNumber: String): Long {
    if (cardNumber.length != 19) {
        throw Exception("Wrong length")
    }
    val strWOSpace = cardNumber.replace(" ", "")
    if (strWOSpace.length != 16) {
        throw Exception("Wrong spaces")
    }
    strWOSpace.forEach {
        if (!it.isDigit()) {
            throw Exception("Not all digits")
        }
    }
    return strWOSpace.toLong()
}