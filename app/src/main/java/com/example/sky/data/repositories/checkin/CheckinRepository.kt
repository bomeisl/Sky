package com.example.sky.data.repositories.checkin

import com.example.sky.data.databases.checkin.Checkin
import com.example.sky.data.databases.checkin.CheckinDao
import kotlinx.coroutines.flow.Flow

class CheckinRepository(private val checkinDao: CheckinDao): CheckinRepositoryInterface {

    override fun getAllCheckinsStream(): Flow<List<Checkin>> =
        checkinDao.getAllCheckins()


    override fun getCheckinStream(id: Int): Flow<Checkin?> =
        checkinDao.getCheckin(id)

    override fun getCheckinDateStream(date: String): Flow<Checkin?> =
        checkinDao.getDateCheckin(date)


    override suspend fun insertCheckin(checkin: Checkin) =
        checkinDao.newCheckin(checkin)


    override suspend fun updateCheckin(checkin: Checkin) =
        checkinDao.updateCheckin(checkin)


    override suspend fun deleteCheckin(checkin: Checkin) {
        checkinDao.deleteCheckin(checkin)
    }


}