package com.example.contact_list


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class ContactListAdapter(context: Context, private val contacts: List<Contact>) : ArrayAdapter<Contact>(context, 0, contacts) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contact = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.contact_list_item, parent, false)

        val contactImage = view.findViewById<ImageView>(R.id.contactImage)
        val contactName = view.findViewById<TextView>(R.id.contactName)

        contactImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.default_contact_image))
        contactName.text = contact?.name

        return view
    }
}
