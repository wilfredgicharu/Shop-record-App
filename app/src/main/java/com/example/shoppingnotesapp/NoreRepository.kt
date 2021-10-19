package com.example.shoppingnotesapp

import androidx.lifecycle.LiveData

interface NoreRepository {
    fun insertNote(notes: Note)
    fun getAllNotes(): LiveData<List<Note>>
    fun getNoteCount(): LiveData<Int>
}