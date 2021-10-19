package com.example.shoppingnotesapp

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class NoteApplication: Application() {
    lateinit var notesDatabase: NotesDatabase
    lateinit var noreRepository: NoreRepository

    override fun onCreate() {
        super.onCreate()
        notesDatabase= Room.databaseBuilder(applicationContext,
        NotesDatabase::class.java, "notes-db").build()

        noreRepository= NoteRepositoryImp(
            Executors.newSingleThreadExecutor(),
            notesDatabase.noteDao()
        )
    }
}