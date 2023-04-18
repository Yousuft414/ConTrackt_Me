package com.example.contrackt_me.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.contrackt_me.R
import com.example.contrackt_me.util.FirebaseHelper

class ViewJobRequestsActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var jobRequestsListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_job_requests_page)

        progressBar = findViewById(R.id.progress_bar)
        progressBar.visibility = View.VISIBLE
        jobRequestsListView = findViewById(R.id.job_requests_list_view)

        FirebaseHelper.getInstance().getJobRequests { jobRequests ->
            val adapter = JobRequestsAdapter(this, jobRequests)
            jobRequestsListView.adapter = adapter
            progressBar.visibility = View.GONE
        }
    }
}
