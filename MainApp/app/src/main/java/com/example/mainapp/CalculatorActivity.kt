package com.example.mainapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val message = intent.getStringExtra("message")
        findViewById<TextView>(R.id.text_view_message).text = message

        // Here you would add the actual CalculatorFragment or logic from the previous app
    }
}
