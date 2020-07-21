package com.samrudh.swiggyremake

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class SwiggyActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var imgBtnLogout: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swiggy)
        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        title = "Swiggy"
        val mobile: TextView = findViewById(R.id.txtLoginMobile)
        val password: TextView = findViewById(R.id.txtLoginPassword)
        mobile.text = sharedPreferences.getString("Mobile", "Not Given").toString()
        password.text = sharedPreferences.getString("Password", "Not Given").toString()

        imgBtnLogout = findViewById(R.id.imgBtnLogout)

        imgBtnLogout.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            startActivity(Intent(this@SwiggyActivity, LoginActivity::class.java))
            finish()
        }


    }
}