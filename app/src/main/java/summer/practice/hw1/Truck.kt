package summer.practice.hw1

class Truck(
    brand: String,
    model: String,
    year: Int,
    drive: String,
    horsepower: Int,
    val payloadCapacity: Int
) : Car(brand, model, year, drive, horsepower)