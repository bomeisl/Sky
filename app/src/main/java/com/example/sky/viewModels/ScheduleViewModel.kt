package com.example.sky.viewModels

import android.view.View
import androidx.lifecycle.*
import com.example.sky.data.databases.schedule.ScheduleEntity
import com.example.sky.data.repositories.ScheduleRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ScheduleViewModel(private val repository: ScheduleRepository): ViewModel() {

    val allEvents: LiveData<List<ScheduleEntity>> = repository.allEvents.asLiveData()

    fun insert(event: ScheduleEntity) = viewModelScope.launch {
        repository.insert(event)
    }

    class EventViewModelFactory(private val repository: ScheduleRepository): ViewModelProvider.Factory {
        override fun<T: ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ScheduleViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ScheduleViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }

}