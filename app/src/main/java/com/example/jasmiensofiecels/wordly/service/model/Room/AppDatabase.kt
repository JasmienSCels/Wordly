package com.example.jasmiensofiecels.wordly.service.model.Room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.example.jasmiensofiecels.wordly.service.model.Room.Dao.StarredWordDao
import com.example.jasmiensofiecels.wordly.service.model.Room.Entities.StarredWord

/**
 * The purpose of this class is to
 * The Singleton pattern is used to ensure a single instance of it as the db creation is a very extensive operation
 *
 * Created by jcels on 07/12/2018.
 */
@Database(entities = arrayOf(StarredWord::class), version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun starredWordDao() : StarredWordDao

}