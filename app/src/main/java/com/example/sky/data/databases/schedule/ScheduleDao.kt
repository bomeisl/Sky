package com.example.sky.data.databases.schedule

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun newEvent(scheduleEntity: ScheduleEntity)

    @Update
    suspend fun updateEvent(scheduleEntity: ScheduleEntity)

    @Delete
    suspend fun deleteEvent(scheduleEntity: ScheduleEntity)

    @Query("SELECT * FROM Schedule WHERE id = :id")
    fun getEvent(id: Int): Flow<ScheduleEntity>

    @Query("SELECT * FROM Schedule ORDER BY event_time ASC")
    fun getAllEvents(): Flow<List<ScheduleEntity>>


}