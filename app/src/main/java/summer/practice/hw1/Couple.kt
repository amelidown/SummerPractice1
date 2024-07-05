package summer.practice.hw1

class Coupe(
    brand: String,
    model: String,
    year: Int,
    drive: String,
    horsepower: Int,
    val doorCount: Int
) : Car(brand, model, year, drive, horsepower)

