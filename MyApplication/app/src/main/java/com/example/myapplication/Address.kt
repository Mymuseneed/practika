package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Address : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.address)

        val editText = findViewById<EditText>(R.id.editText)
        val sendDataButton = findViewById<Button>(R.id.sendDataButton)

        sendDataButton.setOnClickListener {
            val data = editText.text.toString()
            val intent = Intent(this, Main_Screen::class.java)
            intent.putExtra("key", data)
            startActivity(intent)
        }
    }
}