package com.example.noteapp.di

import com.example.domain.repository.Repository
import com.example.domain.usecases.AddNoteUseCase
import com.example.domain.usecases.DeleteNoteUseCase
import com.example.domain.usecases.GetNotesListUseCase
import com.example.noteapp.viewmodels.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideGetNotesListUseCase(repository: Repository): GetNotesListUseCase {
        return GetNotesListUseCase(repository)
    }
    @Provides
    fun provideAddNoteUseCase(repository: Repository): AddNoteUseCase {
        return AddNoteUseCase(repository)
    }
    @Provides
    fun provideDeleteNoteUseCase(repository: Repository): DeleteNoteUseCase {
        return DeleteNoteUseCase(repository = repository)
    }
}