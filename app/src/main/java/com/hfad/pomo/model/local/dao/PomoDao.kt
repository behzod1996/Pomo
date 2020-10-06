package com.hfad.pomo.model.local.dao

import androidx.room.*
import com.hfad.pomo.model.local.entity.PomoDto
import com.hfad.pomo.model.local.entity.PomoEntity
import java.util.*

@Dao
interface PomoDao {
    @Query("""SELECT * FROM pomo
                    INNER JOIN tasks ON taskId = idTask
                    LEFT OUTER JOIN projects ON projectId = idProject""")
    suspend fun getAll(): List<PomoDto>

    @Query("""SELECT * FROM pomo
                    INNER JOIN tasks ON taskId = idTask
                    LEFT OUTER JOIN projects ON projectId = idProject
                    WHERE idPomo = :id""")
    suspend fun getById(id: Long): PomoDto

    @Query("SELECT COUNT(*) FROM pomo WHERE completeDate BETWEEN :beginDate AND :endDate")
    fun getCountInPeriod(beginDate: Date, endDate: Date): Long

    @Query("""SELECT * FROM pomo
                    INNER JOIN tasks ON taskId = idTask
                    LEFT OUTER JOIN projects ON projectId = idProject
                    WHERE completeDate BETWEEN :beginDate AND :endDate""")
    fun getPomodorosInPeriod(beginDate: Date, endDate: Date): List<PomoDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pomo: PomoEntity): Long

    @Update
    suspend fun update(pomo: PomoEntity)

    @Delete
    suspend fun delete(pomod: PomoEntity)
}