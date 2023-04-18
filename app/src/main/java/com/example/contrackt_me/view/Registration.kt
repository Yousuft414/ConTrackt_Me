package com.example.contrackt_me.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import com.example.contrackt_me.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val text1: EditText = findViewById(R.id.txtEmail)
        val text2: EditText = findViewById(R.id.Name)
        val text3: EditText = findViewById(R.id.txtphoneNum)
        val text4: EditText = findViewById(R.id.txtPwd)
        val button: Button =findViewById(R.id.btnLogin)

        val fAuth: FirebaseAuth = FirebaseAuth.getInstance()

        val textView: TextView = findViewById(R.id.lnkLogin)
        textView.setOnClickListener {
            //Toast.makeText(this, "Test click", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            //val intent = Intent(this, Registration::class.java)
            //startActivity(intent)
        }

        if(fAuth.getCurrentUser() != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }




        button.setOnClickListener{
            //Toast.makeText(this, "New account created", Toast.LENGTH_SHORT).show()
            val email = text1.getText().toString()
            val password = text4.getText().toString()

            if(TextUtils.isEmpty(email)){
                text1.setError("Email is Required.")
            }
            if(TextUtils.isEmpty(password)){
                text4.setError("Password is Required.")
            }

            //register user in firebase
            fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){task->

                    if(task.isSuccessful()){
                        Toast.makeText(this, "New user account created", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Error has occurred!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            //text1.getText().clear()
            //text2.getText().clear()
            //text3.getText().clear()
            //text4.getText().clear()
        }
    }
