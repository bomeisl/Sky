package com.example.sky.viewModels.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sky.data.repositories.ScheduleRepository

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