package com.example.shoppingnotesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NoteListViewModel(private val noreRepository: NoreRepository): ViewModel (){
    fun getNoteListLiveData(): LiveData<List<Note>> = noreRepository.getAllNotes()
}