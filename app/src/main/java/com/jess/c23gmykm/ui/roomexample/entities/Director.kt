package com.jess.c23gmykm.ui.roomexample.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Director(
    @PrimaryKey(false)
    val directorName: String,
    val schoolName: String
)
