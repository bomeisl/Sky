package com.example.sky.ui.schedule

import com.example.sky.data.databases.schedule.Event
import com.example.sky.data.databases.schedule.EventPriority

data class EventUiState(
    val id: Int = 0,
    val event_name: String = "",
    val event_description: String = "",
    val event_date: String = "",
    val event_time: String = "",
    val event_completed: Boolean = false,
    val event_priority: String = "",
)

fun EventUiState.toEvent(): Event = Event(
    id = id,
    event_name = event_name,
    event_description = event_description,
    event_date = event_date,
    event_time = event_time,
    event_completed = event_completed,
    event_priority = when (event_priority) {
        "5" -> EventPriority.FIVE
        "4" -> EventPriority.FOUR
        "3" -> EventPriority.THREE
        "2" -> EventPriority.TWO
        "1" -> EventPriority.ONE

        else -> EventPriority.UNINITIALIZED
    }
)

fun Event.toEventUiState(): EventUiState = EventUiState(
    id = id,
    event_name = event_name,
    event_description = event_description,
    event_date = event_date.toString(),
    event_time = event_time.toString(),
    event_completed = event_completed,
)


fun EventUiState.isValid(): Boolean {
    return (event_name.isNotBlank() && event_description.isNotBlank()
            && event_date.isNotBlank() && event_time.isNotBlank()
            && event_priority.isNotBlank())
}

