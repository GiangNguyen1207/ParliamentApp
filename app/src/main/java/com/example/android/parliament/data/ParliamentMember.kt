package com.example.android.parliament.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Giang Nguyen - 25.09.2021

@Entity(tableName = "parliament_member_table")
data class ParliamentMember (
    @PrimaryKey
    val personNumber: Int,

    @ColumnInfo(name = "seat_number")
    val seatNumber: Int = 0,

    @ColumnInfo(name = "last_name")
    val last: String,

    @ColumnInfo(name = "first_name")
    val first: String,

    @ColumnInfo(name = "party")
    val party: String,

    @ColumnInfo(name = "party_in_fin")
    val partyFinName: String? = null,

    @ColumnInfo(name = "party_in_eng")
    val partyEngName: String? = null,

    @ColumnInfo(name = "minister")
    val minister: Boolean = false,

    @ColumnInfo(name = "born_year")
    val bornYear: Int = 0,

    @ColumnInfo(name = "constituency")
    val constituency: String = "",

    @ColumnInfo(name = "picture")
    val picture: String
)