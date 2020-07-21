package com.samrudh.swiggyremake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MyDetailsActivity : AppCompatActivity() {
    lateinit var txtName: TextView
    lateinit var txtEmail: TextView
    lateinit var txtAddress: TextView
    lateinit var txtMobile: TextView
    lateinit var txtPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_details)
        title = "My Details"
        txtName = findViewById(R.id.txtName)
        txtEmail = findViewById(R.id.txtEmail)
        txtMobile = findViewById(R.id.txtMobile)
        txtAddress = findViewById(R.id.txtAddress)
        txtPassword = findViewById(R.id.txtPassword)

        txtName.text = intent.getStringExtra("Name")
        txtEmail.text = intent.getStringExtra("Email")
        txtMobile.text = intent.getStringExtra("Mobile")
        txtAddress.text = intent.getStringExtra("Address")
        txtPassword.text = intent.getStringExtra("Password")

    }
}
