package com.example.domain.repository

import com.example.domain.model.NoteModelToUse

interface Repository {
    fun getNotes(): List<NoteModelToUse>
    fun insert(nmtu: NoteModelToUse)
    fun delete(nmtu: NoteModelToUse)
}