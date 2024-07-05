package summer.practice.hw1

class Sedan(
    brand: String,
    model: String,
    year: Int,
    drive: String,
    horsepower: Int,
    val trunkSize: Int
) : Car(brand, model, year, drive, horsepower)

