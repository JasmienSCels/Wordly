package com.example.jasmiensofiecels.wordly.service.model.Room

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 * The purpose of this class is to convert complex data types for Room to be able to process the type
 * Created by jcels on 10/12/2018.
 */
class Converters {

    @TypeConverter
    fun fromTimestamp(timeStamp : Long?) : Date? {
        return timeStamp?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date : Date?) : Long? {
        return date?.time
    }
}