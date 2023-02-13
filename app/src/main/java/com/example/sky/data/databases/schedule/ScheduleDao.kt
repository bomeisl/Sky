package com.example.sky.data.databases.schedule

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun newEvent(event: Event)

    @Update
    suspend fun updateEvent(event: Event)

    @Delete
    suspend fun deleteEvent(event: Event)

    @Query("SELECT * FROM Schedule WHERE id = :id")
    fun getEvent(id: Int): Flow<Event>

    @Query("SELECT * FROM Schedule ORDER BY event_time DESC")
    fun getAllEvents(): Flow<List<Event>>


}