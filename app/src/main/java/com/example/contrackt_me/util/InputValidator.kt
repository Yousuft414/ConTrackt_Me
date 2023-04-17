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
                errors.add("Please enter a title.")
            }
            if (description.isBlank()) {
                errors.add("Please enter a description.")
            }
            if (minBudget.isBlank()) {
                errors.add("Please enter a minimum budget.")
            } else if (minBudget.toFloat() > maxBudget.toFloat()) {
                errors.add("Min budget cannot be greater than max budget.")
            }
            if (maxBudget.isBlank()) {
                errors.add("Please enter a maximum budget")
            } else if (maxBudget.toFloat() < minBudget.toFloat()) {
                errors.add("max budget cannot be lower than min budget.")
            }
            if (contactInfoType == "Email" && email.isEmpty()) {
                errors.add("Please enter email.")
            }
            if (contactInfoType == "Phone" && phone.isEmpty()) {
                errors.add("Please enter phone number.")
            }
            return errors
        }
    }
}