package com.jess.c23gmykm.ui.roomexample.relations.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.jess.c23gmykm.ui.roomexample.entities.Director
import com.jess.c23gmykm.ui.roomexample.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName", //school
        entityColumn = "schoolName" //Director
    )
    val director: Director
)
