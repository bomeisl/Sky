package com.example.sky.data.databases.schedule

import androidx.room.*
import com.example.sky.data.repositories.ScheduleRepository
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun newEvent(scheduleEntity: ScheduleEntity)

    @Update
    suspend fun updateEvent(scheduleEntity: ScheduleEntity)

    @Delete
    suspend fun deleteEvent(scheduleEntity: ScheduleEntity)

    @Query("SELECT * FROM scheduleEntity WHERE id = :id")
    fun getEvent(id: Int): Flow<ScheduleEntity>

    @Query("SELECT * FROM scheduleEntity ORDER BY time ASC")
    fun getAllEvents(): Flow<List<ScheduleEntity>>


}