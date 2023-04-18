package com.example.contrackt_me.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.contrackt_me.R
import com.example.contrackt_me.model.JobRequest

class JobRequestsAdapter(context: Context, jobRequests: List<JobRequest>) :
    ArrayAdapter<JobRequest>(context, 0, jobRequests) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.job_request_item, parent, false)
        }

        val jobRequest = getItem(position)

        val titleTextView = listItemView!!.findViewById<TextView>(R.id.job_title_text_view)
        val descriptionTextView = listItemView.findViewById<TextView>(R.id.job_description_text_view)

        titleTextView.text = jobRequest!!.title
        descriptionTextView.text = jobRequest.description

        return listItemView
    }
}
