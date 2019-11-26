package com.example.anydecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val availableChoices = arrayListOf("Please add at least one option!")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideButton.setOnClickListener {
            val random = Random()
            val randomChoice = random.nextInt(availableChoices.count())
            chosenOption.text = availableChoices[randomChoice]
        }

        addOptionButton.setOnClickListener {
            val newOption = addOptionText.text.toString().trim()
            if (newOption.isNotEmpty()) {
                availableChoices.add(newOption)
                addOptionText.text.clear()

                if (availableChoices[0] == "Please add at least one option!") {
                    availableChoices.removeAt(0)
                }
            }
        }
    }
}
