package com.example.contrackt_me.model

// class representation of firebase JSON data
data class JobRequest(
    var title: String,
    var description: String,
    var minHourly: Float,
    var maxHourly: Float,
    var duration: Int = 0,
    var durationUnits: String,
    var requiredCerts: String,
    var contactInfoType: String,
    var email: String = "",
    var phone: String = "",
    var userId: String = ""
)
