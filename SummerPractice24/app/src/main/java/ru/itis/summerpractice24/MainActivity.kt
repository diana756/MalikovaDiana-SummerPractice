package ru.itis.summerpractice24

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        val carCountEditText = findViewById<EditText>(R.id.carCountEditText)

        startButton.setOnClickListener {
            val carCount = carCountEditText.text.toString().toIntOrNull()
            if (carCount != null && carCount > 1) {
                val cars = (1..carCount).map { Car(it) }.toMutableList()
                var round = 1
                while (cars.size > 1) {
                    println("Круг $round гонок:")
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
            } else {
                println("Введите число больше 1")
            }
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

        }
    }
}


