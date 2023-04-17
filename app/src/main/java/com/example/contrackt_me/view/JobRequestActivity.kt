package com.example.contrackt_me.view

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
import com.example.contrackt_me.model.JobRequest
import com.example.contrackt_me.util.FirebaseHelper
import com.example.contrackt_me.util.InputValidator

class JobRequestActivity : AppCompatActivity() {
    private lateinit var jobTitleEditText: EditText
    private lateinit var jobDescriptionEditText: EditText
    private lateinit var minHourlyEditText: EditText
    private lateinit var maxHourlyEditText: EditText
    private lateinit var durationEditText: EditText
    private lateinit var durationUnitsSpinner: Spinner
    private lateinit var requiredCertsSpinner: Spinner
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
        minHourlyEditText = findViewById(R.id.min_hourly_edit_text)
        maxHourlyEditText = findViewById(R.id.max_hourly_edit_text)
        durationEditText = findViewById(R.id.duration_edit_text)
        durationUnitsSpinner = findViewById(R.id.duration_units_spinner)
        requiredCertsSpinner = findViewById(R.id.certificates_spinner)
        contactInfoTypeSpinner = findViewById(R.id.contact_info_type_spinner)
        emailEditText = findViewById(R.id.email_edit_text)
        phoneEditText = findViewById(R.id.phone_edit_text)
        errorsTextView = findViewById(R.id.errors_text_view)
        submitButton = findViewById(R.id.submit_button)
    }

    private fun handleFormSubmit() {
        val title = jobTitleEditText.text.toString()
        val description = jobDescriptionEditText.text.toString()
        val minHourly = minHourlyEditText.text.toString()
        val maxHourly = maxHourlyEditText.text.toString()
        val duration = durationEditText.text.toString()
        val durationUnits = durationUnitsSpinner.selectedItem.toString()
        val requiredCerts = requiredCertsSpinner.selectedItem.toString()
        val contactInfoType = contactInfoTypeSpinner.selectedItem.toString()
        val email = emailEditText.text.toString()
        val phone = phoneEditText.text.toString()

        val errors = InputValidator.validateInputs(title, description, minHourly, maxHourly, duration, durationUnits, contactInfoType, email, phone)
        if (errors.isEmpty()) {
            // send job request to database
            val jobRequest = JobRequest(
                title,
                description,
                minHourly.toFloat(),
                maxHourly.toFloat(),
                duration.toInt(),
                durationUnits,
                requiredCerts,
                contactInfoType,
                email,
                phone)
            FirebaseHelper.getInstance().submitJobRequest(jobRequest)
            // clear error text view
            errorsTextView.text = ""
            errorsTextView.visibility = View.GONE
        } else {
            // errors available to display
            errorsTextView.text = errors.joinToString("\n")
            errorsTextView.visibility = View.VISIBLE
        }
    }

    private fun spinnerSetup() {
        //duration units array adapter
        ArrayAdapter.createFromResource(
            this,
            R.array.duration_units,
            android.R.layout.simple_spinner_item).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            durationUnitsSpinner.adapter = arrayAdapter
        }

        //duration units onItemSelectedListener
        durationUnitsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                if (selectedItem == "Unsure") {
                    durationEditText.visibility = View.GONE
                }  else {
                    durationEditText.visibility = View.VISIBLE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        //required certs array adapter
        ArrayAdapter.createFromResource(
            this,
            R.array.certificates,
            android.R.layout.simple_spinner_item).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            requiredCertsSpinner.adapter = arrayAdapter
        }

        //contact info type array adapter
        ArrayAdapter.createFromResource(
            this,
            R.array.contact_info_types,
            android.R.layout.simple_spinner_item).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            contactInfoTypeSpinner.adapter = arrayAdapter
        }

        //contact info type onItemSelectedListener
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