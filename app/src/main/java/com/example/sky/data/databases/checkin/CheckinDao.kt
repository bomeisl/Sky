package com.example.sky.data.databases.checkin

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CheckinDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun newCheckin(checkin: Checkin)

    @Update
    suspend fun updateCheckin(checkin: Checkin)

    @Delete
    suspend fun deleteCheckin(checkin: Checkin)

    @Query("SELECT * FROM Checkin WHERE id = :id")
    fun getCheckin(id: Int): Flow<Checkin>

    @Query("SELECT * FROM Checkin ORDER BY time DESC")
    fun getAllCheckins(): Flow<List<Checkin>>
    
    @Query("SELECT * FROM Checkin WHERE date = :date")
    fun getDateCheckin(date: String): Flow<Checkin>

}