package com.example.login

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.login.models.User

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        // Ambil data User dari intent
        val user = intent.getParcelableExtra<User>("user")

        // Ambil TextView dari layout
        val welcomeText = findViewById<TextView>(R.id.textWelcome)

        // Tampilkan nama user (jika ada)
        if (user != null) {
            welcomeText.text = "Welcome, ${user.name}!"
        } else {
            welcomeText.text = "Welcome!"
        }
    }
}
