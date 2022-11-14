package com.example.notesapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCreateNote = findViewById<Button>(R.id.btnCreate)
        val lblNotes = findViewById<TextView>(R.id.lblNotes)
        val lblGreeting = findViewById<TextView>(R.id.lblGreeting)

        val pref = getSharedPreferences("USER_DETAILS", Context.MODE_PRIVATE)

        if(pref.getBoolean(this.getString(R.string.firstTime), true)) {
            startActivity( Intent(this, OnboardingActivity::class.java))
        }
        lblGreeting.setText("Welcome, ${pref.getString(this.getString(R.string.first_name), "User")}")


        val notesDB = Room.databaseBuilder(applicationContext, NoteDatabase::class.java, "note").allowMainThreadQueries().build()
        val notesDAO = notesDB.noteDao()
        val notesList = notesDAO.getAll()
        var notes = "";
        if(notesList.isEmpty()) notes = "You have no notes. Click create down below to make one."
        for(note: Note in notesList) {
            notes += "${note.title}\n${note.contents}\n${note.dateEdited}\n\n"
        }

        lblNotes.setText(notes)
        btnCreateNote.setOnClickListener() {
            startActivity( Intent(this, CreateNotesActivity::class.java))
        }
    }

}