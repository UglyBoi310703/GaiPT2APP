package com.example.giaiptapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputA = findViewById<EditText>(R.id.inputA)
        val inputB = findViewById<EditText>(R.id.inputB)
        val inputC = findViewById<EditText>(R.id.inputC)
        val btnSolve = findViewById<Button>(R.id.btnSolve)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnSolve.setOnClickListener {
            val a = inputA.text.toString().toDoubleOrNull()
            val b = inputB.text.toString().toDoubleOrNull()
            val c = inputC.text.toString().toDoubleOrNull()

            if (a == null || b == null || c == null) {
                tvResult.text = "Vui lòng nhập đầy đủ và đúng hệ số!"
                return@setOnClickListener
            }

            if (a == 0.0) {
                // Phương trình bậc nhất
                if (b == 0.0) {
                    tvResult.text = if (c == 0.0) "Vô số nghiệm" else "Vô nghiệm"
                } else {
                    val x = -c / b
                    tvResult.text = "Phương trình có 1 nghiệm: x = $x"
                }
            } else {
                val delta = b * b - 4 * a * c
                when {
                    delta < 0 -> tvResult.text = "Phương trình vô nghiệm"
                    delta == 0.0 -> {
                        val x = -b / (2 * a)
                        tvResult.text = "Phương trình có nghiệm kép: x = $x"
                    }
                    else -> {
                        val x1 = (-b + sqrt(delta)) / (2 * a)
                        val x2 = (-b - sqrt(delta)) / (2 * a)
                        tvResult.text = "Phương trình có 2 nghiệm phân biệt:\nx1 = $x1\nx2 = $x2"
                    }
                }
            }
        }
    }
}
