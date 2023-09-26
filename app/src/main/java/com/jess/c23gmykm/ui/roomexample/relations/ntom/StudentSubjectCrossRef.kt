package com.jess.c23gmykm.ui.roomexample.relations.ntom

import androidx.room.Entity

@Entity(primaryKeys = ["studentName","schoolName"])
data class StudentSubjectCrossRef(
    val studentName:String,
    val subjectName:String
)
