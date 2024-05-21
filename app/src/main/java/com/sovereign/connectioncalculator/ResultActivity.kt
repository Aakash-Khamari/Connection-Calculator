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

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        namea = findViewById(R.id.tv1)
        nameb = findViewById(R.id.tv2)

        back = findViewById(backButton)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val yourName = intent.getStringExtra("your")
        val partnerName = intent.getStringExtra("partner")

        namea.text= "$yourName"
        nameb.text ="$partnerName"

        result = findViewById(R.id.textView)
        val randomNum = Random.nextInt(50,101)

        result.text=randomNum.toString()+"%"

    }
}