package com.example.noteapp.di

import android.content.Context
import androidx.room.Room
import com.example.data.db.NoteDao
import com.example.data.db.NoteDatabase
import com.example.data.repositoryimpl.RepositoryImpl
import com.example.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NoteDao {
        return Room
            .databaseBuilder(context, NoteDatabase::class.java, "database")
            .build()
            .noteDao()
    }
    @Provides
    @Singleton
    fun provideRepository(db: NoteDao): Repository {
        return RepositoryImpl(db)
    }
}