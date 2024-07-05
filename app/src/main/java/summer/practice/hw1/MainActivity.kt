package summer.practice.hw1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputField: EditText = findViewById(R.id.inputField)
        val startButton: Button = findViewById(R.id.startButton)
        val resultLabel: TextView = findViewById(R.id.resultLabel)

        startButton.setOnClickListener {
            val carCount = inputField.text.toString().toIntOrNull() ?: return@setOnClickListener
            val cars = generateRandomCars(carCount)
            val result = organizeRaces(cars)
            resultLabel.text = result
        }
    }

    private fun generateRandomCars(count: Int): List<Car> {
        val brands = listOf("Toyota", "Ford", "BMW", "Audi")
        val models = listOf("Машина1", "Машина2", "Машина3", "Машина4", "Машина5", "Машина6")
        val drives = listOf("передний", "задний", "полный")
        val types = listOf("Sedan", "SUV", "Truck", "Coupe")

        return List(count) {
            val type = types.random()
            CarBuilder()
                .setBrand(brands.random())
                .setModel(models.random())
                .setYear(Random.nextInt(2000, 2023))
                .setDrive(drives.random())
                .setHorsepower(Random.nextInt(100, 400))
                .apply {
                    when (type) {
                        "Sedan" -> setTrunkSize(Random.nextInt(300, 600))
                        "SUV" -> setGroundClearance(Random.nextInt(150, 300))
                        "Truck" -> setPayloadCapacity(Random.nextInt(1000, 3000))
                        "Coupe" -> setDoorCount(2)
                    }
                }
                .build(type)
        }
    }

    private fun organizeRaces(cars: List<Car>): String {
        var currentRound = cars.toMutableList()
        var roundNumber = 1
        val resultBuilder = StringBuilder()

        while (currentRound.size > 1) {
            resultBuilder.append("--- Раунд $roundNumber ---\n")
            val nextRound = mutableListOf<Car>()
            val shuffledCars = currentRound.shuffled().toMutableList()
            val racedCars = mutableSetOf<Car>()

            while (shuffledCars.size > 1) {
                val car1 = shuffledCars.removeAt(0)
                var car2: Car? = null
                for (i in shuffledCars.indices) {
                    if (shuffledCars[i] != car1 && !racedCars.contains(shuffledCars[i])) {
                        car2 = shuffledCars.removeAt(i)
                        break
                    }
                }

                if (car2 != null) {
                    val winner = race(car1, car2, resultBuilder)
                    resultBuilder.append("Победитель: ${winner.model}\n")
                    nextRound.add(winner)
                    racedCars.add(car1)
                    racedCars.add(car2)
                } else {
                    shuffledCars.add(0, car1)
                }
            }

            if (shuffledCars.size == 1) {
                resultBuilder.append("${shuffledCars[0].model} - Нет пары, следующий круг\n")
                nextRound.add(shuffledCars.removeAt(0))
            }

            currentRound = nextRound
            roundNumber++
        }

        resultBuilder.append("Победитель гонок: ${currentRound.first().model}")
        return resultBuilder.toString()
    }

    private fun race(car1: Car, car2: Car, resultBuilder: StringBuilder): Car {
        resultBuilder.append("Гонка: ${car1.model} и ${car2.model}\n")
        return if (car1.horsepower > car2.horsepower) car1 else car2
    }
}

