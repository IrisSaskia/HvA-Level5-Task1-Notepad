package com.example.notepadkotlin.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notepadkotlin.database.NoteRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val noteRepository = NoteRepository(application.applicationContext)

    val note = noteRepository.getNotepad()
}