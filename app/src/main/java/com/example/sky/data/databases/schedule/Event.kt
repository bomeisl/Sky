package com.example.sky.data.databases.schedule

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

enum class EventPriority{
    ONE, TWO, THREE, FOUR, FIVE, UNINITIALIZED
}


@Entity(tableName = "Schedule")
data class Event(
@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
@ColumnInfo(name = "event_name") val event_name: String = "Something to Do",
@ColumnInfo(name = "event_description") val event_description: String = "Climb a tree",
@ColumnInfo(name = "event_date") val event_date: String = "Today",
@ColumnInfo(name = "event_time") val event_time: String = "5PM",
@ColumnInfo(name = "event_completed") val event_completed: Boolean = false,
@ColumnInfo(name = "event_priority") val event_priority: EventPriority = EventPriority.ONE
)


