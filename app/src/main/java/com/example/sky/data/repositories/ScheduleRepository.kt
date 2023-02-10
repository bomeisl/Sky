package com.example.sky.data.repositories

import com.example.sky.data.databases.schedule.ScheduleEntity
import kotlinx.coroutines.flow.Flow

interface ScheduleRepository{

    fun getAllEventsStream(): Flow<List<ScheduleEntity>>

    fun getEventStream(id: Int): Flow<ScheduleEntity>

    suspend fun insertEvent(event: ScheduleEntity)

    suspend fun deleteEvent(event: ScheduleEntity)

    suspend fun updateEvent(event: ScheduleEntity)

}