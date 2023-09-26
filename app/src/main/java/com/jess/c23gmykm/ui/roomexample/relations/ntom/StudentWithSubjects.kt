package com.jess.c23gmykm.ui.roomexample.relations.ntom

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.jess.c23gmykm.ui.roomexample.entities.Student
import com.jess.c23gmykm.ui.roomexample.entities.Subject

data class StudentWithSubjects(
    @Embedded val student:Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy =  Junction(StudentSubjectCrossRef::class)
    )
    val subjects:List<Subject>
)
