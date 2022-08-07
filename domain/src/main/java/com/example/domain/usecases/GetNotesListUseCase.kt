package com.example.domain.usecases

import com.example.domain.model.NoteModelToUse
import com.example.domain.repository.Repository

class GetNotesListUseCase(private val repository: Repository) {

    suspend fun execute(): List<NoteModelToUse> {
        return repository.getNotes()
    }
}