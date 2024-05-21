package com.sovereign.connectioncalculator

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    lateinit var yourName: EditText
    lateinit var partnerName: EditText
    lateinit var img: ImageView
    lateinit var calculateButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        img = findViewById(R.id.gif)
        yourName = findViewById(R.id.yourName)
        partnerName = findViewById(R.id.partnerName)

        Glide.with(this)
            .load(R.drawable.heart)
            .into(img)


        calculateButton = findViewById(R.id.calculate)

        calculateButton.setOnClickListener {
            val your = yourName.text.toString()
            val partner = partnerName.text.toString()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("your", your)
            intent.putExtra("partner", partner)
            startActivity(intent)
        }




        }
    }

