package com.example.sky.data.databases.checkin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime

@Entity(tableName = "Checkin")
data class Checkin (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "mood") val mood: String,
    @ColumnInfo(name = "sleep") val sleep: Int,
    @ColumnInfo(name = "favorite_part") val favorite_part: String,
    @ColumnInfo(name = "date") val date: String = LocalDate.now().toString(),
    @ColumnInfo(name = "time") val time: String = LocalTime.now().toString(),
    @ColumnInfo(name = "daily_checkin_complete")val daily_checkin_complete: Boolean = false
)