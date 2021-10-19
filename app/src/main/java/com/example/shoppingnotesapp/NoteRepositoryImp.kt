package com.example.shoppingnotesapp

import androidx.lifecycle.LiveData
import java.util.concurrent.Executor

class NoteRepositoryImp(
    private val executor: Executor,
private val noteDao: NoteDao): NoreRepository {
    override fun insertNote(notes: Note) {
        executor.execute {
            noteDao.insertNote(notes)
        }
    }

    override fun getAllNotes(): LiveData<List<Note>> {
        return noteDao.loadNotes()
    }

    override fun getNoteCount(): LiveData<Int> {
        return noteDao.loadNotesCount()
    }
}