package summer.practice.hw1

open class Car(
    val brand: String,
    val model: String,
    val year: Int,
    val drive: String,
    val horsepower: Int
) {
    fun displayInfo() {
        println("Марка: $brand, Модель: $model, Год выпуска: $year, Привод: $drive, Мощность: $horsepower л.с.")
    }
}
