package com.example.notesapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCreateNote = findViewById<Button>(R.id.btnCreate)
        val lblNotes = findViewById<TextView>(R.id.lblNotes)

        btnCreateNote.setOnClickListener() {
            startActivity( Intent(this, CreateNotesActivity::class.java))
        }
    }
}