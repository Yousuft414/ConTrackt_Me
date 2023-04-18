package com.example.contrackt_me.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.contrackt_me.R

class JobRequestHomeActivity : AppCompatActivity() {
    private lateinit var viewJobRequestsButton: Button
    private lateinit var createJobRequestButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.job_request_home_page)

        viewJobRequestsButton = findViewById(R.id.view_job_requests_button)
        createJobRequestButton = findViewById(R.id.create_job_request_button)

        viewJobRequestsButton.setOnClickListener {
            val intent = Intent(this, ViewJobRequestsActivity::class.java)
            startActivity(intent)
        }
        createJobRequestButton.setOnClickListener {
            val intent = Intent(this, JobRequestActivity::class.java)
            startActivity(intent)
        }
    }
}
