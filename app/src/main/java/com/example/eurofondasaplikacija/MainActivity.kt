package com.example.eurofondasaplikacija

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnreg: Button
    private lateinit var btnpr: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnreg = findViewById(R.id.button)
        btnpr = findViewById(R.id.button2)

        btnreg.setOnClickListener {
            val intent = Intent(this, registracija::class.java)
            startActivity(intent)
        }

        btnpr.setOnClickListener{
            val intent = Intent(this, Prisijungimas::class.java)
            startActivity(intent)
        }

    }
}