package com.example.activityintent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    // Variabel untuk menyimpan username, password, email, dan nomor telepon yang telah didaftarkan
    private var registeredUsername: String? = null
    private var registeredPassword: String? = null
    private var email: String? = null
    private var phoneNumber: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Mengambil data dari RegisterActivity yang dikirim melalui Intent
        registeredUsername = intent.getStringExtra("REGISTERED_USERNAME")
        registeredPassword = intent.getStringExtra("REGISTERED_PASSWORD")
        email = intent.getStringExtra("REGISTERED_EMAIL")
        phoneNumber = intent.getStringExtra("REGISTERED_PHONE")

        // Inisialisasi komponen UI dari layout
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val etUsername: EditText = findViewById(R.id.etUsername)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val tvRegister: TextView = findViewById(R.id.tvRegister)
        val checkTerms: CheckBox = findViewById(R.id.checkTerms)
        val tvTerms: TextView = findViewById(R.id.tvTerms)

        // Aksi ketika tombol Login ditekan
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString() // Mengambil input username dari pengguna
            val password = etPassword.text.toString() // Mengambil input password dari pengguna

            // Verifikasi apakah username dan password yang dimasukkan sesuai dengan data yang didaftarkan
            if (username == registeredUsername && password == registeredPassword) {
                // Jika sesuai, pindah ke halaman HomeActivity dan mengirim data username, email, dan nomor telepon
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("USERNAME", username)
                intent.putExtra("EMAIL", email)
                intent.putExtra("PHONE", phoneNumber)
                startActivity(intent)
            } else {
                // Jika username atau password salah, tampilkan pesan kesalahan
                etUsername.error = "Username atau Password salah"
                etPassword.error = "Username atau Password salah"
            }
        }

        // Aksi ketika teks "Register" ditekan
        tvRegister.setOnClickListener {
            // Pindah ke halaman RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
