package com.example.data.repositoryimpl

import com.example.data.db.NoteDao
import com.example.data.db.NoteModel
import com.example.domain.model.NoteModelToUse
import com.example.domain.repository.Repository

class RepositoryImpl(private val db: NoteDao) : Repository {
    override fun getNotes(): List<NoteModelToUse> {
        return mappingToNMTUList(db.getAllNotes())
    }

    override fun insert(nmtu: NoteModelToUse) {
        db.insert(mappingToNoteModel(nmtu))
    }

    override fun delete(nmtu: NoteModelToUse) {
        db.delete(mappingToNoteModelWithId(nmtu).id)
    }

    fun mappingToNoteModelWithId(nmtu: NoteModelToUse): NoteModel {
        return NoteModel(id = nmtu.id, title = nmtu.title, description = nmtu.description)
    }
    fun mappingToNoteModel(nmtu: NoteModelToUse): NoteModel {
        return NoteModel(title = nmtu.title, description = nmtu.description)
    }
    fun mappingToNMTU(noteModel: NoteModel): NoteModelToUse {
        return NoteModelToUse(title = noteModel.title, description = noteModel.description)
    }
    fun mappingToNMTUList(nmList: List<NoteModel>): List<NoteModelToUse> {
        val nmtuList = ArrayList<NoteModelToUse>()
        nmList.forEach { nm ->
            val nmtu = NoteModelToUse(id = nm.id, title = nm.title, description = nm.description)
            nmtuList.add(nmtu)
        }
        return nmtuList
    }
}