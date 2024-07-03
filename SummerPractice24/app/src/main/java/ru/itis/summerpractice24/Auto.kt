package ru.itis.summerpractice24

import kotlin.random.Random

open class Auto(
    val brand: String?,
    val model: String?,
    val year: Int?,
    val color: String?,
    val price: Int?
) {
    open fun getInfo() {
        println("Brand: $brand, Model: $model, Year: $year, Color: $color, Price: $price")
    }

    data class Builder(
        var brand: String? = null,
        var model: String? = null,
        var year: Int? = 0,
        var color: String? = null,
        var price: Int? = 0
    ) {

        fun brand(brand: String) = apply { this.brand = brand }
        fun model(model: String) = apply { this.model = model }
        fun year(year: Int) = apply { this.year = year }
        fun color(color: String) = apply { this.color = color }
        fun price(price: Int) = apply { this.price = price }
        fun build() = Auto(brand, model, year, color, price)
    }
}

class Crossover(
    brand: String?,
    model: String?,
    year: Int?,
    color: String?,
    price: Int?,
    val driveType: String?,
    val enginePower: Int?
) : Auto(brand, model, year, color, price) {
    override fun getInfo() {
        super.getInfo()
        println("Drive Type: $driveType, Engine Power: $enginePower")
    }

}

class Sedan(
    brand: String?,
    model: String?,
    year: Int?,
    color: String?,
    price: Int?,
    val engineType: String?,
    val engineCapacity: Int?
) : Auto(brand, model, year, color, price) {
    override fun getInfo() {
        super.getInfo()
        println("Engine Type: $engineType, Engine Capacity: $engineCapacity")
    }
}

class Cabriolet(
    brand: String,
    model: String,
    year: Int,
    color: String,
    price: Int,
    val mileage: Int,
    val condition: String
) : Auto(brand, model, year, color, price) {
    override fun getInfo() {
        super.getInfo()
        println("Mileage: $mileage, Condition: $condition")
    }
}

class Sport(
    brand: String,
    model: String,
    year: Int,
    color: String,
    price: Int,
    val transmissionType: String,
    val seatingCapacity: Int
) : Auto(brand, model, year, color, price) {
    override fun getInfo() {
        super.getInfo()
        println("Transmission Type: $transmissionType, Seating Capacity: $seatingCapacity")
    }
}

class Hatchback(
    brand: String,
    model: String,
    year: Int,
    color: String,
    price: Int,
    val trunkCapacity: Int?,
    val fuelEfficiency: Int?
) : Auto(brand, model, year, color, price) {
    override fun getInfo() {
        super.getInfo()
        println("Trunk Capacity: $trunkCapacity, Fuel Efficiency: $fuelEfficiency")
    }

}

fun race(auto1: Auto, auto2: Auto): Auto {
    val winner = if (Random.nextBoolean()) auto1 else auto2
    println("Гонка между ${auto1.brand} ${auto1.model} и ${auto2.brand} ${auto2.model}, Победитель: ${winner.brand} ${winner.model}")
    return winner
}


fun ex5() {

    println("Задание 5: ")

    val car1 = Auto.Builder()
        .brand("Tayota")
        .model("XR-P")
        .year(2020)
        .color("Black")
        .price(3000000)
        .build()
    val car2 = Auto.Builder()
        .brand("Lada")
        .model("WCW-6")
        .year(2021)
        .color("Black")
        .price(1000000)
        .build()
    val car3 = Crossover("Haval", "F7", 2023, "Grey", 4000000, "FWD", 180)
    val car4 = Crossover("Changan", "CS35PLUS", 2022, "Silver", 5000000, "AWD", 200)

    val cars = listOf(car1, car2, car3, car4)

    var round = 1
    var remainingCars = cars.toMutableList()

    while (remainingCars.size > 1) {
        println("Круг $round:")
        val winners = mutableListOf<Auto>()

        while (remainingCars.isNotEmpty()) {
            val carIndex1 = Random.nextInt(remainingCars.size)
            var carIndex2 = Random.nextInt(remainingCars.size)

            while (carIndex2 == carIndex1) {
                carIndex2 = Random.nextInt(remainingCars.size)
            }

            winners.add(race(remainingCars[carIndex1], remainingCars[carIndex2]))
            remainingCars.removeAt(carIndex1)
            remainingCars.removeAt(carIndex2 - if (carIndex2 > carIndex1) 1 else 0)
        }

        remainingCars = winners.toMutableList()
        round++
    }

    println("Победитель: ${remainingCars[0].brand} ${remainingCars[0].model}")

}


data class Car(val id: Int)

fun ex6() {
    println()
    println("Задание 6: ")
    println("Введите количество автомобилей:")
    val totalCars = readLine()?.toInt() ?: 0

    val cars = (1..totalCars).map { Car(it) }.toMutableList()

    var round = 1
    while (cars.size > 1) {
        println("Круг $round:")
        val winners = mutableListOf<Car>()

        while (cars.isNotEmpty()) {
            val car1 = cars.random()
            var car2 = cars.random()
            while (car2 == car1) {
                car2 = cars.random()
            }

            println("--- Гонка между ${car1.id} и ${car2.id}")
            if (Random.nextBoolean()) {
                println("Победитель ${car1.id}")
                winners.add(car1)
            } else {
                println("Победитель ${car2.id}")
                winners.add(car2)
            }

            cars.remove(car1)
            cars.remove(car2)
        }

        cars.addAll(winners)
        round++
    }

    println("Победитель: ${cars.first().id}")
}

fun main(){
    ex5()
    ex6()

}








