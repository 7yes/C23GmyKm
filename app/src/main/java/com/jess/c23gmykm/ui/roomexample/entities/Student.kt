package com.jess.c23gmykm.ui.roomexample.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student (
    @PrimaryKey(false)
    val studentName:String,
    val semester: Int,
    val schoolName: String
)