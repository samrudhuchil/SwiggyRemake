package com.samrudh.swiggyremake

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var etLoginMobile: EditText
    lateinit var etLoginPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtSignUp: TextView
    lateinit var sharedPreferences: SharedPreferences
    var validMobile = arrayOf<String>("7021406017", "9168669531", "8692990864")
    var validPassword = arrayOf<String>("sam.2000", "naren.2000", "ritik.2000")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Log In"
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        setContentView(R.layout.activity_login)
        val intentCheck = Intent(this@LoginActivity, SwiggyActivity::class.java)

        if (isLoggedIn) {
            startActivity(intentCheck)
            finish()
        }

        etLoginMobile = findViewById(R.id.etLoginMobile)
        etLoginPassword = findViewById(R.id.etLoginPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtSignUp = findViewById(R.id.txtSignUp)

        btnLogin.setOnClickListener {
            val mobile = etLoginMobile.text.toString()
            val password = etLoginPassword.text.toString()
            val intent = Intent(this@LoginActivity, SwiggyActivity::class.java)
            if (validMobile.contains(mobile)) {
                val index = validMobile.indexOf(mobile)
                if (password == validPassword[index]) {
//                    intent.putExtra("Mobile", mobile)
//                    intent.putExtra("Password", password)
                    sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
                    sharedPreferences.edit().putString("Mobile", mobile).apply()
                    sharedPreferences.edit().putString("Password", password).apply()
                    Toast.makeText(this@LoginActivity, "Logged In", Toast.LENGTH_LONG).show()
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this@LoginActivity, "Wrong Credentials", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this@LoginActivity, "Wrong Credentials", Toast.LENGTH_LONG).show()
            }
        }

        txtForgotPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
        }

        txtSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        }
    }

}