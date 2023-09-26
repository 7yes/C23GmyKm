package com.jess.c23gmykm.ui.roomexample.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Subject(
    @PrimaryKey(false)
    val subjectName:String
)
