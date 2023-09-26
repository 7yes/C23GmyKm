package com.jess.c23gmykm.ui.roomexample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jess.c23gmykm.ui.roomexample.entities.Director
import com.jess.c23gmykm.ui.roomexample.entities.School
import com.jess.c23gmykm.ui.roomexample.entities.Student
import com.jess.c23gmykm.ui.roomexample.entities.Subject
import com.jess.c23gmykm.ui.roomexample.relations.ntom.StudentSubjectCrossRef

@Database(
    entities = [
        Director::class,
        School::class,
        Student::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase:RoomDatabase() {
    abstract val schoolDao: SchoolDao

    // en el main
    //val dao = SchoolDatabase.getInstance(this).schoolDao
    companion object{
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context):SchoolDatabase{
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE =it
                }
            }
        }
    }
}