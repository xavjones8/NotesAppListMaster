package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.UUID

class CreateNotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_notes)


        val noteTitle = findViewById<EditText>(R.id.txtTitle)
        val noteContents = findViewById<EditText>(R.id.txtContents)
        val btnCreateNote = findViewById<Button>(R.id.btnSubmit)

        val currentDate = LocalDateTime.now()
        val dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
        val formattedDate = currentDate.format(dateFormatter)

        btnCreateNote.setOnClickListener() {
            val notesDB = Room.databaseBuilder(this, NoteDatabase::class.java, "note").allowMainThreadQueries().build()
            val notesDAO = notesDB.noteDao()
            notesDAO.insertAll(Note(UUID.randomUUID().hashCode(), noteTitle.text.toString(), noteContents.text.toString(), formattedDate))
            startActivity( Intent(this, MainActivity::class.java))
        }
    }
}
