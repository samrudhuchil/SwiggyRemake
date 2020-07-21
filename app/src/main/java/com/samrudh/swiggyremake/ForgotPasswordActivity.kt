package com.samrudh.swiggyremake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var etForgotMobile: EditText
    lateinit var etForgotEmail: EditText
    lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        title = "Forgot Password"
        etForgotMobile = findViewById(R.id.etForgotMobile)
        etForgotEmail = findViewById(R.id.etForgotEmail)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {
            var forgotMobile = etForgotMobile.text.toString()
            var forgotEmail = etForgotEmail.text.toString()
            val intent =
                Intent(this@ForgotPasswordActivity, ForgotPasswordDetailsActivity::class.java)
            intent.putExtra("Forgot Mobile", forgotMobile)
            intent.putExtra("Forgot Email", forgotEmail)
            startActivity(intent)
            finish()
        }

    }
}
