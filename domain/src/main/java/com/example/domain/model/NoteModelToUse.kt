package com.example.domain.model

import java.io.Serializable

class NoteModelToUse (
    val id: Int = 0,
    val title: String,
    val description: String
) : Serializable