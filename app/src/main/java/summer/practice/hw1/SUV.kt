package summer.practice.hw1

class SUV(
    brand: String,
    model: String,
    year: Int,
    drive: String,
    horsepower: Int,
    val groundClearance: Int
) : Car(brand, model, year, drive, horsepower)

