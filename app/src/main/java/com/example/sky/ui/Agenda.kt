package com.example.sky.ui

data class AgendaItem (
    val id: Int = 0,
    val event_name: String = "",
    val event_description: String = "",
    val event_date: String = "",
    val event_time: String = "",
    val event_completed: Boolean = false,
    val event_priority: String = "",
)
