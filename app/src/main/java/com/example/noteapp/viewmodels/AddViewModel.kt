package com.example.noteapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.NoteModelToUse
import com.example.domain.usecases.AddNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase
) : ViewModel() {

    fun addNote(title: String, desc: String) {
        val nmtu = NoteModelToUse(title = title, description = desc)
        viewModelScope.launch(Dispatchers.IO) {
            addNoteUseCase.execute(nmtu)
        }
    }
}