package com.example.contact_list


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactDetailsActivity : AppCompatActivity() {

    private lateinit var contactImage: ImageView
    private lateinit var contactName: TextView
    private lateinit var contactPhone: TextView
    private lateinit var contactEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        contactImage = findViewById(R.id.contactImage)
        contactName = findViewById(R.id.contactName)
        contactPhone = findViewById(R.id.contactPhone)
        contactEmail = findViewById(R.id.contactEmail)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val email = intent.getStringExtra("email")

        contactName.text = name
        contactPhone.text = phone
        contactEmail.text = email
    }
}
