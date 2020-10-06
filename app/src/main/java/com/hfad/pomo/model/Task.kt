package com.hfad.pomo.model

data class Task(
    var project : Project?,
    var goal : String?,
    var estimatedPomoCount : Int,
    var spendPomoCount : Int,
    var done : Boolean,
    var scheduledTime : Int?,
    var id : Long = 0
)