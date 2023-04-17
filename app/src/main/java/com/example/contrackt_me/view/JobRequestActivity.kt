package com.example.contrackt_me.view

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.contrackt_me.R

class JobRequestActivity : AppCompatActivity() {
    private lateinit var contactInfoTypeSpinner : Spinner
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.job_submission_form_page)

        contactInfoTypeSpinner = findViewById(R.id.contact_info_type_spinner)
        emailEditText = findViewById(R.id.email_edit_text)
        phoneEditText = findViewById(R.id.phone_edit_text)

        //set up array adapter
        ArrayAdapter.createFromResource(
            this,
            R.array.contact_info_types,
            android.R.layout.simple_spinner_item).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            contactInfoTypeSpinner.adapter = arrayAdapter
        }

        //set up onItemSelectedListener
        contactInfoTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                when (selectedItem) {
                    "Email" -> {
                        emailEditText.visibility = View.VISIBLE
                        phoneEditText.visibility = View.GONE
                    }
                    "Phone" -> {
                        emailEditText.visibility = View.GONE
                        phoneEditText.visibility = View.VISIBLE
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }
}