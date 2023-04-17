package com.example.contrackt_me.util

class InputValidator {
    companion object {
        fun validateInputs(
            title: String,
            description: String,
            minHourly: String,
            maxHourly: String,
            duration: String,
            durationUnits: String,
            contactInfoType: String,
            email: String,
            phone: String
        ) : List<String> {
            val errors = mutableListOf<String>()

            if (title.isBlank()) {
                errors.add("Please enter a job title.")
            }
            if (description.isBlank()) {
                errors.add("Please enter a job description.")
            }
            if (minHourly.isBlank()) {
                errors.add("Please enter a minimum hourly rate.")
            } else if (maxHourly.isNotBlank() && minHourly.toFloat() > maxHourly.toFloat()) {
                errors.add("Minimum rate cannot be greater than maximum rate.")
            }
            if (maxHourly.isBlank()) {
                errors.add("Please enter a maximum hourly rate.")
            }
            if (durationUnits != "Unsure") {
                if (duration.isBlank()){
                    errors.add("Please enter a duration approximate.")
                } else if (duration.toInt() <= 0) {
                    errors.add("Please enter a valid job duration.")
                }
            }
            if (contactInfoType == "Email") {
                if (email.isBlank()) {
                    errors.add("Please enter email.")
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    errors.add("Please enter a valid email address.")
                }
            } else if (contactInfoType == "Phone") {
                if (phone.isBlank()) {
                    errors.add("Please enter phone number.")
                } else if (!android.util.Patterns.PHONE.matcher(phone).matches()) {
                    errors.add("Please enter a valid phone number.")
                }
            }
            return errors
        }
    }
}