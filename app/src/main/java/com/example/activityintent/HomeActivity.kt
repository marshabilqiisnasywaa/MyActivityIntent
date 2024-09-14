package com.example.activityintent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val welcomeUsername: TextView = findViewById(R.id.welcomeUsername)
        val emailActivated: TextView = findViewById(R.id.emailActivated)
        val phone: TextView = findViewById(R.id.phone)

        // Ambil data dari intent
        val username = intent.getStringExtra("USERNAME")
        val email = intent.getStringExtra("EMAIL")
        val phoneNumber = intent.getStringExtra("PHONE")

        // Pastikan untuk menghindari nilai null dan berikan fallback jika data tidak ada
        welcomeUsername.text = "Welcome ${username ?: "User"}"
        emailActivated.text = "Your ${email ?: "not available"} has been activated"
        phone.text = "Your ${phoneNumber ?: "not available"} has been registered"
    }
}
