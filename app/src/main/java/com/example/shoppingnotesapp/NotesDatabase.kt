package com.example.shoppingnotesapp

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Note::class],
    version = 1
)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}