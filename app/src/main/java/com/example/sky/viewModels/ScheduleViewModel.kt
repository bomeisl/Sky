package com.example.sky.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sky.data.databases.schedule.ScheduleEntity
import com.example.sky.data.repositories.ScheduleRepository
import kotlinx.coroutines.flow.*

class ScheduleViewModel(private val scheduleRepository: ScheduleRepository): ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    data class ScheduleUiState(val eventList: List<ScheduleEntity> = listOf())

    val scheduleUiState: StateFlow<ScheduleUiState> =
        scheduleRepository.getAllEventsStream().map { ScheduleUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ScheduleUiState()
            )



}