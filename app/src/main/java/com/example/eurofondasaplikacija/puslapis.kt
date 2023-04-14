package com.example.eurofondasaplikacija

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class puslapis : AppCompatActivity() {
    private  lateinit var mg: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puslapis)

        mg = findViewById(R.id.button6)

        mg.setOnClickListener{
            val intent = Intent(applicationContext, Prisijungimas::class.java)
            startActivity(intent)
        }
    }
}