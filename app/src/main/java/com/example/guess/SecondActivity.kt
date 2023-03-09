package com.example.guess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class SecondActivity : AppCompatActivity() {

    private lateinit var buttonPlay: Button
    private lateinit var getTime: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        buttonPlay = findViewById(R.id.buttonPlay)
        getTime = findViewById(R.id.getTime)
        testRun()




    }

    private fun testRun() {
        val setTime:String = intent.getStringExtra("keyname").toString()
        getTime.text = "You have tried "+setTime+" times"

        buttonPlay.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


    }


}


