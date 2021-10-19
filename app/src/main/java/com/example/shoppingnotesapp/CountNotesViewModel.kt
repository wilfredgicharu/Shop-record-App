package com.example.shoppingnotesapp

import android.text.AutoText
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class CountNotesViewModel(application: NoteApplication): AndroidViewModel(application) {
    private val noreRepository: NoreRepository= (application as NoteApplication).noreRepository

    fun insertNote(text: String){
        noreRepository.insertNote(Note(0,text))
    }
    fun getNoteCountLiveData(): LiveData<Int> =
        noreRepository.getNoteCount()
}