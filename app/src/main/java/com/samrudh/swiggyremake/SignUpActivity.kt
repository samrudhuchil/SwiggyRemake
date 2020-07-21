package com.samrudh.swiggyremake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etMobile: EditText
    lateinit var etAddress: EditText
    lateinit var etPassword: EditText
    lateinit var etConfirmPassword: EditText
    lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        title = "SignUp"
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etMobile = findViewById(R.id.etMobile)
        etAddress = findViewById(R.id.etAddress)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)
        val intent = Intent(this@SignUpActivity, MyDetailsActivity::class.java)

        btnRegister.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val mobile = etMobile.text.toString()
            val address = etAddress.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()
            if (password==confirmPassword){
                intent.putExtra("Name", name)
                intent.putExtra("Email", email)
                intent.putExtra("Mobile", mobile)
                intent.putExtra("Address", address)
                intent.putExtra("Password", password)
                Toast.makeText(this@SignUpActivity, "Registered Successfully", Toast.LENGTH_LONG).show()
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this@SignUpActivity, "Password does not match!", Toast.LENGTH_LONG).show()
            }
        }
    }
}