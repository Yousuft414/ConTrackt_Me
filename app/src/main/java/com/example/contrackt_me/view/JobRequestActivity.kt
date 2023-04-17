package com.example.contrackt_me.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.contrackt_me.R
import com.example.contrackt_me.util.InputValidator

class JobRequestActivity : AppCompatActivity() {
    private lateinit var jobTitleEditText: EditText
    private lateinit var jobDescriptionEditText: EditText
    private lateinit var minBudgetEditText: EditText
    private lateinit var maxBudgetEditText: EditText
    private lateinit var contactInfoTypeSpinner : Spinner
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var errorsTextView: TextView
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.job_submission_form_page)

        getAllLayoutElements()

        spinnerSetup()
        submitButton.setOnClickListener {
            handleFormSubmit()
        }
    }

    private fun getAllLayoutElements() {
        jobTitleEditText = findViewById(R.id.job_title_edit_text)
        jobDescriptionEditText = findViewById(R.id.job_description_edit_text)
        minBudgetEditText = findViewById(R.id.min_budget_edit_text)
        maxBudgetEditText = findViewById(R.id.max_budget_edit_text)
        emailEditText = findViewById(R.id.email_edit_text)
        phoneEditText = findViewById(R.id.phone_edit_text)
        errorsTextView = findViewById(R.id.errors_text_view)
        contactInfoTypeSpinner = findViewById(R.id.contact_info_type_spinner)
        submitButton = findViewById(R.id.submit_button)
    }

    private fun handleFormSubmit() {
        val title = jobTitleEditText.text.toString()
        val description = jobDescriptionEditText.text.toString()
        val minBudget = minBudgetEditText.text.toString()
        val maxBudget = maxBudgetEditText.text.toString()
        val contactInfoType = contactInfoTypeSpinner.selectedItem.toString()
        val email = emailEditText.text.toString()
        val phone = phoneEditText.text.toString()

        val errors = InputValidator.validateInputs(title, description, minBudget, maxBudget, contactInfoType, email, phone)
        if (errors.isEmpty()) {
            // todo: inputs valid. submit to database.
            errorsTextView.text = ""
            errorsTextView.visibility = View.GONE
        } else {
            // errors available to display
            errorsTextView.text = errors.joinToString("\n")
            errorsTextView.visibility = View.VISIBLE
        }
    }

    private fun spinnerSetup() {
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