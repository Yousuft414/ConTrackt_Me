package com.example.contrackt_me.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.contrackt_me.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text1: EditText = findViewById(R.id.txtEmail)
        val text2: EditText = findViewById(R.id.txtPwd)

        val textView: TextView= findViewById(R.id.lnkRegister)
        textView.setOnClickListener{
            //Toast.makeText(this, "Test click", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }

        val button: Button =findViewById(R.id.btnLogin)
        button.setOnClickListener{
            Toast.makeText(this, "User authenticated", Toast.LENGTH_SHORT).show()
            text1.getText().clear()
            text2.getText().clear()
        }
    }
}