// TODO: provide three functions here
fun identity(param: Int) = param

fun half(param: Int) = param / 2

fun zero(param: Int) = 0

fun generate(functionName: String): (Int) -> Int {
    // TODO: provide implementation here
    when (functionName) {
        "identity" -> return ::identity
        "half" -> return ::half
        "zero" -> return ::zero
    }
    return ::zero
}