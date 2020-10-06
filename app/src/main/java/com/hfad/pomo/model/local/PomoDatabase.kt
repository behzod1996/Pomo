package com.hfad.pomo.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hfad.pomo.model.local.dao.PomoDao
import com.hfad.pomo.model.local.dao.ProjectDao
import com.hfad.pomo.model.local.dao.TaskDao
import com.hfad.pomo.model.local.entity.PomoEntity
import com.hfad.pomo.model.local.entity.ProjectEntity
import com.hfad.pomo.model.local.entity.TaskEntity

@TypeConverters(Converters::class)
@Database(entities = [PomoEntity::class, TaskEntity::class, ProjectEntity::class], version = 3)
abstract class PomoDatabase : RoomDatabase(){

    abstract fun getPomoDao() : PomoDao

    abstract fun getProjectDao() : ProjectDao

    abstract fun getTaskDao() : TaskDao

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, PomoDatabase::class.java, "PomoDatabase.db")
                .build()
    }
}