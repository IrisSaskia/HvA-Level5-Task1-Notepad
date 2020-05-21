package com.example.notepadkotlin.ui.edit

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.notepadkotlin.R

import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.content_edit.*
import java.util.*

class EditActivity : AppCompatActivity() {
    private lateinit var editViewModel: EditViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setSupportActionBar(toolbar)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        fab.setOnClickListener {

            editViewModel.note.value?.apply {
                title = etTitle.text.toString()
                lastUpdated = Date()
                text = etNote.text.toString()
            }

            editViewModel.updateNote()
        }
    }

    private fun initViewModel() {
        editViewModel = ViewModelProvider(this).get(EditViewModel::class.java)
        editViewModel.note.value = intent.extras?.getParcelable(EXTRA_NOTE)!!

        editViewModel.note.observe(this, Observer { note ->
            if (note != null) {
                etTitle.setText(note.title)
                etNote.setText(note.text)
            }
        })

        editViewModel.error.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        editViewModel.success.observe(this, Observer { success ->
            if (success) finish()
        })
    }

    companion object {
        const val EXTRA_NOTE = "EXTRA_NOTE"
    }
}