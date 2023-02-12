package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * Allows user to roll dice and view result on the screen
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)  //finds the button
        rollButton.setOnClickListener { rollDice() }//checks if button is clicked

        rollDice() //do a dice roll on startup
    }



    /**
     * Roll dice and print to screen
     */
    private fun rollDice() {
        val dice = Dice(6)  //creates a dice object
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView) //finds and stores the imageView

        diceImage.contentDescription = diceRoll.toString()

        //draws the dice on screen
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }
}



class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}