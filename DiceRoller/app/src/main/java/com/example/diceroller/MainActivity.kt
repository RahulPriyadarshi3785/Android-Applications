package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.diceroller.R.string.newRollValue
import com.example.diceroller.R.string.rollValue
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var rollText: TextView
    private lateinit var diceView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            val newRolledNumber = rollDice()
            if(newRolledNumber.toString() != getString(rollValue))
                rollButton.text = getString(newRollValue)
            Toast.makeText(this, "You Rolled : $newRolledNumber", Toast.LENGTH_SHORT).show()
        }
        rollText = findViewById(R.id.result_text)
        diceView = findViewById(R.id.dice_view)
    }

    private fun rollDice(): Number {
        val newRolledNumber = Random().nextInt(6) + 1
        val drawableResource = when (newRolledNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceView.setImageResource(drawableResource)
        rollText.text = newRolledNumber.toString()
        return newRolledNumber
    }
}