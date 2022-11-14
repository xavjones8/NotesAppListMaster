package com.example.notesapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val txtFirstName = findViewById<EditText>(R.id.txtFirstName)
        val txtLastName = findViewById<EditText>(R.id.txtLastName)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val txtPassword = findViewById<EditText>(R.id.txtPassword)
        val btnSubmit = findViewById<Button>(R.id.btnCreateUser)



        btnSubmit.setOnClickListener() {
            val pref = getSharedPreferences("USER_DETAILS", Context.MODE_PRIVATE)
            val editor = pref.edit()

            editor.putString(this.getString(R.string.first_name), txtFirstName.text.toString())
            editor.putString(this.getString(R.string.last_name), txtLastName.text.toString())
            editor.putString(this.getString(R.string.email), txtEmail.text.toString())
            editor.putInt(this.getString(R.string.password), txtPassword.text.toString().hashCode())
            editor.putBoolean(this.getString(R.string.firstTime), false)
            editor.apply()

            startActivity(Intent(this, MainActivity::class.java))
        }



    }
}