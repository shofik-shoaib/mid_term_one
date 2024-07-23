package com.example.contact_list


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var spinner: Spinner
    private lateinit var button: Button

    private val contacts = listOf(
        Contact("Zakir Hossain", "123-456-7890", "zakir.hossain@gmail.com", "Family"),
        Contact("Akash Chopra", "098-765-4321", "jane.smith@gmail.com", "Friends"),
        Contact("Anik Dutta", "555-123-4567", "emily.johnson@gmail.com", "Colleagues"),
        Contact("Alamin Buddy", "777-888-9999", "alamin.buddy@gmail.com", "Close Friends"),

        Contact("Shakil Mama", "123-456-7890", "shakil.mam@gmail.com", "Family"),
        Contact("Sumit Panchi", "098-765-4321", "sumit.panchi@gmail.com", "Friends"),
        Contact("Prahas Bhai", "555-123-4567", "prahas.bhai@gmail.com", "Colleagues"),
        Contact("Zakia Silvana", "777-888-9999", "zakia.silvana@gmail.com", "Close Friends"),

        Contact("Mim Mimo", "123-456-7890", "mim.mimo@gmail.com", "Family"),
        Contact("Jui Jui", "098-765-4321", "jui.jui@gmail.com", "Friends"),
        Contact("Kamrul Mama", "555-123-4567", "kamrul.ahsan@gmail.com", "Colleagues"),
        Contact("Pronab Ghosh", "777-888-9999", "pronab.ghosh@gmail.com", "Close Friends")
    )

    private var filteredContacts: List<Contact> = contacts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        spinner = findViewById(R.id.spinner)
        button = findViewById(R.id.button)

        val spinnerAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.contact_options,
            android.R.layout.simple_spinner_item
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedCategory = parent.getItemAtPosition(position) as String
                filteredContacts = contacts.filter { it.category == selectedCategory }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle no selection
            }
        }
        button.setOnClickListener {
            val adapter = ContactListAdapter(this, filteredContacts)
            listView.adapter = adapter

            listView.setOnItemClickListener { _, _, position, _ ->
                val selectedContact = filteredContacts[position]
                val intent = Intent(this, ContactDetailsActivity::class.java).apply {
                    putExtra("name", selectedContact.name)
                    putExtra("phone", selectedContact.phone)
                    putExtra("email", selectedContact.email)
                }
                startActivity(intent)
            }
        }
    }
}
