package com.example.contrackt_me.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.contrackt_me.R

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val text1: EditText = findViewById(R.id.txtEmail)
        val text2: EditText = findViewById(R.id.Name)
        val text3: EditText = findViewById(R.id.txtphoneNum)
        val text4: EditText = findViewById(R.id.txtPwd)

        val button: Button =findViewById(R.id.btnLogin)
        button.setOnClickListener{
            Toast.makeText(this, "New account created", Toast.LENGTH_SHORT).show()
            text1.getText().clear()
            text2.getText().clear()
            text3.getText().clear()
            text4.getText().clear()
        }
    }
}