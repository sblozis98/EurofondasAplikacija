package com.example.eurofondasaplikacija

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Prisijungimas : AppCompatActivity() {

    private  lateinit var prmyg: Button
    private  lateinit var vart: EditText
    private  lateinit var slap: EditText
    private  lateinit var dbz: Duombaze

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prisijungimas)

        prmyg = findViewById(R.id.button4)
        vart = findViewById(R.id.editTextTextPersonName2)
        slap = findViewById(R.id.editTextTextPassword3)
        dbz = Duombaze(this)

        prmyg.setOnClickListener{
            val vartxt = vart.text.toString()
            val slaptxt = slap.text.toString()

            if (TextUtils.isEmpty(vartxt) || TextUtils.isEmpty(slaptxt)){
                Toast.makeText(this, "Iveskite slpayvardi ir slaptazodi", Toast.LENGTH_SHORT).show()
            }
            else{
                val tikrvart = dbz.checkuserpass(vartxt, slaptxt)
                if (tikrvart==true){
                    Toast.makeText(this, "Sekmingai prisijungta", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, puslapis::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Neteisingai ivesti duomenys", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}