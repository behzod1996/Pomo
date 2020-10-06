package com.hfad.pomo.model

import java.util.*

data class Pomo(
    val task: Task,
    var completeDate: Date,
    var pomodoroTime: Long = 0,
    var goalAchieved: Boolean = false,
    var efficiencyMark: Int = 0,
    var retrospectiveComment: String? = null,
    var distractionCount: Int = 0,
    var id: Long = 0
)