package com.example.jasmiensofiecels.wordly.service.model.Room.Dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.jasmiensofiecels.wordly.service.model.Room.Entities.StarredWord

/**
 * The purpose of this class is represent the StarredWord's methods for manipulating the db
 * Created by jcels on 07/12/2018.
 */
@Dao
interface StarredWordDao {

    @Query("SELECT * FROM Starred_Words")
    fun getAll() : List<StarredWord>

    @Query("SELECT * FROM Starred_Words WHERE word = :word")
    fun getWord(word : String) : StarredWord

    @Insert
    fun insertStarredWord(word : StarredWord)

    @Delete
    fun deleteWord(word : StarredWord)
}