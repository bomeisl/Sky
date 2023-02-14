package com.example.sky.data.repositories.schedule

import com.example.sky.data.databases.schedule.Event
import com.example.sky.data.databases.schedule.ScheduleDao
import kotlinx.coroutines.flow.Flow

class ScheduleRepository(private val scheduleDao: ScheduleDao): ScheduleRepositoryInterface {

    override fun getAllEventsStream(): Flow<List<Event>> =
        scheduleDao.getAllEvents()


    override fun getEventStream(id: Int): Flow<Event?> =
        scheduleDao.getEvent(id)


    override suspend fun insertEvent(event: Event) =
        scheduleDao.newEvent(event)


    override suspend fun updateEvent(event: Event) =
        scheduleDao.updateEvent(event)


    override suspend fun deleteEvent(event: Event) {
        scheduleDao.deleteEvent(event)
    }

}