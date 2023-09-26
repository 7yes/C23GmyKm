package com.jess.c23gmykm.ui.roomexample.relations.ntom

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.jess.c23gmykm.ui.roomexample.entities.Student
import com.jess.c23gmykm.ui.roomexample.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject:Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students:List<Student>
)

