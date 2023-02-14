package com.example.sky.ui.viewModels.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sky.data.repositories.schedule.ScheduleRepository

class ScheduleEditViewModelFactory(
    private val scheduleDao: ScheduleRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScheduleEditViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ScheduleEditViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}