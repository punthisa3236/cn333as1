package com.example.guess

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*
import android.widget.Toast;


class MainActivity : AppCompatActivity() {

    private lateinit var hint: TextView
    private lateinit var inputNumber: EditText
    private lateinit var summit: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputNumber = findViewById(R.id.inputNumber)
        summit = findViewById(R.id.summit)
        hint = findViewById(R.id.hint)


        randomNumbers()
    }

    private fun randomNumbers() {
        val r = Random()
        var number = r.nextInt(1000)

        var time = 0

        summit.setOnClickListener {
            var check_null = inputNumber.text.isNullOrEmpty()

            if (!check_null) {
                var checkInput = Integer.parseInt(inputNumber.text.toString())
                if (number == checkInput) {
                    var num = number.toString()
                    var input = inputNumber.text.toString()
                    time++
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("keyname", time.toString())
                    startActivity(intent)

                } else {
                    if (checkInput > number) {
                        hint.text = "Hints: Try lower"
                    } else {
                        hint.text = "Hints: Try higher"
                    }
                    time++

                }
            }else{
                val toast = Toast.makeText(this@MainActivity, "Please Enter Number", Toast.LENGTH_SHORT)
                    toast.setGravity(24, 20, 150)

                    toast.show()

            }





        }

    }

}