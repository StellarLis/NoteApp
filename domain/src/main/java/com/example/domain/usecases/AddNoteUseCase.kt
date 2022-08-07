package com.example.domain.usecases

import com.example.domain.model.NoteModelToUse
import com.example.domain.repository.Repository

class AddNoteUseCase(private val repository: Repository) {

    suspend fun execute(nmtu: NoteModelToUse) {
        repository.insert(nmtu)
    }
}