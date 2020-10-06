package com.hfad.pomo.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "pomo")
data class PomoEntity(
    @PrimaryKey(autoGenerate = true)
    val idPomo: Long,

    @ColumnInfo(name = "completeDate")
    val completeDate: Long,

    @ColumnInfo(name = "pomoTime")
    val pomoTime: Long = 0,

    @ColumnInfo(name = "goalAchieved")
    val goalAchieved: Boolean = false,

    @ColumnInfo(name = "efficiencyMark")
    val efficiencyMark: Int = 0,

    @ColumnInfo(name = "retrospectiveComment")
    val retrospectiveComment: String? = null,

    @ColumnInfo(name = "distractionCount")
    val distractionCount: Int = 0,

    @ColumnInfo(name = "taskId")
    val taskId: Long)
