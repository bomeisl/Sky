package com.example.sky.ui.viewModels.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sky.data.databases.schedule.Event
import com.example.sky.data.repositories.schedule.ScheduleRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.time.LocalDate
import java.time.LocalTime

class ScheduleViewModel(private val scheduleRepository: ScheduleRepository): ViewModel() {

    //UI State
    val scheduleUiState: StateFlow<EventList> =
        scheduleRepository.getAllEventsStream().map { EventList(it as MutableList<Event>) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = EventList(
                    mutableListOf( Event(0,"Wake up","get out of bed",LocalDate.now().toString(), LocalTime.now().toString(),false))
                )
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

}

data class EventList(
    var eventList: MutableList<Event> = mutableListOf<Event>()
)
