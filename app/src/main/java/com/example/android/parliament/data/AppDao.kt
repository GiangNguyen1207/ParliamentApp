package com.example.android.parliament.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//Giang Nguyen - 25.09.2021

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMember(member: ParliamentMember)

    @Query("SELECT DISTINCT party, party_in_fin as partyInFin, party_in_eng as partyInEng FROM parliament_member_table ORDER BY party ASC")
    fun readAllParties(): LiveData<List<Party>>

    @Query("SELECT * FROM parliament_member_table WHERE party = :party ORDER BY first_name ASC")
    fun readMemberList(party: String): LiveData<List<ParliamentMember>>

    @Query("SELECT * FROM parliament_member_table WHERE personNumber = :personNumber")
    fun getMemberDetails(personNumber: Int): LiveData<ParliamentMember>

    @Insert
    suspend fun insertRate(rate: Rating)

    @Insert
    suspend fun insertComment(comment: Comment)

    @Query("SELECT AVG(rating) from member_rating_table WHERE personNumber = :personNumber")
    fun getAverageRate(personNumber: Int): LiveData<Double>

    @Query("SELECT * from member_comment_table WHERE personNumber = :personNumber")
    fun getMemberComments(personNumber: Int): LiveData<List<Comment>>

    @Query("SELECT * from member_comment_table WHERE personNumber = :personNumber ORDER BY id DESC LIMIT 1")
    fun getLatestComment(personNumber: Int): LiveData<Comment>
}