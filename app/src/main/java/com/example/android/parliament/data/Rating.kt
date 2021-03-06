package com.example.android.parliament.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Giang Nguyen - 1.10.2021

@Entity(tableName = "member_rating_table")
data class Rating(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo
    val personNumber: Int,

    @ColumnInfo(name = "rating")
    val rating: Float = 0F,
)