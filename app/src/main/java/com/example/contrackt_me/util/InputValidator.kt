package com.example.contrackt_me.util

import com.example.contrackt_me.R

class InputValidator {
    companion object {
        fun validateInputs(
            title: String,
            description: String,
            minBudget: String,
            maxBudget: String,
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
            if (minBudget.isBlank()) {
                errors.add("Please enter a minimum budget.")
            } else if (maxBudget.isNotBlank() && minBudget.toFloat() > maxBudget.toFloat()) {
                errors.add("Minimum budget cannot be greater than maximum budget.")
            }
            if (maxBudget.isBlank()) {
                errors.add("Please enter a maximum budget.")
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