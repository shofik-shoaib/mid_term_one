package com.example.mainapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mainapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculator.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            intent.putExtra("message", "Hello from MainActivity")
            startActivity(intent)
        }

        binding.buttonContacts.setOnClickListener {
            val intent = Intent(this, ContactsActivity::class.java)
            intent.putExtra("message", "Hello from MainActivity")
            startActivity(intent)
        }
    }
}
