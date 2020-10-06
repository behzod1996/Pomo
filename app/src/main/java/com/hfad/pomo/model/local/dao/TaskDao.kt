package com.hfad.pomo.model.local.dao

import androidx.room.*
import com.hfad.pomo.model.local.entity.TaskEntity
import com.hfad.pomo.model.local.entity.TaskDto

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks, projects WHERE projectId = idProject")
    suspend fun getAll(): List<TaskDto>

    @Query("SELECT * FROM tasks, projects WHERE projectId = idProject AND idTask = :id")
    suspend fun getById(id: Long): TaskDto

    @Query("SELECT * FROM tasks, projects WHERE projectId = idProject AND goal = :goal")
    suspend fun getByGoal(goal: String): TaskDto

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: TaskEntity): Long

    @Update
    suspend fun update(task: TaskEntity)

    @Delete
    suspend fun delete(task: TaskEntity)
}