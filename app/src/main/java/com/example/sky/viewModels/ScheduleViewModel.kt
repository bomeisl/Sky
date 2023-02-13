package com.example.sky.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sky.data.databases.schedule.Event
import com.example.sky.data.repositories.ScheduleRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ScheduleViewModel(scheduleRepository: ScheduleRepository): ViewModel() {

    //UI State
    val scheduleUiState: StateFlow<EventList> =
        scheduleRepository.getAllEventsStream().map { EventList(it as MutableList<Event>) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = EventList()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

}

data class EventList(
    var eventList: MutableList<Event> = mutableListOf<Event>()
)
