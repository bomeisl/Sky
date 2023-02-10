package com.example.sky.data.repositories

import com.example.sky.data.databases.schedule.ScheduleDao
import com.example.sky.data.databases.schedule.ScheduleEntity
import kotlinx.coroutines.flow.Flow

class OfflineScheduleRepository(private val scheduleDao: ScheduleDao) : ScheduleRepository {

    override fun getAllEventsStream(): Flow<List<ScheduleEntity>> = scheduleDao.getAllEvents()

    override fun getEventStream(id: Int): Flow<ScheduleEntity> = scheduleDao.getEvent(id)

    override suspend fun insertEvent(event: ScheduleEntity) = scheduleDao.newEvent(event)

    override suspend fun deleteEvent(event: ScheduleEntity) = scheduleDao.deleteEvent(event)

    override suspend fun updateEvent(event: ScheduleEntity) = scheduleDao.updateEvent(event)

}