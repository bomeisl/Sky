package com.example.sky.viewModels.schedule

import androidx.lifecycle.ViewModel
import com.example.sky.data.databases.schedule.Event
import com.example.sky.data.repositories.ScheduleRepository

class ScheduleEditViewModel(private val scheduleRepository: ScheduleRepository): ViewModel() {

    //Database CRUD transactions
    suspend fun addEvent(event: Event) {
        scheduleRepository.insertEvent(event)
    }

    suspend fun updateEvent(event: Event) {
        scheduleRepository.updateEvent(event)
    }

    suspend fun deleteEvent(event: Event) {
        scheduleRepository.deleteEvent(event)
    }

}