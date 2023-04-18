package com.example.contrackt_me.model

// class representation of firebase JSON data
data class JobRequest(
    var title: String = "",
    var description: String = "",
    var minHourly: Float = 0f,
    var maxHourly: Float = 0f,
    var duration: Int = 0,
    var durationUnits: String = "",
    var requiredCerts: String = "",
    var contactInfoType: String = "",
    var email: String = "",
    var phone: String = "",
    var userId: String = ""
): java.io.Serializable {
    constructor() : this("", "", 0f, 0f, 0, "", "", "", "", "", "")
}

