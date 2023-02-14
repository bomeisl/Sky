package com.example.sky.data.repositories.checkin

import com.example.sky.data.databases.checkin.Checkin
import kotlinx.coroutines.flow.Flow

interface CheckinRepositoryInterface {

    fun getAllCheckinsStream(): Flow<List<Checkin>>

    fun getCheckinStream(id: Int): Flow<Checkin?>

    fun getCheckinDateStream(date: String): Flow<Checkin?>

    suspend fun insertCheckin(checkin: Checkin)

    suspend fun deleteCheckin(checkin: Checkin)

    suspend fun updateCheckin(checkin: Checkin)

}