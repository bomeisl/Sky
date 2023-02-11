package com.example.sky.data.repositories

import androidx.annotation.WorkerThread
import com.example.sky.data.databases.schedule.ScheduleDao
import com.example.sky.data.databases.schedule.ScheduleEntity
import kotlinx.coroutines.flow.Flow

class ScheduleRepository(private val scheduleDao: ScheduleDao) {

    val allEvents: Flow<List<ScheduleEntity>> = scheduleDao.getAllEvents()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(scheduleEntity: ScheduleEntity) {
        scheduleDao.newEvent(scheduleEntity)
    }

}