package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class Main_Screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)

        val textView = findViewById<TextView>(R.id.textView)

        val receivedData = intent.getStringExtra("key")
        if (receivedData != null) {
            textView.text = receivedData
        }
    }
}