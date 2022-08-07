package com.example.noteapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.NoteModelToUse
import com.example.domain.usecases.DeleteNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {

    fun delete(nmtu: NoteModelToUse) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteNoteUseCase.execute(nmtu)
        }
    }
}