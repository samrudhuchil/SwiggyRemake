package com.samrudh.swiggyremake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ForgotPasswordDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password_details)
        title = "Forgot Password Details"
        val txtForgotEmail: TextView = findViewById(R.id.txtForgotEmailDetail)
        val txtForgotMobile: TextView = findViewById(R.id.txtForgotMobileDetail)
        txtForgotMobile.text = intent.getStringExtra("Forgot Mobile")
        txtForgotEmail.text = intent.getStringExtra("Forgot Email")
    }
}
