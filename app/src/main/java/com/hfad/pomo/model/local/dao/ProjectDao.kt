package com.hfad.pomo.model.local.dao

import androidx.room.*
import com.hfad.pomo.model.local.entity.ProjectEntity

@Dao
interface ProjectDao {

    @Query("SELECT * FROM projects")
    suspend fun getAll(): List<ProjectEntity>

    @Query("SELECT * FROM projects WHERE idProject = :id")
    suspend fun getById(id: Long): ProjectEntity

    @Query("SELECT * FROM projects WHERE projectName = :projectName")
    suspend fun getByName(projectName: String): ProjectEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(project: ProjectEntity): Long

    @Update
    suspend fun update(project: ProjectEntity)

    @Delete
    suspend fun delete(project: ProjectEntity)
}