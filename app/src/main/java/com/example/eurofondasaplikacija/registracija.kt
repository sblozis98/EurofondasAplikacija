package com.example.eurofondasaplikacija

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class registracija : AppCompatActivity() {

    private  lateinit var slapvard: EditText
    private  lateinit var slapzod: EditText
    private  lateinit var pslapzod: EditText
    private  lateinit var regmyg: Button
    private  lateinit var myg: Button
    private  lateinit var db: Duombaze

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registracija)

        slapvard = findViewById(R.id.editTextTextPersonName)
        slapzod = findViewById(R.id.editTextTextPassword)
        pslapzod = findViewById(R.id.editTextTextPassword2)
        regmyg = findViewById(R.id.button3)
        myg = findViewById(R.id.button5)
        db = Duombaze(this)

        regmyg.setOnClickListener{
            val slapvardtxt = slapvard.text.toString()
            val slapzodtxt = slapzod.text.toString()
            val pslapzodtxt = pslapzod.text.toString()
            val SaugotiDuom = db.insertdata(slapvardtxt, slapzodtxt)

            if (TextUtils.isEmpty(slapvardtxt) || TextUtils.isEmpty(slapzodtxt) || TextUtils.isEmpty(pslapzodtxt)){
                Toast.makeText(this, "Iveskite slpayvardi, slaptazodi ir slaptazodzio pakartojima", Toast.LENGTH_SHORT).show()
            }
            else{
                if (slapzodtxt.equals(pslapzodtxt)){
                    if (SaugotiDuom==true){
                        Toast.makeText(this, "Uzsiregistruota sekmingai", Toast.LENGTH_SHORT).show()
                    }
                    // kazkodel else isijungia kai issaugo duomenis
                    else{
                        Toast.makeText(this, "Uzregistruoti duomenys", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this, "Slaptazodziai nesutampa", Toast.LENGTH_SHORT).show()
                }
            }
        }
    myg.setOnClickListener{
        val intent = Intent(applicationContext, Prisijungimas::class.java)
        startActivity(intent)
    }
    }
}