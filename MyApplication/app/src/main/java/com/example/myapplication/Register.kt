package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {
    private lateinit var emailEditText1: EditText
    private lateinit var passwordEditText1: EditText
    private lateinit var registerButton1: Button
    private lateinit var loginButton1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        emailEditText1 = findViewById(R.id.emailEditText1)
        passwordEditText1 = findViewById(R.id.passwordEditText1)
        registerButton1 = findViewById(R.id.registerButton1)
        loginButton1 = findViewById(R.id.loginButton1)

        loginButton1.isEnabled = false

        emailEditText1 = findViewById(R.id.emailEditText1)

        emailEditText1.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?,
                                       p1: Int, p2: Int, p3: Int) {
                if (p0.isValidEmail1()){
                    emailEditText1.error = null
                }else{
                    emailEditText1.error = "Не правильно"
                }
            }

            override fun afterTextChanged(p0: Editable?) { }
        })


        passwordEditText1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                updateLoginButtonState()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun updateLoginButtonState() {
        val email = emailEditText1.text.toString()
        val password = passwordEditText1.text.toString()

        val isEmailValid = email.isValidEmail1()
        val isPasswordValid = password.isNotEmpty()

        loginButton1.isEnabled = isEmailValid && isPasswordValid
    }

    fun onClickGoLog(view: View) {
        val intent = Intent(this, CreatePin::class.java)
        startActivity(intent)
    }

    fun onClickGolol(view: View) {
        val intent = Intent(this, LogIn::class.java)
        startActivity(intent)
    }
}

fun CharSequence?.isValidEmail1(): Boolean {
    return !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}