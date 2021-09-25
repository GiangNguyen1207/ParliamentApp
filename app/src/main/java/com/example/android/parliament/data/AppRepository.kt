package com.example.android.parliament.data

import androidx.lifecycle.LiveData
import com.example.android.parliament.network.MembersApi

class AppRepository(private val appDao: AppDao) {
    suspend fun fetchAllMembers(): List<ParliamentMember> = MembersApi.retrofitService.fetchAllMembers()

    fun getAllMembers(): LiveData<List<ParliamentMember>> = appDao.readAllMembers()

    suspend fun insertMember(member: ParliamentMember) = appDao.insertMember(member)
}