package com.hfad.pomo.model.local

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromTime(value: Long?): Date? =
        value?.let {
            Date(it)
        }
    @TypeConverter
    fun fromDateToTime(date : Date?) : Long? =
        date?.time
}