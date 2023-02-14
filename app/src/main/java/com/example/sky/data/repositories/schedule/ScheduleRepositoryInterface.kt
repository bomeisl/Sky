package com.example.sky.data.repositories.schedule

import com.example.sky.data.databases.schedule.Event
import kotlinx.coroutines.flow.Flow

interface ScheduleRepositoryInterface {

    fun getAllEventsStream(): Flow<List<Event>>

    fun getEventStream(id: Int): Flow<Event?>

    suspend fun insertEvent(event: Event)

    suspend fun deleteEvent(event: Event)

    suspend fun updateEvent(event: Event)

}