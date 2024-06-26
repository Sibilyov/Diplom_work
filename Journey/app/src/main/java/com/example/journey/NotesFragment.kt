package com.example.journey

import android.content.Intent
import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotesFragment : Fragment() , IAdaptor {

    private lateinit var  viewModel: NotesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adaptor = NotesAdaptor(this)
        recyclerView.adapter = adaptor

        viewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

        viewModel.allNotes.observe(this, Observer {
            adaptor.updateData(it)
        })
    }

    fun addNote(view: View) {
        val intent = Intent(this,AddNoteActivity::class.java)
        startActivity(intent)
    }

    override fun onNoteClick(note: Notes) {

        viewModel.deleteNote(note)

    }
}