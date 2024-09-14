package com.example.activityintent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Ambil elemen input dari layout
        val btnRegister: Button = findViewById(R.id.btnRegister)
        val etUsername: EditText = findViewById(R.id.etUsername)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPhoneNumber: EditText = findViewById(R.id.etPhone)

        btnRegister.setOnClickListener {
            // Ambil data dari input pengguna
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val email = etEmail.text.toString()
            val phoneNumber = etPhoneNumber.text.toString()

            // Kirim data menggunakan intent ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("REGISTERED_USERNAME", username)
            intent.putExtra("REGISTERED_PASSWORD", password)
            intent.putExtra("REGISTERED_EMAIL", email)
            intent.putExtra("REGISTERED_PHONE", phoneNumber)
            startActivity(intent)
        }
    }
}
