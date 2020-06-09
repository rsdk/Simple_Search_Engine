fun main() {
    val rooms = readLine()!!.toInt()
    val price = readLine()!!.toInt()
    val house = when {
        rooms <=1 -> Cabin(rooms, price)
        rooms in 2..3 -> Bungalow(rooms, price)
        rooms == 4 -> Cottage(rooms, price)
        rooms in 5..7 -> Mansion(rooms, price)
        else -> Palace(rooms, price)
    }
    println(house.finalPrice())
}

open class House(val rooms: Int, private val price: Int) {
    fun basePrice(): Int {
        return when {
            price < 0 -> 0
            price > 1_000_000 -> 1_000_000
            else -> price
        }
    }
    open fun finalPrice(): Int {
        return basePrice()
    }
}

class Cabin(rooms: Int, price: Int) : House(rooms, price) {
    override fun finalPrice(): Int {
        return basePrice() * 1
    }
}

class Bungalow(rooms: Int, price: Int) : House(rooms, price) {
    override fun finalPrice(): Int {
        return (basePrice() * 1.2).toInt()
    }
}

class Cottage(rooms: Int, price: Int) : House(rooms, price) {
    override fun finalPrice(): Int {
        return (basePrice() * 1.25).toInt()
    }
}

class Mansion(rooms: Int, price: Int) : House(rooms, price) {
    override fun finalPrice(): Int {
        return (basePrice() * 1.4).toInt()
    }
}

class Palace(rooms: Int, price: Int) : House(rooms, price) {
    override fun finalPrice(): Int {
        return (basePrice() * 1.6).toInt()
    }
}