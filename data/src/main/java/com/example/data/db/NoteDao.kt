package com.example.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    fun insert(noteModel: NoteModel)
    @Query("DELETE FROM note_table WHERE id = :noteModelId")
    fun delete(noteModelId: Int)
    @Query("SELECT * FROM note_table")
    fun getAllNotes(): List<NoteModel>
}