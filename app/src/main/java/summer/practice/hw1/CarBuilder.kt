package summer.practice.hw1

class CarBuilder(
    private var brand: String = "Unknown",
    private var model: String = "Unknown",
    private var year: Int = 2000,
    private var drive: String = "Unknown",
    private var horsepower: Int = 100,
    private var trunkSize: Int = 0,
    private var groundClearance: Int = 0,
    private var payloadCapacity: Int = 0,
    private var doorCount: Int = 2
) {
    fun setBrand(brand: String) = apply { this.brand = brand }
    fun setModel(model: String) = apply { this.model = model }
    fun setYear(year: Int) = apply { this.year = year }
    fun setDrive(drive: String) = apply { this.drive = drive }
    fun setHorsepower(horsepower: Int) = apply { this.horsepower = horsepower }
    fun setTrunkSize(trunkSize: Int) = apply { this.trunkSize = trunkSize }
    fun setGroundClearance(groundClearance: Int) = apply { this.groundClearance = groundClearance }
    fun setPayloadCapacity(payloadCapacity: Int) = apply { this.payloadCapacity = payloadCapacity }
    fun setDoorCount(doorCount: Int) = apply { this.doorCount = doorCount }

    fun build(type: String): Car {
        return when (type) {
            "Sedan" -> Sedan(brand, model, year, drive, horsepower, trunkSize)
            "SUV" -> SUV(brand, model, year, drive, horsepower, groundClearance)
            "Truck" -> Truck(brand, model, year, drive, horsepower, payloadCapacity)
            "Coupe" -> Coupe(brand, model, year, drive, horsepower, doorCount)
            else -> Car(brand, model, year, drive, horsepower)
        }
    }
}