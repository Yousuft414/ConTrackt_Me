package com.example.contrackt_me.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.contrackt_me.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        // Retrieve the Job Request button element
        val jobRequestButton: Button = findViewById(R.id.job_request_button)
        val filterCompareButton: Button = findViewById(R.id.filter_compare_button)

        // Set up an OnClickListener for the Job Request button
        jobRequestButton.setOnClickListener {
            val intent = Intent(this, JobRequestHomeActivity::class.java)
            startActivity(intent)
        }

        // Set up an OnClickListener for the Filter and Compare button
        filterCompareButton.setOnClickListener {
            val intent = Intent(this, TrackingLocationActivity::class.java)
            startActivity(intent)
        }
    }
}
