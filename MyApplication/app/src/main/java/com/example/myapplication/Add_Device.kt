package com.example.myapplication

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class Add_Device: AppCompatActivity() {
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return super.onContextItemSelected(item)
        setContentView(R.layout.add_device)
    }

}