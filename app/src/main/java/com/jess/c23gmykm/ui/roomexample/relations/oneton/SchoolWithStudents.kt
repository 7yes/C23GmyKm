package com.jess.c23gmykm.ui.roomexample.relations.oneton

import androidx.room.Embedded
import androidx.room.Relation
import com.jess.c23gmykm.ui.roomexample.entities.Student

data class SchoolWithStudents(
    @Embedded val school:String,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students:List<Student>
)
