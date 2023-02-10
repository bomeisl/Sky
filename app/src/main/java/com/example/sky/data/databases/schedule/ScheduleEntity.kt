package com.example.sky.data.databases.schedule

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime


enum class EventPriority {
    UNINITIALIZED, ONE, TWO, THREE, FOUR, FIVE
}

@Entity
data class ScheduleEntity(
    @PrimaryKey val id: Int = -1,
    val event_name: String = "",
    val event_description: String = "",
    val event_date: LocalDate = LocalDate.now(),
    val event_time: LocalTime = LocalTime.now(),
    val event_completed: Boolean = false,
    val event_priority: EventPriority = EventPriority.ONE
)

