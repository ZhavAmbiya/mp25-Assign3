package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.login.models.User

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameField = findViewById<EditText>(R.id.editTextUsername)
        val passwordField = findViewById<EditText>(R.id.editTextPassword)
        val loginButton = findViewById<Button>(R.id.buttonLogin)
        val registerText = findViewById<TextView>(R.id.textRegister)

        // Ambil data dari RegisterActivity jika ada
        val registeredName = intent.getStringExtra("registered_name")
        val registeredEmail = intent.getStringExtra("registered_email")
        val registeredPassword = intent.getStringExtra("registered_password")


        loginButton.setOnClickListener {
            val inputEmail = usernameField.text.toString().trim()
            val inputPassword = passwordField.text.toString().trim()

            if (inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {

                // Validasi email dan password
                if (inputEmail == registeredEmail && inputPassword == registeredPassword) {
                    // Data cocok, lanjut ke LandingActivity
                    val user = User(registeredName ?: "User", registeredEmail ?: "", registeredPassword ?: "")
                    val intent = Intent(this, LandingActivity::class.java)
                    intent.putExtra("user", user)
                    startActivity(intent)
                } else {
                    // Email atau password salah
                    Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Silakan isi semua kolom", Toast.LENGTH_SHORT).show()
            }
        }

        registerText.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
