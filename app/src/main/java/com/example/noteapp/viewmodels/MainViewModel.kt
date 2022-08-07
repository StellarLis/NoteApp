package com.example.noteapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.NoteModelToUse
import com.example.domain.usecases.GetNotesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNotesListUseCase: GetNotesListUseCase
) : ViewModel() {

    var NotesList = MutableLiveData<List<NoteModelToUse>>()

    fun setNotesList() {
        viewModelScope.launch(Dispatchers.IO) {
            NotesList.postValue(getNotesListUseCase.execute())
        }
    }
}