package com.sovereign.connectioncalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.sovereign.connectioncalculator.R.id.backButton
import kotlin.random.Random

class ResultActivity : AppCompatActivity() {

    lateinit var back: MaterialButton
    lateinit var namea: TextView
    lateinit var nameb: TextView
    lateinit var result: TextView
    lateinit var loveMessage: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        namea = findViewById(R.id.tv1)
        nameb = findViewById(R.id.tv2)
        result = findViewById(R.id.textView)
        loveMessage = findViewById(R.id.loveMessage)

        back = findViewById(R.id.backButton)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val yourName = intent.getStringExtra("your")
        val partnerName = intent.getStringExtra("partner")

        namea.text = yourName
        nameb.text = partnerName

        val randomNum = Random.nextInt(51, 101)
        result.text = "$randomNum%"

        loveMessage.text = getLoveMessage(randomNum)
    }

    private fun getLoveMessage(percentage: Int): String {
        return when (percentage) {
            in 51..60 -> "There's potential here! With some effort, this relationship could blossom beautifully."
            in 61..70 -> "A promising match! Your connection is strong, keep nurturing it."
            in 71..80 -> "Great compatibility! You two are well on your way to a harmonious relationship."
            in 81..90 -> "Fantastic match! Your bond is exceptionally strong and full of love."
            in 91..100 -> "Perfect pair! Your love is a rare and wonderful thing."
            else -> "Interesting! Love works in mysterious ways."
        }
    }
}