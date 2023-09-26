package com.jess.c23gmykm.ui.roomexample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.jess.c23gmykm.ui.roomexample.entities.Director
import com.jess.c23gmykm.ui.roomexample.entities.School
import com.jess.c23gmykm.ui.roomexample.entities.Student
import com.jess.c23gmykm.ui.roomexample.entities.Subject
import com.jess.c23gmykm.ui.roomexample.relations.ntom.StudentWithSubjects
import com.jess.c23gmykm.ui.roomexample.relations.ntom.SubjectWithStudents
import com.jess.c23gmykm.ui.roomexample.relations.onetoone.SchoolAndDirector
import com.jess.c23gmykm.ui.roomexample.relations.oneton.SchoolWithStudents

@Dao
interface SchoolDao {
    // 1 to 1
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)
    @Transaction
    @Query("SELECT * FROM school WHERE schoolName= :schoolNam")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolNam: String): List<SchoolAndDirector>

    //1 to n
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)
    @Transaction
    @Query("SELECT * FROM school WHERE schoolName=:schoolNam")
    suspend fun getSchoolWithStudents(schoolNam: String): List<SchoolWithStudents>

    //n to m
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(student: Student, subject: Subject)
    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName=:subjectName")
    suspend fun getStudentsOfSubject(subjectName: String):List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName=:studentName")
    suspend fun getSubjectsOfStudent(studentName:String):List<StudentWithSubjects>
}