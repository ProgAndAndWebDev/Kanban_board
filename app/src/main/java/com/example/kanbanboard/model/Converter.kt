package com.example.kanbanboard.model

import androidx.room.TypeConverter
import java.util.*

class Converter {
    @TypeConverter
    fun dateToLong(data: Date) =
        data.time

    @TypeConverter
    fun longToDate(time:Long)=
        Date(time)
}