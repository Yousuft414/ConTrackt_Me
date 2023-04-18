package com.example.contrackt_me.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.contrackt_me.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text1: EditText = findViewById(R.id.txtEmail)
        val text2: EditText = findViewById(R.id.txtPwd)
        val button: Button = findViewById(R.id.btnLogin)
        val fAuth: FirebaseAuth = FirebaseAuth.getInstance()

        val textView: TextView = findViewById(R.id.lnkRegister)
        textView.setOnClickListener {
            startActivity(Intent(this, Registration::class.java))
        }


        button.setOnClickListener {
            //Toast.makeText(this, "New account created", Toast.LENGTH_SHORT).show()
            val email = text1.getText().toString()
            val password = text2.getText().toString()

            if (TextUtils.isEmpty(email)) {
                text1.setError("Email is Required.")
            }
            if (TextUtils.isEmpty(password)) {
                text2.setError("Password is Required.")
            }

            //authenticate the user

            fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
                if (task.isSuccessful()) {
                    Toast.makeText(this, "User logged in successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, HomeActivity::class.java))
                } else {
                    Toast.makeText(this, "Error has occurred!", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}

