import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val paramName = scanner.nextLine()
    val paramValue = scanner.nextInt()
    val price = when (paramName) {
        "old" -> calcCar(age = paramValue)
        "passed" -> calcCar(km = paramValue)
        "speed" -> calcCar(maxSpeed = paramValue)
        "auto" -> calcCar(autoTrans = paramValue)
        else -> calcCar()
    }
    println(price)
}

fun calcCar(age: Int = 5, km: Int = 100_000, maxSpeed: Int = 120, autoTrans: Int = 0, newCarPrice: Int = 20_000): Int {
    val speedCorrection = (maxSpeed - 120) * 100
    val kmCorrection = -((km / 10_000) * 200)
    val ageCorrection = -(age * 2000)
    val transCorrection = if (autoTrans == 1) 1500 else 0
    return newCarPrice + speedCorrection + kmCorrection + ageCorrection + transCorrection
}