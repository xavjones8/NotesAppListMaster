package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CreateNotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_notes)

        val noteTitle = findViewById<EditText>(R.id.txtTitle)
        val noteContents = findViewById<EditText>(R.id.txtContents)
        val btnCreateNote = findViewById<Button>(R.id.btnSubmit)

        btnCreateNote.setOnClickListener() {
            startActivity( Intent(this, MainActivity::class.java))
        }
    }
}
