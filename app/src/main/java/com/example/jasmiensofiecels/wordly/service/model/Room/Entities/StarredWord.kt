package com.example.jasmiensofiecels.wordly.service.model.Room.Entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * The purpose of this class is to represent the StarredWord entity
 * Created by jcels on 07/12/2018.
 */
@Entity(tableName = "Starred_Words")
data class StarredWord (
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "word") var wordTitle: String,
    @ColumnInfo(name = "date_starred") var date: Long
)